package models;

import play.data.validation.Constraints.Required;

import javax.persistence.*;
// import java.time.LocalDate;

@Entity
public class AmazonEchoShoppingList {
    @Id
    @GeneratedValue
    private long id;

    @Required
    private long pullRequestId;

    @Required
    private String userName;

    @Required
    private String shoppingListItem;

    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPullRequestId() {
        return pullRequestId;
    }

    public void setPullRequestId(long pullRequestId) {
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
