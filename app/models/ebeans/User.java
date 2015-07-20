package models.ebeans;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Created by amd on 7/20/15.
 */
public class User extends Model {

    @Id
    public Long Id;
    public String fname;
    public String lname;
    public String nickName;
    public String email;
    public String password;
    public String username;
    public Date createdOn;
    public Date lastLogin;
    @Column(columnDefinition = "bool default 'f'")
    public Boolean isSuperUser;
    @Column(columnDefinition = "bool default 't'")
    public Boolean isActive;
    @OneToMany
    public List<Post> posts;
    @OneToMany
    public List<Comment> comments;

}
