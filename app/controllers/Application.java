package controllers;

import play.mvc.*;

import views.html.*;


public class Application extends Controller {

    public Result index() {
//        Post p = new Post(null,null,null,null);
//        p.description="hello world";
//        p.title="It worked";
//        List<Post> posts = Ebean.createQuery(Post.class).select("id title").findList();
        return ok(index.render("Good to go "));

    }

}
