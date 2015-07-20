package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by amd on 7/17/15.
 */

@Entity
public class Comment extends Model {

    @Id
    public Long id;

    public String name;
}
