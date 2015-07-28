package controllers.posts.forms;

import play.data.validation.Constraints;

/**
 * Created by amd on 7/29/15.
 */
public class NewPost {

    @Constraints.Required
    @Constraints.MaxLength(120)
    @Constraints.MinLength(10)
    public String title;

    @Constraints.Required
    @Constraints.MinLength(20)
    public String description;


    @Constraints.Required
    public String category;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
