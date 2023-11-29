package com.springboot101.vo;//package com.springboot101.webhook.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 公众号：程序员小富
 * @Description:程序员小富
 * @date 2021/05/19
 */
@NoArgsConstructor
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

    public String getRef() {
        return ref;
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

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public RepositoryDTO getRepository() {
        return repository;
    }

    public void setRepository(RepositoryDTO repository) {
        this.repository = repository;
    }

    public PusherDTO getPusher() {
        return pusher;
    }

    public void setPusher(PusherDTO pusher) {
        this.pusher = pusher;
    }

    public SenderDTO getSender() {
        return sender;
    }

    public void setSender(SenderDTO sender) {
        this.sender = sender;
    }

    public Boolean getCreated() {
        return created;
    }

    public void setCreated(Boolean created) {
        this.created = created;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getForced() {
        return forced;
    }

    public void setForced(Boolean forced) {
        this.forced = forced;
    }

    public Object getBaseRef() {
        return baseRef;
    }

    public void setBaseRef(Object baseRef) {
        this.baseRef = baseRef;
    }

    public String getCompare() {
        return compare;
    }

    public void setCompare(String compare) {
        this.compare = compare;
    }

    public List<CommitsDTO> getCommits() {
        return commits;
    }

    public void setCommits(List<CommitsDTO> commits) {
        this.commits = commits;
    }

    public HeadCommitDTO getHeadCommit() {
        return headCommit;
    }

    public void setHeadCommit(HeadCommitDTO headCommit) {
        this.headCommit = headCommit;
    }

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

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNodeId() {
            return nodeId;
        }

        public void setNodeId(String nodeId) {
            this.nodeId = nodeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Boolean getPrivateX() {
            return privateX;
        }

        public void setPrivateX(Boolean privateX) {
            this.privateX = privateX;
        }

        public OwnerDTO getOwner() {
            return owner;
        }

        public void setOwner(OwnerDTO owner) {
            this.owner = owner;
        }

        public String getHtmlUrl() {
            return htmlUrl;
        }

        public void setHtmlUrl(String htmlUrl) {
            this.htmlUrl = htmlUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Boolean getFork() {
            return fork;
        }

        public void setFork(Boolean fork) {
            this.fork = fork;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getForksUrl() {
            return forksUrl;
        }

        public void setForksUrl(String forksUrl) {
            this.forksUrl = forksUrl;
        }

        public String getKeysUrl() {
            return keysUrl;
        }

        public void setKeysUrl(String keysUrl) {
            this.keysUrl = keysUrl;
        }

        public String getCollaboratorsUrl() {
            return collaboratorsUrl;
        }

        public void setCollaboratorsUrl(String collaboratorsUrl) {
            this.collaboratorsUrl = collaboratorsUrl;
        }

        public String getTeamsUrl() {
            return teamsUrl;
        }

        public void setTeamsUrl(String teamsUrl) {
            this.teamsUrl = teamsUrl;
        }

        public String getHooksUrl() {
            return hooksUrl;
        }

        public void setHooksUrl(String hooksUrl) {
            this.hooksUrl = hooksUrl;
        }

        public String getIssueEventsUrl() {
            return issueEventsUrl;
        }

        public void setIssueEventsUrl(String issueEventsUrl) {
            this.issueEventsUrl = issueEventsUrl;
        }

        public String getEventsUrl() {
            return eventsUrl;
        }

        public void setEventsUrl(String eventsUrl) {
            this.eventsUrl = eventsUrl;
        }

        public String getAssigneesUrl() {
            return assigneesUrl;
        }

        public void setAssigneesUrl(String assigneesUrl) {
            this.assigneesUrl = assigneesUrl;
        }

        public String getBranchesUrl() {
            return branchesUrl;
        }

        public void setBranchesUrl(String branchesUrl) {
            this.branchesUrl = branchesUrl;
        }

        public String getTagsUrl() {
            return tagsUrl;
        }

        public void setTagsUrl(String tagsUrl) {
            this.tagsUrl = tagsUrl;
        }

        public String getBlobsUrl() {
            return blobsUrl;
        }

        public void setBlobsUrl(String blobsUrl) {
            this.blobsUrl = blobsUrl;
        }

        public String getGitTagsUrl() {
            return gitTagsUrl;
        }

        public void setGitTagsUrl(String gitTagsUrl) {
            this.gitTagsUrl = gitTagsUrl;
        }

        public String getGitRefsUrl() {
            return gitRefsUrl;
        }

        public void setGitRefsUrl(String gitRefsUrl) {
            this.gitRefsUrl = gitRefsUrl;
        }

        public String getTreesUrl() {
            return treesUrl;
        }

        public void setTreesUrl(String treesUrl) {
            this.treesUrl = treesUrl;
        }

        public String getStatusesUrl() {
            return statusesUrl;
        }

        public void setStatusesUrl(String statusesUrl) {
            this.statusesUrl = statusesUrl;
        }

        public String getLanguagesUrl() {
            return languagesUrl;
        }

        public void setLanguagesUrl(String languagesUrl) {
            this.languagesUrl = languagesUrl;
        }

        public String getStargazersUrl() {
            return stargazersUrl;
        }

        public void setStargazersUrl(String stargazersUrl) {
            this.stargazersUrl = stargazersUrl;
        }

        public String getContributorsUrl() {
            return contributorsUrl;
        }

        public void setContributorsUrl(String contributorsUrl) {
            this.contributorsUrl = contributorsUrl;
        }

        public String getSubscribersUrl() {
            return subscribersUrl;
        }

        public void setSubscribersUrl(String subscribersUrl) {
            this.subscribersUrl = subscribersUrl;
        }

        public String getSubscriptionUrl() {
            return subscriptionUrl;
        }

        public void setSubscriptionUrl(String subscriptionUrl) {
            this.subscriptionUrl = subscriptionUrl;
        }

        public String getCommitsUrl() {
            return commitsUrl;
        }

        public void setCommitsUrl(String commitsUrl) {
            this.commitsUrl = commitsUrl;
        }

        public String getGitCommitsUrl() {
            return gitCommitsUrl;
        }

        public void setGitCommitsUrl(String gitCommitsUrl) {
            this.gitCommitsUrl = gitCommitsUrl;
        }

        public String getCommentsUrl() {
            return commentsUrl;
        }

        public void setCommentsUrl(String commentsUrl) {
            this.commentsUrl = commentsUrl;
        }

        public String getIssueCommentUrl() {
            return issueCommentUrl;
        }

        public void setIssueCommentUrl(String issueCommentUrl) {
            this.issueCommentUrl = issueCommentUrl;
        }

        public String getContentsUrl() {
            return contentsUrl;
        }

        public void setContentsUrl(String contentsUrl) {
            this.contentsUrl = contentsUrl;
        }

        public String getCompareUrl() {
            return compareUrl;
        }

        public void setCompareUrl(String compareUrl) {
            this.compareUrl = compareUrl;
        }

        public String getMergesUrl() {
            return mergesUrl;
        }

        public void setMergesUrl(String mergesUrl) {
            this.mergesUrl = mergesUrl;
        }

        public String getArchiveUrl() {
            return archiveUrl;
        }

        public void setArchiveUrl(String archiveUrl) {
            this.archiveUrl = archiveUrl;
        }

        public String getDownloadsUrl() {
            return downloadsUrl;
        }

        public void setDownloadsUrl(String downloadsUrl) {
            this.downloadsUrl = downloadsUrl;
        }

        public String getIssuesUrl() {
            return issuesUrl;
        }

        public void setIssuesUrl(String issuesUrl) {
            this.issuesUrl = issuesUrl;
        }

        public String getPullsUrl() {
            return pullsUrl;
        }

        public void setPullsUrl(String pullsUrl) {
            this.pullsUrl = pullsUrl;
        }

        public String getMilestonesUrl() {
            return milestonesUrl;
        }

        public void setMilestonesUrl(String milestonesUrl) {
            this.milestonesUrl = milestonesUrl;
        }

        public String getNotificationsUrl() {
            return notificationsUrl;
        }

        public void setNotificationsUrl(String notificationsUrl) {
            this.notificationsUrl = notificationsUrl;
        }

        public String getLabelsUrl() {
            return labelsUrl;
        }

        public void setLabelsUrl(String labelsUrl) {
            this.labelsUrl = labelsUrl;
        }

        public String getReleasesUrl() {
            return releasesUrl;
        }

        public void setReleasesUrl(String releasesUrl) {
            this.releasesUrl = releasesUrl;
        }

        public String getDeploymentsUrl() {
            return deploymentsUrl;
        }

        public void setDeploymentsUrl(String deploymentsUrl) {
            this.deploymentsUrl = deploymentsUrl;
        }

        public Integer getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Integer createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getPushedAt() {
            return pushedAt;
        }

        public void setPushedAt(Integer pushedAt) {
            this.pushedAt = pushedAt;
        }

        public String getGitUrl() {
            return gitUrl;
        }

        public void setGitUrl(String gitUrl) {
            this.gitUrl = gitUrl;
        }

        public String getSshUrl() {
            return sshUrl;
        }

        public void setSshUrl(String sshUrl) {
            this.sshUrl = sshUrl;
        }

        public String getCloneUrl() {
            return cloneUrl;
        }

        public void setCloneUrl(String cloneUrl) {
            this.cloneUrl = cloneUrl;
        }

        public String getSvnUrl() {
            return svnUrl;
        }

        public void setSvnUrl(String svnUrl) {
            this.svnUrl = svnUrl;
        }

        public String getHomepage() {
            return homepage;
        }

        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getStargazersCount() {
            return stargazersCount;
        }

        public void setStargazersCount(Integer stargazersCount) {
            this.stargazersCount = stargazersCount;
        }

        public Integer getWatchersCount() {
            return watchersCount;
        }

        public void setWatchersCount(Integer watchersCount) {
            this.watchersCount = watchersCount;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public Boolean getHasIssues() {
            return hasIssues;
        }

        public void setHasIssues(Boolean hasIssues) {
            this.hasIssues = hasIssues;
        }

        public Boolean getHasProjects() {
            return hasProjects;
        }

        public void setHasProjects(Boolean hasProjects) {
            this.hasProjects = hasProjects;
        }

        public Boolean getHasDownloads() {
            return hasDownloads;
        }

        public void setHasDownloads(Boolean hasDownloads) {
            this.hasDownloads = hasDownloads;
        }

        public Boolean getHasWiki() {
            return hasWiki;
        }

        public void setHasWiki(Boolean hasWiki) {
            this.hasWiki = hasWiki;
        }

        public Boolean getHasPages() {
            return hasPages;
        }

        public void setHasPages(Boolean hasPages) {
            this.hasPages = hasPages;
        }

        public Integer getForksCount() {
            return forksCount;
        }

        public void setForksCount(Integer forksCount) {
            this.forksCount = forksCount;
        }

        public Object getMirrorUrl() {
            return mirrorUrl;
        }

        public void setMirrorUrl(Object mirrorUrl) {
            this.mirrorUrl = mirrorUrl;
        }

        public Boolean getArchived() {
            return archived;
        }

        public void setArchived(Boolean archived) {
            this.archived = archived;
        }

        public Boolean getDisabled() {
            return disabled;
        }

        public void setDisabled(Boolean disabled) {
            this.disabled = disabled;
        }

        public Integer getOpenIssuesCount() {
            return openIssuesCount;
        }

        public void setOpenIssuesCount(Integer openIssuesCount) {
            this.openIssuesCount = openIssuesCount;
        }

        public Object getLicense() {
            return license;
        }

        public void setLicense(Object license) {
            this.license = license;
        }

        public Integer getForks() {
            return forks;
        }

        public void setForks(Integer forks) {
            this.forks = forks;
        }

        public Integer getOpenIssues() {
            return openIssues;
        }

        public void setOpenIssues(Integer openIssues) {
            this.openIssues = openIssues;
        }

        public Integer getWatchers() {
            return watchers;
        }

        public void setWatchers(Integer watchers) {
            this.watchers = watchers;
        }

        public String getDefaultBranch() {
            return defaultBranch;
        }

        public void setDefaultBranch(String defaultBranch) {
            this.defaultBranch = defaultBranch;
        }

        public Integer getStargazers() {
            return stargazers;
        }

        public void setStargazers(Integer stargazers) {
            this.stargazers = stargazers;
        }

        public String getMasterBranch() {
            return masterBranch;
        }

        public void setMasterBranch(String masterBranch) {
            this.masterBranch = masterBranch;
        }

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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTreeId() {
            return treeId;
        }

        public void setTreeId(String treeId) {
            this.treeId = treeId;
        }

        public Boolean getDistinct() {
            return distinct;
        }

        public void setDistinct(Boolean distinct) {
            this.distinct = distinct;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public AuthorDTO getAuthor() {
            return author;
        }

        public void setAuthor(AuthorDTO author) {
            this.author = author;
        }

        public CommitterDTO getCommitter() {
            return committer;
        }

        public void setCommitter(CommitterDTO committer) {
            this.committer = committer;
        }

        public List<String> getAdded() {
            return added;
        }

        public void setAdded(List<String> added) {
            this.added = added;
        }

        public List<String> getRemoved() {
            return removed;
        }

        public void setRemoved(List<String> removed) {
            this.removed = removed;
        }

        public List<String> getModified() {
            return modified;
        }

        public void setModified(List<String> modified) {
            this.modified = modified;
        }

        @NoArgsConstructor
        @Data
        public static class AuthorDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;
        }

        public static class CommitterDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }
    }
}
