package controllers.posts.mailer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EMailerTest {

    @Test
    public void sendMailTest(){
        EMailer mailer = new EMailer("anas.ansal10@groupon.com","xyz@abc.com","localhost","Hello","This is Working");
        boolean retval = mailer.sendMail();
        Assert.assertTrue(retval);
    }
}