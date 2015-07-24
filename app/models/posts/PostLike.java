package models.posts;

import com.avaje.ebean.LikeType;
import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by amd on 7/21/15.
 */
@Entity
public class PostLike extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public LikeType type;

    public DateTime createdOn;

    @ManyToOne
    public PostComment comment;

    @ManyToOne
    public PostPost post;

    @ManyToOne
    public PostUser user;

    public PostLike(LikeType type, PostComment comment, PostPost post, PostUser user) {
        this.type = type;
        this.comment = comment;
        this.post = post;
        this.user = user;
        this.createdOn = new DateTime();
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LikeType getType() {
        return type;
    }

    public void setType(LikeType type) {
        this.type = type;
    }

    public DateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn;
    }

    public PostComment getComment() {
        return comment;
    }

    public void setComment(PostComment comment) {
        this.comment = comment;
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
