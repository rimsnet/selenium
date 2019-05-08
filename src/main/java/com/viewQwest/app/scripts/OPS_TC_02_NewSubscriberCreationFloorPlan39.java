package com.viewQwest.app.scripts;


import com.viewQwest.app.contexts.DataPansContext;
import com.viewQwest.app.documents.NewSubscriberCreationFloorDocument;
import com.viewQwest.app.enums.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

/**
 * TEST CASE : OPS_TC_02_NewSubscriberCreationFloorPlan39
 * DESCRIPTION : Check new user creation floor
 * SOFT DEPENDENCY : N/A
 * HARD DEPENDENCY : N/A
 */

public class OPS_TC_02_NewSubscriberCreationFloorPlan39 extends StartDriver {
    @Step("Step 1 : Create new subscriber")
    @Test
    public void selectPlan() {
        DataPansContext context = new DataPansContext();
        context.setTypeOfSubscription(TypeOfSubscriptions.NewSubscriber.getSubscriptionsType());
        context.setDataPlan(DataPlans.Bundle_1GBMonthly.getPlan());
        context.setPostalCode("408600");
        context.setLandedPremises(false);
        context.setFloorLevel("12");
        context.setUnitNumber("10");

//        Subscriber details
        context.setInitials(TypesOfInitials.Mrs.getInitialType());
        context.setFirstName("Test");
        context.setLastName("User2");
        context.setNricOrPassport("1122556652");
        context.setDob("1980-10-1");
        context.setNationality("Bahraini");
        context.setPhoneNumber("03256972");
        context.setMobileNumber("01623569");
        context.setEmailAddress("testuser2@gmail.com");
        context.setGender(Gender.Male.toString());

//        Service plan details
        context.setFiberGuard(FiberGuards.fiberGuardMod.toString());
        context.setHardware(new String[]{Hardware.NETGEAR_Orbi_RBK40.getHardware(), Hardware.NETGEAR_Nighthawk_X8.getHardware(), Hardware.NETGEAR_Nighthawk_X4S.getHardware()});
        context.setOneVoiceAddOnSubscribe(OneVoice.MonthlySubscription.getOneVoiceType());
        context.setOneVoiceAddOnNumber(OneVoice.MonthlyNumberNonDisplay.getOneVoiceType());
        context.setOnsiteInstallation(OnsiteInstall.PerTrip120.getInstallOnsite());
        context.setTvPlayer(TvPlayer.Player118.getPlayer());
        context.setEnableNetflix(true);
//        select country only when enable Netflix
        context.setNetflixCountry(Netflix.NETFLIX_Singapore.getCountryOfNetflix());
        context.setRemark("Sample remark for the test case. Sample remark for the test case. Sample remark for the test case. Sample remark for the test case....");
        context.setPromoterName(Promoters.PearlyChow.getPromoter());
        context.setReferenceName(ReferenceNames.Google.getReference());

        context.setFrontPage(new File("src/main/resources/front.jpg").getAbsolutePath());
        context.setBackPage(new  File("src/main/resources/back.jpg").getAbsolutePath());

        NewSubscriberCreationFloorDocument subscriber = new NewSubscriberCreationFloorDocument(context);
        subscriber.createNewSubscriber();
    }


}
