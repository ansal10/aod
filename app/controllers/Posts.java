package controllers;

import models.Post;
import play.mvc.Result;
import java.util.List;
import play.mvc.*;
import views.html.posts.list;

/**
 * Created by amd on 7/17/15.
 */
public class Posts extends Controller{

    public Result index() {
        List<Post> allPosts = Post.findAll();
        return ok(list.render(allPosts));
    }

    public Result newProduct(){
        return TODO;
    }

    public Result details(String title){
        return TODO;
    }

    public Result save(){
        return TODO;
    }
}
