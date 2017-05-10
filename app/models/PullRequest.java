package models;
import play.data.validation.Constraints.Required;

import javax.persistence.*;

@Entity
public class PullRequest {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Required
    @Column(name = "max_pull_request_id")
    private Long maxPullRequestId;

    // -------- Default constructor needed by Hibernate --------

    public PullRequest() {
    }

    // --------- Getters/Setters ---------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaxPullRequestId() {
        return maxPullRequestId;
    }

    public void setMaxPullRequestId(Long pullRequestId) {
        this.maxPullRequestId = pullRequestId;
    }
}
