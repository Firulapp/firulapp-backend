package com.github.firulapp.util;

import com.github.firulapp.dto.AppUserProfileDto;
import com.github.firulapp.dto.CityDto;
import com.github.firulapp.dto.PetDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class EmailUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtils.class);
    public static final String MAIL_SMTP_USER = "mail.smtp.user";
    public static final String MAIL_SMTP_PASSWORD = "mail.smtp.password";
    public static final String MAIL_SMTP_HOST = "mail.smtp.host";


    public void sendAdoptionRequest(PetDto pet, AppUserProfileDto adoptingUser, AppUserProfileDto petOwner, CityDto cityDto){
        LOGGER.info("Construyendo email de solicitud de adopción");
        //Configure mailing properties
        Properties props = new Properties();
        try (InputStream input =new FileInputStream("src/main/resources/application.properties")){
            props.load(input);
            //Add recipient
            String to = petOwner.getEmail();
            //Add sender
            String from = props.getProperty(MAIL_SMTP_USER);
            //Get the Session object
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, EncryptUtils.base64ToString(props.getProperty(MAIL_SMTP_PASSWORD)));
                }
            });
            //Create a default message object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            //Set subject and body
            message.setSubject("Solicitud de adopción - " + pet.getName().toUpperCase(Locale.ROOT));
            message.setText(
                    "Hola " + petOwner.getName() + "!\n"+
                            "El usuario "+ adoptingUser.getUsername() + " de nombre "+ adoptingUser.getName() +
                            " " + adoptingUser.getSurname() + " con " + adoptingUser.getDocumentType() + " número " +
                            adoptingUser.getDocument() + " desea ponerse en contacto contigo para adoptar a " +
                            pet.getName() +  ".\nTe dejamos aquí la información del usuario para que puedan " +
                            "ponerse en contacto:\n" +
                            "Nombre completo: " + adoptingUser.getName() + " " + adoptingUser.getSurname() + "\n" +
                            "Ciudad: " + cityDto.getName() + "\n" +
                            "Email: " + adoptingUser.getEmail() + "\n"
            );

            //Transport message
            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty(MAIL_SMTP_HOST),
                                props.getProperty(MAIL_SMTP_USER),
                                props.getProperty(MAIL_SMTP_PASSWORD));
            transport.sendMessage(message, message.getAllRecipients());
            LOGGER.info("Solicitud de adopción enviada");
            transport.close();
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
}
