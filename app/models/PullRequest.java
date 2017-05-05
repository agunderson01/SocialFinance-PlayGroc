package models;
import play.data.validation.Constraints.Required;

import javax.persistence.*;

@Entity
public class PullRequest {
    @Id
    @GeneratedValue
    private long id;

    @Required
    private long maxPullRequestId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMaxPullRequestId() {
        return maxPullRequestId;
    }

    public void setMaxPullRequestId(long pullRequestId) {
        this.maxPullRequestId = pullRequestId;
    }
}
