package controllers;

import models.Comment;
import models.Post;
import play.mvc.Result;
import java.util.List;
import play.mvc.*;
import views.html.posts.details;
import views.html.posts.list;

/**
 * Created by amd on 7/17/15.
 */
public class Posts extends Controller{

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
}