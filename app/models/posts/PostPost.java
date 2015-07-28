package models.posts;

import com.avaje.ebean.Model;
import models.posts.Enum.Category;
import org.joda.time.DateTime;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;

/**
 * Created by amd on 7/17/15.
 */

@Entity
public class PostPost extends Model {

    @Id
    public Long id;

    @Constraints.MinLength(100) 
    public String title;

    @Lob
    public String description;

    public DateTime createdOn;

    public DateTime lastUpdatedOn;

    public Boolean anonymous;

    public Long views;

    public Category category;

    @OneToMany(mappedBy = "post")
    public List<PostComment> comments;

    @OneToMany(mappedBy = "post")
    public List<PostLike> likes;

    @ManyToOne
    public PostUser user;

    public PostPost(String title, String description, Boolean anonymous, Category category, PostUser user) {
        this.title = title;
        this.description = description;
        this.anonymous = anonymous;
        this.user = user;
        this.category = category;
        this.createdOn = this.lastUpdatedOn = new DateTime();
        this.views = (long) 0;
    }


    public static Finder<String, PostPost> find = new Finder<String,PostPost>(PostPost.class);


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn;
    }

    public DateTime getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(DateTime lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }

    public List<PostLike> getLikes() {
        return likes;
    }

    public void setLikes(List<PostLike> likes) {
        this.likes = likes;
    }

    public PostUser getUser() {
        return user;
    }

    public void setUser(PostUser user) {
        this.user = user;
    }
}
