package controllers;

import models.Post;
import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;


public class Application extends Controller {

    public Result index() {
        Post p = new Post();
        p.description="hello world";
        p.title="It worked";
        p.save();

        return ok(index.render(Json.toJson(p).toString()));

    }

}
