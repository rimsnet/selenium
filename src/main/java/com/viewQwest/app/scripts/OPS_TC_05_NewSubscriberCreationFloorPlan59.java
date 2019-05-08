package com.viewQwest.app.scripts;


import com.viewQwest.app.contexts.DataPansContext;
import com.viewQwest.app.documents.NewSubscriberCreationFloorDocument;
import com.viewQwest.app.enums.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

/**
 * TEST CASE : OPS_TC_05_NewSubscriberCreationFloorPlan59
 * DESCRIPTION : Check new user creation floor
 * SOFT DEPENDENCY : N/A
 * HARD DEPENDENCY : N/A
 */

public class OPS_TC_05_NewSubscriberCreationFloorPlan59 extends StartDriver {
    @Step("Step 1 : Create new subscriber")
    @Test
    public void selectPlan() {
        DataPansContext context = new DataPansContext();
        context.setTypeOfSubscription(TypeOfSubscriptions.NewSubscriber.getSubscriptionsType());

        context.setDataPlan(DataPlans.Bundle_2GBMonthly.getPlan());
        context.setPostalCode("408600");
        context.setLandedPremises(true);

//        Subscriber details
        context.setInitials(TypesOfInitials.Mrs.getInitialType());
        context.setFirstName("New");
        context.setLastName("Subscriber2");
        context.setNricOrPassport("8459562356");
        context.setDob("1971-10-1");
        context.setNationality("Bahraini");
        context.setPhoneNumber("01254563");
        context.setMobileNumber("01254784");
        context.setEmailAddress("newsubscriber2@gmail.com");
        context.setGender(Gender.Female.toString());

//        Service plan details
        context.setFiberGuard(FiberGuards.noFiberGuard.toString());
        context.setHardware(new String[]{Hardware.NETGEAR_Nighthawk_XR500.getHardware(), Hardware.NETGEAR_R6220_Router.getHardware(), Hardware.NETGEAR_Nighthawk_X8.getHardware()});
        context.setOneVoiceAddOnSubscribe(OneVoice.MonthlyNumberNonDisplay.getOneVoiceType());
        context.setOnsiteInstallation(OnsiteInstall.PerTrip80Annual.getInstallOnsite());
        context.setTvPlayer(TvPlayer.Player118.getPlayer());
        context.setEnableNetflix(true);
//        select country only when enable Netflix
        context.setNetflixCountry(Netflix.NETFLIX_Singapore.getCountryOfNetflix());
        context.setRemark("Sample remark for the test case. Sample remark for the test case. Sample remark for the test case. Sample remark for the test case....");
        context.setPromoterName(Promoters.HusainiAzmi.getPromoter());
        context.setReferenceName(ReferenceNames.Facebook.getReference());

        context.setFrontPage(new File("src/main/resources/front.jpg").getAbsolutePath());
        context.setBackPage(new  File("src/main/resources/back.jpg").getAbsolutePath());

        NewSubscriberCreationFloorDocument subscriber = new NewSubscriberCreationFloorDocument(context);
        subscriber.createNewSubscriber();
    }


}
