package com.xiaofu.webhook.vo;//package com.xiaofu.webhook.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 公众号：程序员小富
 * @Description:程序员内点事
 * @date 2021/05/19
 */
@NoArgsConstructor
@Data
public class GithubWebhookPullVo {


    @JsonProperty("ref")
    private String ref;
    @JsonProperty("before")
    private String before;
    @JsonProperty("after")
    private String after;
    @JsonProperty("repository")
    private RepositoryDTO repository;
    @JsonProperty("pusher")
    private PusherDTO pusher;
    @JsonProperty("sender")
    private SenderDTO sender;
    @JsonProperty("created")
    private Boolean created;
    @JsonProperty("deleted")
    private Boolean deleted;
    @JsonProperty("forced")
    private Boolean forced;
    @JsonProperty("base_ref")
    private Object baseRef;
    @JsonProperty("compare")
    private String compare;
    @JsonProperty("commits")
    private List<CommitsDTO> commits;
    @JsonProperty("head_commit")
    private HeadCommitDTO headCommit;

    @NoArgsConstructor
    @Data
    public static class RepositoryDTO {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("node_id")
        private String nodeId;
        @JsonProperty("name")
        private String name;
        @JsonProperty("full_name")
        private String fullName;
        @JsonProperty("private")
        private Boolean privateX;
        @JsonProperty("owner")
        private OwnerDTO owner;
        @JsonProperty("html_url")
        private String htmlUrl;
        @JsonProperty("description")
        private String description;
        @JsonProperty("fork")
        private Boolean fork;
        @JsonProperty("url")
        private String url;
        @JsonProperty("forks_url")
        private String forksUrl;
        @JsonProperty("keys_url")
        private String keysUrl;
        @JsonProperty("collaborators_url")
        private String collaboratorsUrl;
        @JsonProperty("teams_url")
        private String teamsUrl;
        @JsonProperty("hooks_url")
        private String hooksUrl;
        @JsonProperty("issue_events_url")
        private String issueEventsUrl;
        @JsonProperty("events_url")
        private String eventsUrl;
        @JsonProperty("assignees_url")
        private String assigneesUrl;
        @JsonProperty("branches_url")
        private String branchesUrl;
        @JsonProperty("tags_url")
        private String tagsUrl;
        @JsonProperty("blobs_url")
        private String blobsUrl;
        @JsonProperty("git_tags_url")
        private String gitTagsUrl;
        @JsonProperty("git_refs_url")
        private String gitRefsUrl;
        @JsonProperty("trees_url")
        private String treesUrl;
        @JsonProperty("statuses_url")
        private String statusesUrl;
        @JsonProperty("languages_url")
        private String languagesUrl;
        @JsonProperty("stargazers_url")
        private String stargazersUrl;
        @JsonProperty("contributors_url")
        private String contributorsUrl;
        @JsonProperty("subscribers_url")
        private String subscribersUrl;
        @JsonProperty("subscription_url")
        private String subscriptionUrl;
        @JsonProperty("commits_url")
        private String commitsUrl;
        @JsonProperty("git_commits_url")
        private String gitCommitsUrl;
        @JsonProperty("comments_url")
        private String commentsUrl;
        @JsonProperty("issue_comment_url")
        private String issueCommentUrl;
        @JsonProperty("contents_url")
        private String contentsUrl;
        @JsonProperty("compare_url")
        private String compareUrl;
        @JsonProperty("merges_url")
        private String mergesUrl;
        @JsonProperty("archive_url")
        private String archiveUrl;
        @JsonProperty("downloads_url")
        private String downloadsUrl;
        @JsonProperty("issues_url")
        private String issuesUrl;
        @JsonProperty("pulls_url")
        private String pullsUrl;
        @JsonProperty("milestones_url")
        private String milestonesUrl;
        @JsonProperty("notifications_url")
        private String notificationsUrl;
        @JsonProperty("labels_url")
        private String labelsUrl;
        @JsonProperty("releases_url")
        private String releasesUrl;
        @JsonProperty("deployments_url")
        private String deploymentsUrl;
        @JsonProperty("created_at")
        private Integer createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        @JsonProperty("pushed_at")
        private Integer pushedAt;
        @JsonProperty("git_url")
        private String gitUrl;
        @JsonProperty("ssh_url")
        private String sshUrl;
        @JsonProperty("clone_url")
        private String cloneUrl;
        @JsonProperty("svn_url")
        private String svnUrl;
        @JsonProperty("homepage")
        private String homepage;
        @JsonProperty("size")
        private Integer size;
        @JsonProperty("stargazers_count")
        private Integer stargazersCount;
        @JsonProperty("watchers_count")
        private Integer watchersCount;
        @JsonProperty("language")
        private String language;
        @JsonProperty("has_issues")
        private Boolean hasIssues;
        @JsonProperty("has_projects")
        private Boolean hasProjects;
        @JsonProperty("has_downloads")
        private Boolean hasDownloads;
        @JsonProperty("has_wiki")
        private Boolean hasWiki;
        @JsonProperty("has_pages")
        private Boolean hasPages;
        @JsonProperty("forks_count")
        private Integer forksCount;
        @JsonProperty("mirror_url")
        private Object mirrorUrl;
        @JsonProperty("archived")
        private Boolean archived;
        @JsonProperty("disabled")
        private Boolean disabled;
        @JsonProperty("open_issues_count")
        private Integer openIssuesCount;
        @JsonProperty("license")
        private Object license;
        @JsonProperty("forks")
        private Integer forks;
        @JsonProperty("open_issues")
        private Integer openIssues;
        @JsonProperty("watchers")
        private Integer watchers;
        @JsonProperty("default_branch")
        private String defaultBranch;
        @JsonProperty("stargazers")
        private Integer stargazers;
        @JsonProperty("master_branch")
        private String masterBranch;

        @NoArgsConstructor
        @Data
        public static class OwnerDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;
            @JsonProperty("login")
            private String login;
            @JsonProperty("id")
            private Integer id;
            @JsonProperty("node_id")
            private String nodeId;
            @JsonProperty("avatar_url")
            private String avatarUrl;
            @JsonProperty("gravatar_id")
            private String gravatarId;
            @JsonProperty("url")
            private String url;
            @JsonProperty("html_url")
            private String htmlUrl;
            @JsonProperty("followers_url")
            private String followersUrl;
            @JsonProperty("following_url")
            private String followingUrl;
            @JsonProperty("gists_url")
            private String gistsUrl;
            @JsonProperty("starred_url")
            private String starredUrl;
            @JsonProperty("subscriptions_url")
            private String subscriptionsUrl;
            @JsonProperty("organizations_url")
            private String organizationsUrl;
            @JsonProperty("repos_url")
            private String reposUrl;
            @JsonProperty("events_url")
            private String eventsUrl;
            @JsonProperty("received_events_url")
            private String receivedEventsUrl;
            @JsonProperty("type")
            private String type;
            @JsonProperty("site_admin")
            private Boolean siteAdmin;
        }
    }

    @NoArgsConstructor
    @Data
    public static class PusherDTO {
        @JsonProperty("name")
        private String name;
        @JsonProperty("email")
        private String email;
    }

    @NoArgsConstructor
    @Data
    public static class SenderDTO {
        @JsonProperty("login")
        private String login;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("node_id")
        private String nodeId;
        @JsonProperty("avatar_url")
        private String avatarUrl;
        @JsonProperty("gravatar_id")
        private String gravatarId;
        @JsonProperty("url")
        private String url;
        @JsonProperty("html_url")
        private String htmlUrl;
        @JsonProperty("followers_url")
        private String followersUrl;
        @JsonProperty("following_url")
        private String followingUrl;
        @JsonProperty("gists_url")
        private String gistsUrl;
        @JsonProperty("starred_url")
        private String starredUrl;
        @JsonProperty("subscriptions_url")
        private String subscriptionsUrl;
        @JsonProperty("organizations_url")
        private String organizationsUrl;
        @JsonProperty("repos_url")
        private String reposUrl;
        @JsonProperty("events_url")
        private String eventsUrl;
        @JsonProperty("received_events_url")
        private String receivedEventsUrl;
        @JsonProperty("type")
        private String type;
        @JsonProperty("site_admin")
        private Boolean siteAdmin;
    }

    @NoArgsConstructor
    @Data
    public static class HeadCommitDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("tree_id")
        private String treeId;
        @JsonProperty("distinct")
        private Boolean distinct;
        @JsonProperty("message")
        private String message;
        @JsonProperty("timestamp")
        private String timestamp;
        @JsonProperty("url")
        private String url;
        @JsonProperty("author")
        private AuthorDTO author;
        @JsonProperty("committer")
        private CommitterDTO committer;
        @JsonProperty("added")
        private List<String> added;
        @JsonProperty("removed")
        private List<String> removed;
        @JsonProperty("modified")
        private List<?> modified;

        @NoArgsConstructor
        @Data
        public static class AuthorDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;
        }

        @NoArgsConstructor
        @Data
        public static class CommitterDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;
        }
    }

    @NoArgsConstructor
    @Data
    public static class CommitsDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("tree_id")
        private String treeId;
        @JsonProperty("distinct")
        private Boolean distinct;
        @JsonProperty("message")
        private String message;
        @JsonProperty("timestamp")
        private String timestamp;
        @JsonProperty("url")
        private String url;
        @JsonProperty("author")
        private AuthorDTO author;
        @JsonProperty("committer")
        private CommitterDTO committer;
        @JsonProperty("added")
        private List<String> added;
        @JsonProperty("removed")
        private List<String> removed;
        @JsonProperty("modified")
        private List<String> modified;

        @NoArgsConstructor
        @Data
        public static class AuthorDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;
        }

        @NoArgsConstructor
        @Data
        public static class CommitterDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;
        }
    }
}
