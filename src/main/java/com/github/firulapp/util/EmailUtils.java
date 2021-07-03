package com.github.firulapp.util;

import com.github.firulapp.domain.AppUserDetails;
import com.github.firulapp.domain.Pet;
import com.github.firulapp.dto.*;
import com.github.firulapp.exceptions.EmailUtilsException;
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
    public static final String PROPERTIES_FILE = "src/main/resources/application.properties";

    public void sendAdoptionRequest(PetDto pet, AppUserProfileDto adoptingUser,
                                    AppUserProfileDto petOwner, CityDto cityDto) throws EmailUtilsException{
        LOGGER.info("Construyendo email de solicitud de adopción");
        try (InputStream input =new FileInputStream(PROPERTIES_FILE)) {
            //Configure mailing properties
            Properties props = new Properties();
            props.load(input);
            //Set email parts
            String from = props.getProperty(MAIL_SMTP_USER);

            String emailSubject = "Solicitud de adopción - " + pet.getName().toUpperCase(Locale.ROOT);

            String emailText = "Hola " + petOwner.getName() + "!\n" + "El usuario " + adoptingUser.getUsername() +
                    " de nombre " + adoptingUser.getName() + " " + adoptingUser.getSurname() + " con " +
                    adoptingUser.getDocumentType() + " número " + adoptingUser.getDocument() +
                    " desea ponerse en contacto contigo para adoptar a " + pet.getName() +
                    ".\nTe dejamos aquí la información del usuario para que puedan ponerse en contacto:\n" +
                    "Nombre completo: " + adoptingUser.getName() + " " + adoptingUser.getSurname() + "\n" +
                    "Ciudad: " + cityDto.getName() + "\nEmail: " + adoptingUser.getEmail();
            //Send email
            sendEmail(petOwner, props, from, emailSubject, emailText);
            LOGGER.info("Solicitud de adopción enviada");
        } catch (IOException e) {
            throw EmailUtilsException.mailSendError();
        }
    }

    private void sendEmail(AppUserProfileDto petOwner, Properties props, String from,
                           String emailSubject, String emailText) throws EmailUtilsException {
        //Get the Session object
        Session session = getSessionInstance(props, from);
        //Creating message
        Message message = constructEmail(props, session, from, emailSubject, emailText, petOwner.getEmail());

        try {
            //Transport message
            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty(MAIL_SMTP_HOST),
                    session.getProperties().getProperty(MAIL_SMTP_USER),
                    session.getProperties().getProperty(MAIL_SMTP_PASSWORD));
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            throw EmailUtilsException.mailSendError();
        }
    }


    public void sendFosterRequest(PetDto pet, AppUserProfileDto adoptingUser,
                                  AppUserProfileDto petOwner, CityDto cityDto, int amount) throws EmailUtilsException {
        LOGGER.info("Construyendo email de solicitud de apadrinamiento");
        //Configure mailing properties
        try (InputStream input =new FileInputStream(PROPERTIES_FILE)) {
            Properties props = new Properties();

            props.load(input);

            String from = props.getProperty(MAIL_SMTP_USER);
            String emailSubject = "Solicitud de apadrinamiento - " + pet.getName().toUpperCase(Locale.ROOT);
            String emailText = "Hola " + petOwner.getName() + "!\n" +
                    "El usuario " + adoptingUser.getUsername() + " de nombre " + adoptingUser.getName() +
                    " " + adoptingUser.getSurname() + " con " + adoptingUser.getDocumentType() + " número " +
                    adoptingUser.getDocument() + " desea contribuir contigo y apadrinar a " +
                    pet.getName() + ".\nTe dejamos aquí la información del usuario para que puedan " +
                    "ponerse en contacto:\n" +
                    "Nombre completo: " + adoptingUser.getName() + " " + adoptingUser.getSurname() + "\n" +
                    "Ciudad: " + cityDto.getName() + "\n" +
                    "Email: " + adoptingUser.getEmail() + "\n" + "Monto a colaborar: " + amount;

            //Send email
            sendEmail(petOwner, props, from, emailSubject, emailText);
            LOGGER.info("Solicitud de apadrinamiento enviada");
        } catch (IOException e) {
            throw EmailUtilsException.mailSendError();
        }
    }

    private Session getSessionInstance(Properties props, String from) {
        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, EncryptUtils.base64ToString(props.getProperty(MAIL_SMTP_PASSWORD)));
            }
        });
    }

    private Message constructEmail(Properties props, Session session, String sender, String emailSubject,
                                   String emailText, String emailRecipient) throws EmailUtilsException {
        try (InputStream input =new FileInputStream(PROPERTIES_FILE)) {
            props.load(input);
            //Add sender
            //Create a default message object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            //Add recipients
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailRecipient));
            //Set subject and body
            message.setSubject(emailSubject);
            message.setText(emailText);
            return message;
        } catch (MessagingException | IOException e) {
            throw EmailUtilsException.messageBuildError();
        }
    }

    public void sendPetTransferNotificationToOriginalUser(AppUserProfileDto petOriginalUser,
                                            AppUserProfileDto petAdoptingUser, Pet petEntity) throws EmailUtilsException {
        LOGGER.info("Construyendo email de notificación de transferencia de perfil de mascota");
        //Configure mailing properties
        try (InputStream input =new FileInputStream(PROPERTIES_FILE)) {
            Properties props = new Properties();

            props.load(input);

            String from = props.getProperty(MAIL_SMTP_USER);
            String emailSubject = "Transferencia de perfil de mascota - " + petEntity.getName().toUpperCase(Locale.ROOT);
            String emailText = "Hola " + petOriginalUser.getName() + "!\n" +
                    "Has realizado la transferencia del perfil de " + petEntity.getName().toUpperCase(Locale.ROOT) +
                    " al usuario " + petAdoptingUser.getName().toUpperCase(Locale.ROOT) + " " +
                    petAdoptingUser.getSurname().toUpperCase(Locale.ROOT) + " con username " +
                    petAdoptingUser.getUsername().toUpperCase(Locale.ROOT) + ".\nRecuerda que esta acción no se puede " +
                    "deshacer. Si tu NO realizaste esta acción, por favor contáctanos al mail: " + from + "\n" +
                    "Atte.\n Equipo Firulapp.";
            //Send email
            sendEmail(petOriginalUser, props, from, emailSubject, emailText);
            LOGGER.info("Notificacion via email enviada");
        } catch (IOException e) {
            throw EmailUtilsException.mailSendError();
        }
    }
    public void sendPetTransferNotificationToAdopterUser(AppUserProfileDto petAdoptingUser, Pet petEntity) throws EmailUtilsException {
        LOGGER.info("Construyendo email de notificación de transferencia de perfil de mascota");
        //Configure mailing properties
        try (InputStream input =new FileInputStream(PROPERTIES_FILE)) {
            Properties props = new Properties();

            props.load(input);

            String from = props.getProperty(MAIL_SMTP_USER);
            String emailSubject = "Transferencia de perfil de mascota - " + petEntity.getName().toUpperCase(Locale.ROOT);
            String emailText = "Hola " + petAdoptingUser.getName() + "!\n" +
                    "Felicidades! Has adoptado a " + petEntity.getName().toUpperCase(Locale.ROOT) +
                    "!\n Su perfil en firulapp ha sido transferido a tu cuenta. Allí podras encontrar todos los datos de" +
                    " tu nueva mascota!\n" +
                    "Recuerda que esta acción no se puede deshacer. Si tu NO solicitaste la adopción de esta mascota, " +
                    "por favor contáctanos al mail: " + from + "\n" +
                    "Atte.\n Equipo Firulapp.";
            //Send email
            sendEmail(petAdoptingUser, props, from, emailSubject, emailText);
            LOGGER.info("Notificacion via email enviada");
        } catch (IOException e) {
            throw EmailUtilsException.mailSendError();
        }
    }

    public void sendOrganizationApprovalNotificationEmail(AppUserProfileDto appUserProfileDto) throws EmailUtilsException {
        LOGGER.info("Construyendo email de notificación de aprobación de solicitud de registro de organización");
        //Configure mailing properties
        try (InputStream input =new FileInputStream(PROPERTIES_FILE)) {
            Properties props = new Properties();

            props.load(input);

            String from = props.getProperty(MAIL_SMTP_USER);
            String emailSubject = "Solicitud de registro de organización aprobada - " + appUserProfileDto.getName().toUpperCase(Locale.ROOT);
            String emailText = "Hola " + appUserProfileDto.getName() + "!\n" +
                    "Felicidades! Su organización " + appUserProfileDto.getName().toUpperCase(Locale.ROOT) +
                    " con Identidad Tributaria / RUC nro. " + appUserProfileDto.getDocument() +
                    " ha sido aprobada por FIRULAPP! \n Puedes ver tu perfil en la app móvil. " +
                    "Allí podrás ofrecer tus servicios, contratar servicios y registrar a mascotas! \n" +
                    "Si tu NO solicitaste el registro de tu organización, por favor contáctanos al mail: " + from +
                    "\nAtte.\n Equipo Firulapp.";
            //Send email
            sendEmail(appUserProfileDto, props, from, emailSubject, emailText);
            LOGGER.info("Notificacion via email enviada");
        } catch (IOException e) {
            e.printStackTrace();
            throw EmailUtilsException.mailSendError();
        }
    }
}
