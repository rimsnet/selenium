package com.viewQwest.app.scripts;


import com.viewQwest.app.contexts.DataPansContext;
import com.viewQwest.app.documents.NewSubscriberCreationFloorDocument;
import com.viewQwest.app.enums.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

/**
 * TEST CASE : OPS_TC_01_NewSubscriberCreationFloorPlan49
 * DESCRIPTION : Check new user creation floor
 * SOFT DEPENDENCY : N/A
 * HARD DEPENDENCY : N/A
 */

public class OPS_TC_01_NewSubscriberCreationFloorPlan49 extends StartDriver {
    @Step("Step 1 : Create new subscriber")
    @Test
    public void selectPlan() {
        DataPansContext context = new DataPansContext();
        context.setTypeOfSubscription(TypeOfSubscriptions.NewSubscriber.getSubscriptionsType());

        context.setDataPlan(DataPlans.New_OSP_24Months_2GBPS.getPlan());
        context.setPostalCode("408600");
        context.setLandedPremises(false);
        context.setFloorLevel("11");
        context.setUnitNumber("23");

//        Subscriber details
        context.setInitials(TypesOfInitials.Mrs.getInitialType());
        context.setFirstName("New");
        context.setLastName("User");
        context.setNricOrPassport("44556633445");
        context.setDob("1988-11-1");
        context.setNationality("Chilean");
        context.setPhoneNumber("03722441");
        context.setMobileNumber("01712221");
        context.setEmailAddress("newuser@gmail.com");
        context.setGender(Gender.Female.toString());

//        Service plan details
        context.setFiberGuard(FiberGuards.fiberGuardHigh.toString());
        context.setHardware(new String[]{Hardware.NETGEAR_Orbi_RBK40.getHardware(), Hardware.NETGEAR_R6220_Router.getHardware(), Hardware.NETGEAR_Nighthawk_X8.getHardware()});
        context.setOneVoiceAddOnSubscribe(OneVoice.AnnualSubscription.getOneVoiceType());
        context.setOneVoiceAddOnNumber(OneVoice.MonthlyNumberNonDisplay.getOneVoiceType());
        context.setOnsiteInstallation(OnsiteInstall.PerTrip80.getInstallOnsite());
        context.setTvPlayer(TvPlayer.Player118.getPlayer());
        context.setEnableNetflix(true);
//        select country only when enable Netflix
        context.setNetflixCountry(Netflix.NETFLIX_Singapore.getCountryOfNetflix());
        context.setRemark("Sample remark for the test case. Sample remark for the test case. Sample remark for the test case. Sample remark for the test case....");
        context.setPromoterName(Promoters.HusainiAzmi.getPromoter());
        context.setReferenceName(ReferenceNames.Facebook.getReference());

        context.setFrontPage(new File("src/main/resources/front.jpg").getAbsolutePath());
        context.setBackPage(new File("src/main/resources/back.jpg").getAbsolutePath());

        NewSubscriberCreationFloorDocument subscriber = new NewSubscriberCreationFloorDocument(context);
        subscriber.createNewSubscriber();
    }


}
