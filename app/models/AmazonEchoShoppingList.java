package models;

import play.data.validation.Constraints.Required;

import javax.persistence.*;
// import java.time.LocalDate;

@Entity
public class AmazonEchoShoppingList {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Required
    @Column(name = "pull_request_id")
    private Long pullRequestId;

    @Required
    @Column(name = "username")
    private String userName;

    @Required
    @Column(name = "shopping_list_item")
    private String shoppingListItem;

    @Column(name = "comment")
    private String comment;

    // -------- Default constructor needed by Hibernate --------

    public AmazonEchoShoppingList() {
    }

    // --------- Getters/Setters ---------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPullRequestId() {
        return pullRequestId;
    }

    public void setPullRequestId(Long pullRequestId) {
        this.pullRequestId = pullRequestId;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getShoppingListItem() {
        return shoppingListItem;
    }

    public void setShoppingListItem(String shoppingListItem) {
        this.shoppingListItem = shoppingListItem;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
