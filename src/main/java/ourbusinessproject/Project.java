package ourbusinessproject;

import javax.validation.constraints.NotEmpty;

public class Project {

    @NotEmpty
    private String title;

    private String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
