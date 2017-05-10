package models;

import play.data.validation.Constraints.Required;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Required
    @Column(name = "title")
    private String title;

    @Column(name = "comment")
    private String comment;

    @Column(name = "starred")
    private boolean starred;

    @Column(name = "due_date")
    private LocalDate dueDate;

    // -------- Default constructor needed by Hibernate --------

    public Task() {
    }

    // --------- Getters/Setters ---------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }
}