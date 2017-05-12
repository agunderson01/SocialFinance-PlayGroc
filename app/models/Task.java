package models;


import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "comment")
    private String comment;


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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}