package models;

import com.avaje.ebean.Model;
import javafx.scene.text.Text;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by amd on 7/17/15.
 */

import javax.persistence.Entity;

@Entity
public class Post extends Model {

    @Id
    public Long id;
    @Column(columnDefinition = "text not null")
    public String title;
    public String description;
}
