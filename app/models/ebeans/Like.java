package models.ebeans;

import com.avaje.ebean.*;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by amd on 7/20/15.
 */
public class Like extends Model{

    @Id
    public Long Id;
    @ManyToOne
    public User user;
    public LikeType likeType;
}
