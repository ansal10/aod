package models.ebeans;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by amd on 7/20/15.
 */
@Entity
public class Post extends Model {

    @Id
    public Long Id;
    @Constraints.MinLength(20)
    public String title;
    @Constraints.MinLength(20)
    @Column(columnDefinition = "text")
    public String description;
    @Column(columnDefinition = "Datetime default now()")
    public Date createdOn;
    public Date lastUpdatedOn;

    @ManyToOne
    public Category category;
    @OneToMany
    public List<Comment> comments;
    @OneToMany
    public List<Like> likes;
    @ManyToOne
    public User user;

    public List<Post> fetchAll(){
        List<Post> posts =
    }

}
