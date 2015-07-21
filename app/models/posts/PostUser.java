package models.posts;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.joda.time.DateTime;
import play.data.validation.Constraints;

import java.util.List;

/**
 * Created by amd on 7/21/15.
 */
@Entity
public class PostUser {

    @Id
    public Long id;

    public Boolean isSuperuser;

    public Boolean isStaff;

    public DateTime createdOn;

    @Constraints.Email
    @Constraints.Required
    public String email;

    public String uniqueEmail;

    @Constraints.Required
    public String password;

    @OneToMany(mappedBy = "user")
    public List<PostComment> comments;

    @OneToMany(mappedBy = "user")
    public List<PostPost> posts;

    @OneToMany(mappedBy = "user")
    public List<PostLike> likes;

    @OneToOne
    public PostProfile profile;

    public PostUser(Boolean isSuperuser, Boolean isStaff, String email, String uniqueEmail, String password, PostProfile profile) {
        this.isSuperuser = isSuperuser;
        this.isStaff = isStaff;
        this.email = email;
        this.uniqueEmail = uniqueEmail;
        this.password = Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
        this.profile = profile;
        this.createdOn = new DateTime();
    }


















    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public Boolean getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public DateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniqueEmail() {
        return uniqueEmail;
    }

    public void setUniqueEmail(String uniqueEmail) {
        this.uniqueEmail = uniqueEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }

    public List<PostPost> getPosts() {
        return posts;
    }

    public void setPosts(List<PostPost> posts) {
        this.posts = posts;
    }

    public List<PostLike> getLikes() {
        return likes;
    }

    public void setLikes(List<PostLike> likes) {
        this.likes = likes;
    }

    public PostProfile getProfile() {
        return profile;
    }

    public void setProfile(PostProfile profile) {
        this.profile = profile;
    }
}
