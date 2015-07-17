package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by amd on 7/17/15.
 */
public class Comment {

    public String comment;
    public Integer supporters;
    public Integer opponents;
    public Integer likes;
    public Integer dislikes;
    public Integer postId;
    public Integer commentId;
    public Date createdOn;

    public static List<Comment> comments;

    static {
        comments = new ArrayList<>();
    }

    public Comment(String comments, Integer supporters, Integer opponents, Integer likes, Integer dislikes, Integer post_id, Integer comment_id) {
        this.comment = comments;
        this.supporters = supporters;
        this.opponents = opponents;
        this.likes = likes;
        this.dislikes = dislikes;
        this.postId = post_id;
        this.commentId = comment_id;
        this.createdOn = new Date();
    }

    public Comment(Integer postId, String comments) {
        this.postId = postId;
        this.comment = comments;
        this.supporters = this.opponents = this.likes = this.dislikes = 0;
        this.createdOn = new Date();
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public static List<Comment> getComments() {
        return comments;
    }
}
