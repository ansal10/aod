package controllers.posts.mailer;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by amd on 7/22/15.
 */
public class EMailer {
    private static final String USERNAME="anas.ansal10@gmail.com";
    private static final String PASSWORD="chamindavas11";
    private String to;
    private String from;
    private String host;
    private String subject;
    private String content;

    public EMailer(String to, String from, String host, String subject, String content) {
        this.to = to;
        this.from = from;
        if(host!=null)
            this.host = host;
        else
            this.host = "localhost";
        this.subject = subject;
        this.content = content;
    }

    public boolean sendMail(){
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom( new InternetAddress(this.from));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(this.to));
            message.setSubject(this.subject);
            message.setText(this.content);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
