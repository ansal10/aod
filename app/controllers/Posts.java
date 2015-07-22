package controllers;

import controllers.posts.forms.SignupForm;
import models.Comment;
import models.Post;
import play.data.Form;
import play.mvc.Result;
import java.util.List;
import play.mvc.*;
import views.html.posts.details;
import views.html.posts.list;
import views.html.posts.signup;

import static play.data.Form.form;

/**
 * Created by amd on 7/17/15.
 */
public class Posts extends Controller{

    private static Form<SignupForm> signupForm = form(SignupForm.class);


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

    public Result signup(){
        return ok(signup.render(signupForm));
    }

    public Result submitSignup(){

        Form<SignupForm> boundSignupForm = signupForm.bindFromRequest();
        if(boundSignupForm.hasErrors()){
            return badRequest(signup.render(boundSignupForm));
        }else{
            return ok("Success");
        }
    }
}