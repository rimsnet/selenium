package com.viewQwest.app.scripts;

import com.viewQwest.app.contexts.DataPansContext;
import com.viewQwest.app.documents.NewSubscriberCreationFloorDocument;
import com.viewQwest.app.enums.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

public class NEW_OSP_PACKAGE_1GBPS_RAPTER extends StartDriver{

    @Step("Step 1 : Create new subscriber")
    @Test
    public void selectPlan() {

        DataPansContext context = new DataPansContext();
        context.setTypeOfSubscription(TypeOfSubscriptions.NewSubscriber.getSubscriptionsType());
        context.setFirstName("Moh automated");
        context.setLastName("plese ignore");
        context.setEmailAddress("rimsnet_vq@gmail.com");
        context.setMobileNumber("60123456");
        context.setPostalCode("408600");
        context.setRemark("This is automated text remark");

        context.setFiberGuard(FiberGuards.fgNoThanks.toString());
        context.setOnsiteInstallation(OnsiteInstall.PerTripFree.getInstallOnsite());
        context.setNumberNonDisplay(NumberNonDisplay.NdMonth.getNumberNonDisplay());
        context.setOneVoiceAddOnSubscribe(OneVoice.NoThanks.getOneVoiceType());

        context.setNricOrPassport("N726120AT");
        context.setPhoneNumber("60123456");
        context.setGender(Gender.Male.toString());
        context.setFrontPage(new File("src/main/resources/front.jpg").getAbsolutePath());
        context.setBackPage(new File("src/main/resources/back.jpg").getAbsolutePath());

        //context.setCreditCardName("Moh Rimzan");
        //context.setCreditCardNumber("4242424242424242");

        NewSubscriberCreationFloorDocument subscriber = new NewSubscriberCreationFloorDocument(context);
        subscriber.createNewOSP1GbpsRaptor();
    }
}
