package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by amd on 7/17/15.
 */
public class Comment {

    public static final String OPPONENT = "O";
    public static final String SUPPORTER = "S";


    public String comment;
    public Integer supporters;
    public Integer opponents;
    public Integer likes;
    public Integer dislikes;
    public Integer postId;
    public Integer commentId;
    public Date createdOn;
    public String type;
    public String user;

    public static List<Comment> comments;

    static {
        comments = new ArrayList<>();
        comments.add(new Comment(
                    1,
                    "sbt functions quite differently to the way many traditional build tasks. Fundamentally, sbt is a task engine. Your build is represented as a tree of task dependencies that need to be executed, for example, the compile task depends on the sources task, which depends on the sourceDirectories task and the sourceGenerators task, and so on.",
                    "O", "Anonymus"
                    ));
        comments.add(new Comment(
                        1,
                        "sbt functions quite differently to the way many traditional build tasks. Fundamentally, sbt is a task engine. Your build is represented as a tree of task dependencies that need to be executed, for example, the compile task depends on the sources task, which depends on the sourceDirectories task and the sourceGenerators task, and so on.",
                        "S", "Spooks"
                ));
    }

    public Comment(String comments, Integer supporters, Integer opponents, Integer likes, Integer dislikes, Integer post_id, Integer comment_id, String type) {
        this.comment = comments;
        this.supporters = supporters;
        this.opponents = opponents;
        this.likes = likes;
        this.dislikes = dislikes;
        this.postId = post_id;
        this.commentId = comment_id;
        this.createdOn = new Date();
        this.type = type;
    }

    public Comment(Integer postId, String comments, String type, String user) {
        this.postId = postId;
        this.comment = comments;
        this.supporters = this.opponents = this.likes = this.dislikes = 0;
        this.createdOn = new Date();
        this.type = type;
        this.user = user;
    }

    public static List<Comment> commentOfPost(Integer postId){
        List<Comment> filterComments = new ArrayList<>();
        for(Comment c : comments){
            if (c.postId.equals(postId))
                filterComments.add(c);
        }
        return filterComments;
    }

    public static List<Comment> commentOfComments(Integer commentId){
        List<Comment> filterComments = new ArrayList<>();
        for(Comment c : comments){
            if (c.commentId.equals(commentId))
                filterComments.add(c);
        }
        return filterComments;
    }


    public String getComment() {
        return comment;
    }

    public Integer getSupporters() {
        return supporters;
    }

    public Integer getOpponents() {
        return opponents;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public Integer getPostId() {
        return postId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public String getCreatedOn() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh:mm");
        return dateFormat.format(this.createdOn);

    }

    public static List<Comment> getComments() {
        return comments;
    }

    public String getShortComment(){
        return this.comment.substring(0,120);
    }

    public String getType() {
        return type;
    }

    public Boolean isSupporting(){
        return this.type.equals(SUPPORTER);
    }
    public Boolean isCountering(){
        return this.type.equals(OPPONENT);
    }

    public String getUser() {
        return user;
    }




}
