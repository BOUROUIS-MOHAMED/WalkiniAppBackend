package com.walkini;

import com.walkini.controllers.EmailSenderController;
import com.walkini.controllers.InitialDataForMobileController;
import com.walkini.controllers.LastModificationDateController;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class Main {
    @Autowired
    private EmailSenderController senderController;
private final InitialDataForMobileController initialDataForMobileController;
private final LastModificationDateController lastModificationDateController;

    public Main(InitialDataForMobileController InitialDataForMobileController, LastModificationDateController lastModificationDateController) {

        this.initialDataForMobileController = InitialDataForMobileController;
        this.lastModificationDateController = lastModificationDateController;
    }

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("Hello Mohamed ,I have just started up, i will initial your server fake data right now, good luck , i will inform you when i finish");
        initialDataForMobileController.initialServerLunchData();
        System.out.println("This is fast right ? :p");

    }

/*    @EventListener(ApplicationReadyEvent.class)
    public void senMail() throws MessagingException {
        System.out.println("i will try to send this mail");
        senderController.sendHtmlEmail();
    }*/
@EventListener(ApplicationReadyEvent.class)
public void initDate() throws MessagingException {
    String date=LocalDateTime.now().toString();
    lastModificationDateController.setLastModificationDate(date);
    System.out.println("LAST SERVER MODIFICATION DATE UPDATED TO: "+date);
}



}
