package models.posts;

import com.avaje.ebean.Model;
import models.posts.Enum.CommentType;
import org.joda.time.DateTime;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;

/**
 * Created by amd on 7/17/15.
 */

@Entity
public class PostComment extends Model {

    @Id
    public Long id;

    @Lob
    public String description;

    @Constraints.Required
    public DateTime createdOn;

    @Constraints.Required
    public DateTime lastUpdatedOn;

    public Boolean anonymous;

    public CommentType type;

    public Long comment_id;

//    @OneToMany(mappedBy = "Comment")
//    public List<Comment> comments;
//
//    @ManyToOne
//    public Comment comment;

    @OneToMany(mappedBy = "comment")
    public List<PostLike> likes;

    @ManyToOne
    public PostPost post;

    @ManyToOne
    public PostUser user;

    public PostComment(String description, Boolean anonymous, CommentType type, Long comment_id, PostPost post, PostUser user) {
        this.description = description;
        this.anonymous = anonymous;
        this.type = type;
        this.comment_id = comment_id;
        this.post = post;
        this.user = user;
        this.lastUpdatedOn = this.createdOn = new DateTime();
    }






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CommentType getType() {
        return type;
    }

    public void setType(CommentType type) {
        this.type = type;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public List<PostLike> getLikes() {
        return likes;
    }

    public void setLikes(List<PostLike> likes) {
        this.likes = likes;
    }

    public PostPost getPost() {
        return post;
    }

    public void setPost(PostPost post) {
        this.post = post;
    }

    public PostUser getUser() {
        return user;
    }

    public void setUser(PostUser user) {
        this.user = user;
    }
}
