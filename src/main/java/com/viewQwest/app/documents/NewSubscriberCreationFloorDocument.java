package com.viewQwest.app.documents;

import com.viewQwest.app.contexts.DataPansContext;
import com.viewQwest.app.enums.Gender;
import com.viewQwest.app.scripts.StartDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.io.File;

public class NewSubscriberCreationFloorDocument extends StartDriver {
    private final DataPansContext context;

    public NewSubscriberCreationFloorDocument(DataPansContext context) {
        this.context = context;
    }

    public void createNewSubscriber() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 20);
            webDriver.findElement(By.className(context.getTypeOfSubscription())).click();


            webDriver.findElement(By.xpath("//div[contains(text(),'" + context.getDataPlan() + "')] /ancestor::div[2]/div[2]")).click();
            webDriver.findElement(By.id("postal")).sendKeys(context.getPostalCode());
            if (context.setLandedPremises(true)) {
                webDriver.findElement(By.xpath("//input[@id='landed']/../ins")).click();
            } else {
                webDriver.findElement(By.id("floor")).sendKeys(context.getFloorLevel());
                webDriver.findElement(By.id("unit")).sendKeys(context.getUnitNumber());
            }
            webDriver.findElement(By.id("check-coverage-button")).click();

//        Go to next page
            wait.until(ExpectedConditions.elementToBeClickable(By.className("results-next-button"))).click();
            Select initials = new Select(webDriver.findElement(By.id("name_salutationacc2")));
            initials.selectByVisibleText(context.getInitials());
            webDriver.findElement(By.id("firstName")).sendKeys(context.getFirstName());
            webDriver.findElement(By.id("lastName")).sendKeys(context.getLastName());
            webDriver.findElement(By.id("nric")).sendKeys(context.getNricOrPassport());

//        Select DOB
            String[] date = context.getDob().split("-");
            String y = date[0];
            String m = date[1];
            String d = date[2];
            wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("dob")))).click();
            Select year = new Select(webDriver.findElement(By.className("ui-datepicker-year")));
            year.selectByValue(y);
            Select month = new Select(webDriver.findElement(By.className("ui-datepicker-month")));
            month.selectByValue(m);
            WebElement day = webDriver.findElement(By.xpath("//a[contains(@class, 'ui-state-default') and contains(text(),'" + d + "') ] "));
            day.click();

            Select nationality = new Select(webDriver.findElement(By.id("nationality")));
            nationality.selectByVisibleText(context.getNationality());
            webDriver.findElement(By.id("phone")).sendKeys(context.getPhoneNumber());
            webDriver.findElement(By.id("mobile")).sendKeys(context.getMobileNumber());
            webDriver.findElement(By.id("email")).sendKeys(context.getEmailAddress());
            if (!context.getGender().equals(Gender.Male.toString())) {
                webDriver.findElement(By.xpath("//input[contains(@name, 'gender') and contains(@value,'Female')] /parent::div/ins")).click();
            }
//        Go to next page
            wait.until(ExpectedConditions.elementToBeClickable(By.id("next"))).click();

//        ViewQwest service plan page
            Select fiberGard = new Select(webDriver.findElement(By.id("fiberGuard")));
            fiberGard.selectByValue(context.getFiberGuard());

            for (String x : context.getHardware()) {
                WebElement selectHardware = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//div[@class='routerName' and contains(text(),'" + x + "')] /../div[2]"))));
                selectHardware.click();
            }

            if (context.getOneVoiceAddOnSubscribe() != null) {
                webDriver.findElement(By.xpath("//input[@id='" + context.getOneVoiceAddOnSubscribe() + "']/../ins")).click();
            }
            if (context.getOneVoiceAddOnNumber() != null) {
                webDriver.findElement(By.xpath("//input[@id='" + context.getOneVoiceAddOnNumber() + "']/../ins")).click();
            }
            webDriver.findElement(By.xpath("//input[@id='" + context.getOnsiteInstallation() + "']/../ins")).click();
            webDriver.findElement(By.xpath("//input[@id='" + context.getTvPlayer() + "']/../ins")).click();
            if (context.setEnableNetflix(true)) {
                webDriver.findElement(By.xpath("//input[contains(@name, 'netflix')and contains(@value,'Yes')]")).click();
                webDriver.findElement(By.xpath("//input[@id='" + context.getNetflixCountry() + "']/../ins")).click();
            } else {
                webDriver.findElement(By.xpath("//input[contains(@name, 'netflix')and contains(@value,'No')]")).click();
            }
            webDriver.findElement(By.id("remarksField")).sendKeys(context.getRemark());

            Select promoter = new Select(webDriver.findElement(By.id("salesStaffName")));
            promoter.selectByValue(context.getPromoterName());
            Select reference = new Select(webDriver.findElement(By.id("referenceName")));
            reference.selectByValue(context.getReferenceName());
            wait.until(ExpectedConditions.elementToBeClickable(By.id("next"))).click();

            WebElement uploadFront = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("file"))));
            uploadFront.sendKeys(context.getFrontPage());
            WebElement waitUntilConfirmMessage = wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm")));
            Assert.assertTrue(waitUntilConfirmMessage.isDisplayed());
            waitUntilConfirmMessage.click();
            Thread.sleep(1000);
            WebElement uploadBack = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("file2"))));
            uploadBack.sendKeys(context.getFrontPage());
            WebElement waitUntilConfirmMessage2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm")));
            Assert.assertTrue(waitUntilConfirmMessage2.isDisplayed());
            waitUntilConfirmMessage2.click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='next' and @type='button']"))).click();

            Thread.sleep(10000);
            webDriver.findElement(By.xpath("//input[@name='terms_and_conditions']/../ins")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("next"))).click();
            WebElement redirectWindow = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//button/span[contains(text(),'Ok')]"))));
            Assert.assertTrue(redirectWindow.isDisplayed());
            redirectWindow.click();
            String paymentPage = webDriver.getCurrentUrl();
            Assert.assertEquals(paymentPage, "https://signup.viewqwest.com/payment.php#b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void createNewOSP2Gbps() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 20);
            //webDriver.findElement(By.className(context.getTypeOfSubscription())).click();
            System.out.println("Initiate");
            webDriver.findElement(By.xpath("//*[@id=\"index_plan\"]/div[1]/div/div/div/div[2]/button")).click();
            System.out.println("Select Package");
            webDriver.findElement(By.id("firstName")).sendKeys(context.getFirstName());
            
            webDriver.findElement(By.id("lastName")).sendKeys(context.getLastName());
            webDriver.findElement(By.id("email")).sendKeys(context.getEmailAddress());
            webDriver.findElement(By.id("mobile")).sendKeys(context.getMobileNumber());
            webDriver.findElement(By.id("check-coverage-button")).click();
            webDriver.findElement(By.id("postal")).sendKeys(context.getPostalCode());
            webDriver.findElement(By.id("check-coverage-button")).click();
            System.out.println("Filed the form");
            Thread.sleep(5000);
            webDriver.findElement(By.id("next")).click();
            Thread.sleep(10000);

            webDriver.findElement(By.className("signupButton1")).click();
            System.out.println("Select the pacakage");

            JavascriptExecutor jse = (JavascriptExecutor) webDriver;
            jse.executeScript("scroll(0, 250);");
            System.out.println("Scrolling");

            webDriver.findElement(By.className("plan2gbpsSNYearly")).click();

            System.out.println("Select 2 Year ");

            webDriver.findElement(By.id("routerOption6")).click();
            System.out.println("Select Router");
            webDriver.findElement(By.id("remarksField")).sendKeys(context.getRemark());

            Select fiberGard = new Select(webDriver.findElement(By.id("fiberGuardOption")));
            fiberGard.selectByValue(context.getFiberGuard());

            Select oneSiteSelect = new Select(webDriver.findElement(By.id("twoGbps_installation")));
            oneSiteSelect.selectByValue(context.getOnsiteInstallation());

            Select numberNonDisplay = new Select(webDriver.findElement(By.id("ovNND")));
            numberNonDisplay.selectByValue(context.getNumberNonDisplay());

            webDriver.findElement(By.id("next")).click();
            Thread.sleep(10000);

            webDriver.findElement(By.id("nric")).sendKeys(context.getNricOrPassport());
            webDriver.findElement(By.id("phone")).sendKeys(context.getPhoneNumber());
            webDriver.findElement(By.id("gender"));
            webDriver.findElement(By.id("dob")).click();
            webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]")).click();

            WebElement uploadFront = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("file"))));
            uploadFront.sendKeys(context.getFrontPage());
            WebElement waitUntilConfirmMessage = wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm")));
            Assert.assertTrue(waitUntilConfirmMessage.isDisplayed());
            waitUntilConfirmMessage.click();
            Thread.sleep(1000);

            WebElement uploadBack = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("file2"))));
            uploadBack.sendKeys(context.getBackPage());
            WebElement waitUntilConfirmMessage2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm")));
            Assert.assertTrue(waitUntilConfirmMessage2.isDisplayed());
            waitUntilConfirmMessage2.click();
            Thread.sleep(5000);
            webDriver.findElement(By.id("next")).click();
            Thread.sleep(10000);
            //webDriver.findElement(By.id("next")).click();
            //Thread.sleep(10000);

            //webDriver.findElement(By.className("icheckbox_flat-red")).click();
            //webDriver.findElement(By.id("next")).click();
            //Thread.sleep(5000);

           // webDriver.findElement(By.className("ui-button-text-only")).click();
            //Thread.sleep(10000);
            //webDriver.findElement(By.xpath("//*[@id=\"input-creditCardHolderName\"]")).sendKeys(context.getCreditCardName());
            //webDriver.findElement(By.xpath("//*[@id=\"input-creditCardHolderName\"]")).sendKeys(context.getCreditCardNumber());
            //Thread.sleep(10000);


        } catch (InterruptedException e) {
            e.printStackTrace();


        }
    }


    public void createNewOSP1Gbps() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 20);
            //webDriver.findElement(By.className(context.getTypeOfSubscription())).click();

            System.out.println("Initiate");

            webDriver.findElement(By.className("planFooter_2")).click();
            webDriver.findElement(By.id("firstName")).sendKeys(context.getFirstName());
            webDriver.findElement(By.id("lastName")).sendKeys(context.getLastName());
            webDriver.findElement(By.id("email")).sendKeys(context.getEmailAddress());
            webDriver.findElement(By.id("mobile")).sendKeys(context.getMobileNumber());
            webDriver.findElement(By.id("check-coverage-button")).click();
            webDriver.findElement(By.id("postal")).sendKeys(context.getPostalCode());
            webDriver.findElement(By.id("check-coverage-button")).click();
            Thread.sleep(5000);
            webDriver.findElement(By.id("next")).click();
            Thread.sleep(10000);

            webDriver.findElement(By.className("signupButton2")).click();

            JavascriptExecutor jse = (JavascriptExecutor) webDriver;
            jse.executeScript("scroll(0, 250);");

            webDriver.findElement(By.className("plan1gbpsSNMonthly")).click();

            webDriver.findElement(By.id("routerOption4")).click();
            webDriver.findElement(By.id("remarksField")).sendKeys(context.getRemark());


            Select fiberGard = new Select(webDriver.findElement(By.id("fiberGuardOption")));
            fiberGard.selectByValue(context.getFiberGuard());

            Select oneVoice = new Select(webDriver.findElement(By.id("OvOption")));
            oneVoice.selectByValue(context.getOneVoiceAddOnSubscribe());

            Select oneSiteSelect = new Select(webDriver.findElement(By.id("twoGbps_installation")));
            oneSiteSelect.selectByValue(context.getOnsiteInstallation());

            //Select numberNonDisplay = new Select(webDriver.findElement(By.id("ovNND")));
            //numberNonDisplay.selectByValue(context.getNumberNonDisplay());

            webDriver.findElement(By.id("next")).click();
            Thread.sleep(10000);

            webDriver.findElement(By.id("nric")).sendKeys(context.getNricOrPassport());
            webDriver.findElement(By.id("phone")).sendKeys(context.getPhoneNumber());
            webDriver.findElement(By.id("gender"));
            webDriver.findElement(By.id("dob")).click();
            webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]")).click();

            WebElement uploadFront = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("file"))));
            uploadFront.sendKeys(context.getFrontPage());
            WebElement waitUntilConfirmMessage = wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm")));
            Assert.assertTrue(waitUntilConfirmMessage.isDisplayed());
            waitUntilConfirmMessage.click();
            Thread.sleep(1000);

            WebElement uploadBack = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("file2"))));
            uploadBack.sendKeys(context.getBackPage());
            WebElement waitUntilConfirmMessage2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm")));
            Assert.assertTrue(waitUntilConfirmMessage2.isDisplayed());
            waitUntilConfirmMessage2.click();
            Thread.sleep(5000);
            webDriver.findElement(By.id("next")).click();
            Thread.sleep(10000);
            //webDriver.findElement(By.id("next")).click();
            //Thread.sleep(10000);

            //webDriver.findElement(By.className("icheckbox_flat-red")).click();
            //webDriver.findElement(By.id("next")).click();
            //Thread.sleep(5000);

            //webDriver.findElement(By.className("ui-button-text-only")).click();
            //Thread.sleep(10000);
            //webDriver.findElement(By.xpath("//*[@id=\"input-creditCardHolderName\"]")).sendKeys(context.getCreditCardName());
            //webDriver.findElement(By.xpath("//*[@id=\"input-creditCardHolderName\"]")).sendKeys(context.getCreditCardNumber());
            //Thread.sleep(10000);


        } catch (InterruptedException e) {
            e.printStackTrace();


        }
    }

    public void createNewOSP1GbpsRaptor() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 20);
            //webDriver.findElement(By.className(context.getTypeOfSubscription())).click();

            System.out.println("Initiate");

            webDriver.findElement(By.className("planFooter_3")).click();
            webDriver.findElement(By.id("firstName")).sendKeys(context.getFirstName());
            webDriver.findElement(By.id("lastName")).sendKeys(context.getLastName());
            webDriver.findElement(By.id("email")).sendKeys(context.getEmailAddress());
            webDriver.findElement(By.id("mobile")).sendKeys(context.getMobileNumber());
            webDriver.findElement(By.id("check-coverage-button")).click();
            webDriver.findElement(By.id("postal")).sendKeys(context.getPostalCode());
            webDriver.findElement(By.id("check-coverage-button")).click();
            Thread.sleep(5000);
            webDriver.findElement(By.id("next")).click();
            Thread.sleep(10000);

            webDriver.findElement(By.className("signupButton3")).click();

            JavascriptExecutor jse = (JavascriptExecutor) webDriver;
            jse.executeScript("scroll(0, 250);");

            webDriver.findElement(By.className("plan1gbpsRGBMonthly")).click();

            webDriver.findElement(By.id("routerOption11")).click();
            webDriver.findElement(By.id("remarksField")).sendKeys(context.getRemark());


            Select fiberGard = new Select(webDriver.findElement(By.id("fiberGuardOption")));
            fiberGard.selectByValue(context.getFiberGuard());

            Select oneVoice = new Select(webDriver.findElement(By.id("OvOption")));
            oneVoice.selectByValue(context.getOneVoiceAddOnSubscribe());

            Select oneSiteSelect = new Select(webDriver.findElement(By.id("twoGbps_installation")));
            oneSiteSelect.selectByValue(context.getOnsiteInstallation());

            //Select numberNonDisplay = new Select(webDriver.findElement(By.id("ovNND")));
            //numberNonDisplay.selectByValue(context.getNumberNonDisplay());

            webDriver.findElement(By.id("next")).click();
            Thread.sleep(10000);

            webDriver.findElement(By.id("nric")).sendKeys(context.getNricOrPassport());
            webDriver.findElement(By.id("phone")).sendKeys(context.getPhoneNumber());
            webDriver.findElement(By.id("gender"));
            webDriver.findElement(By.id("dob")).click();
            webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]")).click();

            WebElement uploadFront = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("file"))));
            uploadFront.sendKeys(context.getFrontPage());
            WebElement waitUntilConfirmMessage = wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm")));
            Assert.assertTrue(waitUntilConfirmMessage.isDisplayed());
            waitUntilConfirmMessage.click();
            Thread.sleep(1000);

            WebElement uploadBack = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("file2"))));
            uploadBack.sendKeys(context.getBackPage());
            WebElement waitUntilConfirmMessage2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm")));
            Assert.assertTrue(waitUntilConfirmMessage2.isDisplayed());
            waitUntilConfirmMessage2.click();
            Thread.sleep(5000);
            webDriver.findElement(By.id("next")).click();
            Thread.sleep(10000);
            //webDriver.findElement(By.id("next")).click();
            //Thread.sleep(10000);

            //webDriver.findElement(By.className("icheckbox_flat-red")).click();
            //webDriver.findElement(By.id("next")).click();
            //Thread.sleep(5000);

            //webDriver.findElement(By.className("ui-button-text-only")).click();
            //Thread.sleep(10000);
            //webDriver.findElement(By.xpath("//*[@id=\"input-creditCardHolderName\"]")).sendKeys(context.getCreditCardName());
            //webDriver.findElement(By.xpath("//*[@id=\"input-creditCardHolderName\"]")).sendKeys(context.getCreditCardNumber());
            //Thread.sleep(10000);


        } catch (InterruptedException e) {
            e.printStackTrace();


        }
    }


}
