package controllers;

import com.avaje.ebean.Ebean;
import controllers.posts.forms.LoginForm;
import controllers.posts.forms.SignupForm;
import models.Comment;
import models.Post;
import models.posts.PostProfile;
import models.posts.PostUser;
import play.Logger;
import play.api.libs.openid.UserInfo;
import play.data.Form;
import play.filters.csrf.AddCSRFToken;
import play.filters.csrf.RequireCSRFCheck;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import play.mvc.*;
import views.html.posts.details;
import views.html.posts.forms.login;
import views.html.posts.list;
import views.html.posts.forms.signup;

import static play.data.Form.form;

/**
 * Created by amd on 7/17/15.
 */
public class Posts extends Controller{

    private static Form<SignupForm> signupForm = form(SignupForm.class);
    private static Form<LoginForm> loginForm = form(LoginForm.class);

    public Result list() {
        List<Post> allPosts = Post.findAll();
        return ok(list.render(allPosts));
    }

    public Result newProduct(){
        return TODO;
    }

    public Result details(String title){
        Post post = Post.findByTitle(title);
        if(post!=null) {
            List<Comment> comments = Comment.commentOfPost(post.id);
            return ok(details.render(post, comments));
        }else{
            return ok("404 ! not found ");
        }
    }

    public Result save(){
        return TODO;
    }

    @AddCSRFToken
    public Result signup(){
        return ok(signup.render(signupForm));
    }

    @RequireCSRFCheck
    public Result submitSignup(){
        List<String> errors = new ArrayList<>() , success = new ArrayList<>();
        Form<SignupForm> boundSignupForm = signupForm.bindFromRequest();
        if(boundSignupForm.hasErrors()){
            return badRequest(signup.render(boundSignupForm));
        }else{
            SignupForm signupForm = boundSignupForm.get();
            PostUser user = PostUser.createUserFromForm(signupForm);
            PostProfile profile = PostProfile.createProfileFromForm(signupForm , user);
            if(user.exist()){
                flash("error", "User already exist with email : "+user.getEmail() );
                return badRequest(signup.render(boundSignupForm));
            }
            Ebean.beginTransaction();
            try{
                user.save();
                profile.save();
                Ebean.commitTransaction();
                return ok("User created Successfully");
            }catch (Exception e){
                Logger.error(Arrays.toString(e.getStackTrace()));
                return badRequest("Error creating User");
            }finally {
                Ebean.endTransaction();
            }
        }
    }

    @AddCSRFToken
    public Result login(){
        return ok(login.render(loginForm));
    }

    @RequireCSRFCheck
    public Result submitLogin(){
        Form<LoginForm> boundLoginForm = loginForm.bindFromRequest();
        if(boundLoginForm.hasErrors())
            return badRequest(login.render(boundLoginForm));
        else{
            LoginForm loginForm = boundLoginForm.get();
            if(PostUser.checkUserLogin(loginForm.getUsername(), loginForm.getUsername(), loginForm.getPassword())){
                flash("success", "Login Successfull");
                return ok(list.render(Post.findAll()));
            }else{
                flash("error", "Credentials not matched ! try Again");
                return badRequest(login.render(boundLoginForm));
            }
        }
    }
}