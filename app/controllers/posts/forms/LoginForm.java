package controllers.posts.forms;

import play.data.validation.Constraints;

/**
 * Created by amd on 7/24/15.
 */
public class LoginForm {

    @Constraints.Required
    public String username;

    @Constraints.Required
    public String password;













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
}
