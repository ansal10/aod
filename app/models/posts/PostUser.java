package models.posts;

import javax.persistence.*;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Model;
import com.avaje.ebeaninternal.server.lib.util.Str;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import controllers.posts.forms.SignupForm;
import org.joda.time.DateTime;
import play.data.Form;
import play.data.validation.Constraints;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amd on 7/21/15.
 */
@Entity
public class PostUser extends Model {

    private static final List<String> UNIQUE_EMAIL_NOT_REQUIRED = Arrays.asList("@yahoo.com");

    @Id
    public Long id;

    public Boolean isSuperuser;

    public Boolean isActive;

    public DateTime createdOn;

    @Column(unique = true)
    public String username;

    @Constraints.Email(message = "Email is invalid")
    @Constraints.Required(message = "Value is required")
    @Column(unique = true)
    public String email;

    @Column(unique = true)
    public String uniqueEmail;

    @Constraints.Required
    public String password;

    @OneToMany(mappedBy = "user")
    public List<PostComment> comments;

    @OneToMany(mappedBy = "user")
    public List<PostPost> posts;

    @OneToMany(mappedBy = "user")
    public List<PostLike> likes;

    @OneToOne(mappedBy = "user")
    public PostProfile profile;

    public PostUser(Boolean isSuperuser, Boolean isActive, String email,  String password, String username) {
        this.isSuperuser = isSuperuser;
        this.isActive = isActive;
        this.email = email;
        this.uniqueEmail = email.replace(".","");
        this.password = Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
        this.createdOn = new DateTime();
        this.username = username;
    }

    public static PostUser createUserFromForm(SignupForm signupForm) {
        return new PostUser(false, true, signupForm.getEmail(), signupForm.getPassword(), signupForm.getUsername());
    }

    public boolean exist(){


        PostUser loginUser;
        if(isUniqueEmailCheckRequired())
            loginUser = PostUser.find.where().disjunction().add(Expr.eq("username", this.getUsername()))
                    .add(Expr.eq("email", this.getEmail()))
                    .add(Expr.eq("uniqueEmail", this.getUniqueEmail())).findUnique();
        else
            loginUser = PostUser.find.where().disjunction().add(Expr.eq("username", this.getUsername()))
                    .add(Expr.eq("email", this.getEmail())).findUnique();



        return loginUser != null;

    }

    public static boolean checkLoginByEmail(String email, String password){
        return PostUser.find.where().eq("email",email)
                .eq("password", Hashing.sha256().hashString(password, Charsets.UTF_8).toString())
                .findUnique()!=null;

    }
    public static boolean checkLoginByUsername(String username, String password){
        return PostUser.find.where().eq("username",username)
                .eq("password", Hashing.sha256().hashString(password, Charsets.UTF_8).toString())
                .findUnique()!=null;

    }
    public static boolean checkUserLogin(String email, String username , String password){
        return checkLoginByEmail(email, password) || checkLoginByUsername(username, password);
    }

    public static Finder<String, PostUser> find = new Finder<String,PostUser>(PostUser.class);

    public boolean isUniqueEmailCheckRequired(){
        for (String email : UNIQUE_EMAIL_NOT_REQUIRED) {
            if (this.email.endsWith(email))
                return false;
        }
        return true;
    }














    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public DateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniqueEmail() {
        return uniqueEmail;
    }

    public void setUniqueEmail(String uniqueEmail) {
        this.uniqueEmail = uniqueEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }

    public List<PostPost> getPosts() {
        return posts;
    }

    public void setPosts(List<PostPost> posts) {
        this.posts = posts;
    }

    public List<PostLike> getLikes() {
        return likes;
    }

    public void setLikes(List<PostLike> likes) {
        this.likes = likes;
    }

    public PostProfile getProfile() {
        return profile;
    }

    public void setProfile(PostProfile profile) {
        this.profile = profile;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
