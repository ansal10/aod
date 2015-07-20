package models.ebeans;

import com.avaje.ebean.Model;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by amd on 7/20/15.
 */
public class Category extends Model {

    @Id
    public Long Id;

    public String category;

    @OneToMany(mappedBy = "post")
    public List<Post> post;
}
