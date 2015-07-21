package models.posts;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by amd on 7/21/15.
 */
@Entity
public class PostProfile {

    @Id
    public Long id;

    @Constraints.Required
    @Constraints.Pattern("[a-zA-Z]+")
    @Constraints.MinLength(5)
    public String fName;

    @Constraints.Required
    public String lName;

    @Constraints.Required
    public String nickName;

    public String profilePic;

    public String lastUpdatedOn;

    @OneToOne(mappedBy = "profile")
    public PostUser user;

    public PostProfile(String fName, String lName, String nickName, String profilePic, PostUser user) {
        this.fName = fName;
        this.lName = lName;
        this.nickName = nickName;
        this.profilePic = profilePic;
        this.user = user;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public PostUser getUser() {
        return user;
    }

    public void setUser(PostUser user) {
        this.user = user;
    }
}
