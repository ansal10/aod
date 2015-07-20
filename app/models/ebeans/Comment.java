package models.ebeans;

import com.avaje.ebean.*;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Created by amd on 7/20/15.
 */
public class Comment extends Model {

    @Id
    public Long Id;
    @Constraints.MinLength(20)
    @Column(columnDefinition = "text")
    public String comment;
    @Column(columnDefinition = "Datetime default now()")
    public Date createdOn;
    @OneToMany
    public List<Comment> comments;
    @OneToMany
    public List<Like> likes;
    @ManyToOne
    public User user;
    public CommentType commentType;


}
