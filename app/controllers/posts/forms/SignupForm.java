package controllers.posts.forms;

import play.data.Form;
import play.data.validation.Constraints;

/**
 * Created by amd on 7/21/15.
 */
public class SignupForm {

    @Constraints.Required
    public String username;

    @Constraints.Required
    public String password;

    @Constraints.Required
    public String confirmPassword;

    @Constraints.Required
    @Constraints.Email
    public String email;

    @Constraints.Required
    public String fName;

    @Constraints.Required
    public String lName;

    @Constraints.Required
    public String nickName;

    public String profilePicURL;

    public static Form<SignupForm> getSignupForm(){
        return Form.form(SignupForm.class);
    }

}
