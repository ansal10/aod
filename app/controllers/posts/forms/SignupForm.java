package controllers.posts.forms;

import play.data.Form;
import play.data.validation.Constraints;

/**
 * Created by amd on 7/21/15.
 */
public class SignupForm {

    @Constraints.Required
    @Constraints.Pattern(value = "[a-zA-Z0-9_]+", message = "Only alphabets , numbers and _ are allowed")
    public String username;

    @Constraints.Required
    public String password;

    @Constraints.Required
    public String confirmPassword;

    @Constraints.Required
    @Constraints.Email(message = "Email is not valid")
    public String email;

    @Constraints.Required
    public String firstName;

    @Constraints.Required
    public String lastName;

    @Constraints.Required
    public String nickName;

    public String profilePicURL;





    /**
     * GETTERS
     * SETTERS
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public void setProfilePicURL(String profilePicURL) {
        this.profilePicURL = profilePicURL;
    }
}
