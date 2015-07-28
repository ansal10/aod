package controllers;

import com.avaje.ebean.Ebean;
import controllers.posts.Secured;
import controllers.posts.forms.LoginForm;
import controllers.posts.forms.NewPost;
import controllers.posts.forms.SignupForm;
import models.Comment;
import models.Post;
import models.posts.Enum.Category;
import models.posts.PostPost;
import models.posts.PostProfile;
import models.posts.PostUser;
import org.joda.time.DateTimeField;
import play.Logger;
import play.data.Form;
import play.filters.csrf.AddCSRFToken;
import play.filters.csrf.RequireCSRFCheck;
import play.mvc.Result;

import java.util.*;

import play.mvc.*;
import views.html.posts.details;
import views.html.posts.forms.login;
import views.html.posts.forms.newpost;
import views.html.posts.list;
import views.html.posts.forms.signup;

import static play.data.Form.form;

/**
 * Created by amd on 7/17/15.
 */
public class Posts extends Controller{

    private static Form<SignupForm> signupForm = form(SignupForm.class);
    private static Form<LoginForm> loginForm = form(LoginForm.class);
    private static Form<NewPost> newPostForm = form(NewPost.class);

    private static final Logger.ALogger logger =  Logger.of("posts");

    @Security.Authenticated(Secured.class)
    public Result list() {
        List<PostPost> posts = PostPost.find.all();
        for(PostPost p : posts){
            System.out.println(p.getUser().getProfile().getNickName()+" - > " + p.getCreatedOn());
        }
        String user = request().username();
        Logger.info(user);
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
                logger.error(Arrays.toString(e.getStackTrace()));
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
                logger.info("Logged in User : "+loginForm.getUsername());
                flash("success", "Login Successfull");
                session().clear();
                session("username",loginForm.getUsername());
                session("last_logged", String.valueOf(new Date().getTime()));
                return redirect(routes.Posts.list());
            }else{
                flash("error", "Credentials not matched ! try Again");
                return badRequest(login.render(boundLoginForm));
            }
        }
    }

    @AddCSRFToken
    @Security.Authenticated(Secured.class)
    public Result newPost(){
        Map<String,String> categories= new LinkedHashMap<String, String>();
        for(Category cat : Category.values())
            categories.put(String.valueOf(cat.getEventValue()), cat.toString());

        return ok(newpost.render(newPostForm , categories));
    }

    @RequireCSRFCheck
    @Security.Authenticated(Secured.class)
    public Result submitPost(){
        Form<NewPost> boundPostForm = newPostForm.bindFromRequest();
        Map<String,String> categories= new LinkedHashMap<String, String>();
        for(Category cat : Category.values())
            categories.put(String.valueOf(cat.getEventValue()), cat.toString());

        String category = categories.getOrDefault(boundPostForm.get().getCategory(),null);
        if(boundPostForm.hasErrors() || category==null ){
            return badRequest(newpost.render(boundPostForm, categories));
        }else{
            NewPost  postForm = boundPostForm.get();
            PostUser user = PostUser.find.where().eq("username",session().getOrDefault("username",null)).findUnique();
            if(user!=null){
                PostPost post = new PostPost(postForm.getTitle(), postForm.getDescription(), false, Category.valueOf(category),user);
                post.save();
            }
            return ok("success");
        }

    }


    public Result logout(){
        session().clear();
        flash("success","Logged out successfully");
        return redirect(routes.Posts.login());
    }
}