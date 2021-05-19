package com.xiaofu.webhook.vo;

import lombok.Data;

import java.util.List;

/**
 * @author zhifu.xin@ipinyou.com
 * @Description:程序员内点事
 * @date 2021/05/19
 */
@Data
public class GithubWebhookPullVo {


    /**
     * zen : Speak like a human.
     * hook_id : 297538401
     * hook : {"type":"Repository","id":297538401,"name":"web","active":true,"events":["*"],"config":{"content_type":"json","insecure_ssl":"0","url":"https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=145a516a-dd15-421f-97a3-ba3bf1479369"},"updated_at":"2021-05-16T00:56:11Z","created_at":"2021-05-16T00:56:11Z","url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/hooks/297538401","test_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/hooks/297538401/test","ping_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/hooks/297538401/pings","last_response":{"code":null,"status":"unused","message":null}}
     * repository : {"id":275712523,"node_id":"MDEwOlJlcG9zaXRvcnkyNzU3MTI1MjM=","name":"Springboot-Notebook","full_name":"chengxy-nds/Springboot-Notebook","private":false,"owner":{"login":"chengxy-nds","id":12745094,"node_id":"MDQ6VXNlcjEyNzQ1MDk0","avatar_url":"https://avatars.githubusercontent.com/u/12745094?v=4","gravatar_id":"","url":"https://api.github.com/users/chengxy-nds","html_url":"https://github.com/chengxy-nds","followers_url":"https://api.github.com/users/chengxy-nds/followers","following_url":"https://api.github.com/users/chengxy-nds/following{/other_user}","gists_url":"https://api.github.com/users/chengxy-nds/gists{/gist_id}","starred_url":"https://api.github.com/users/chengxy-nds/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/chengxy-nds/subscriptions","organizations_url":"https://api.github.com/users/chengxy-nds/orgs","repos_url":"https://api.github.com/users/chengxy-nds/repos","events_url":"https://api.github.com/users/chengxy-nds/events{/privacy}","received_events_url":"https://api.github.com/users/chengxy-nds/received_events","type":"User","site_admin":false},"html_url":"https://github.com/chengxy-nds/Springboot-Notebook","description":"Springboot-Notebook 是一系列以 springboot 为基础开发框架，整合 Redis 、 Rabbitmq 、ES 、MongoDB 、Springcloud、kafka、skywalking等互联网主流技术，实现各种常见功能点的综合性案例。","fork":false,"url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook","forks_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/forks","keys_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/keys{/key_id}","collaborators_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/collaborators{/collaborator}","teams_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/teams","hooks_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/hooks","issue_events_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/issues/events{/number}","events_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/events","assignees_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/assignees{/user}","branches_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/branches{/branch}","tags_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/tags","blobs_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/git/blobs{/sha}","git_tags_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/git/tags{/sha}","git_refs_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/git/refs{/sha}","trees_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/git/trees{/sha}","statuses_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/statuses/{sha}","languages_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/languages","stargazers_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/stargazers","contributors_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/contributors","subscribers_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/subscribers","subscription_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/subscription","commits_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/commits{/sha}","git_commits_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/git/commits{/sha}","comments_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/comments{/number}","issue_comment_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/issues/comments{/number}","contents_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/contents/{+path}","compare_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/compare/{base}...{head}","merges_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/merges","archive_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/{archive_format}{/ref}","downloads_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/downloads","issues_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/issues{/number}","pulls_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/pulls{/number}","milestones_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/milestones{/number}","notifications_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/notifications{?since,all,participating}","labels_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/labels{/name}","releases_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/releases{/id}","deployments_url":"https://api.github.com/repos/chengxy-nds/Springboot-Notebook/deployments","created_at":"2020-06-29T02:34:59Z","updated_at":"2021-05-15T15:16:45Z","pushed_at":"2021-05-08T06:36:56Z","git_url":"git://github.com/chengxy-nds/Springboot-Notebook.git","ssh_url":"git@github.com:chengxy-nds/Springboot-Notebook.git","clone_url":"https://github.com/chengxy-nds/Springboot-Notebook.git","svn_url":"https://github.com/chengxy-nds/Springboot-Notebook","homepage":"","size":696179,"stargazers_count":544,"watchers_count":544,"language":"Java","has_issues":true,"has_projects":true,"has_downloads":true,"has_wiki":true,"has_pages":false,"forks_count":303,"mirror_url":null,"archived":false,"disabled":false,"open_issues_count":4,"license":null,"forks":303,"open_issues":4,"watchers":544,"default_branch":"master"}
     * sender : {"login":"chengxy-nds","id":12745094,"node_id":"MDQ6VXNlcjEyNzQ1MDk0","avatar_url":"https://avatars.githubusercontent.com/u/12745094?v=4","gravatar_id":"","url":"https://api.github.com/users/chengxy-nds","html_url":"https://github.com/chengxy-nds","followers_url":"https://api.github.com/users/chengxy-nds/followers","following_url":"https://api.github.com/users/chengxy-nds/following{/other_user}","gists_url":"https://api.github.com/users/chengxy-nds/gists{/gist_id}","starred_url":"https://api.github.com/users/chengxy-nds/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/chengxy-nds/subscriptions","organizations_url":"https://api.github.com/users/chengxy-nds/orgs","repos_url":"https://api.github.com/users/chengxy-nds/repos","events_url":"https://api.github.com/users/chengxy-nds/events{/privacy}","received_events_url":"https://api.github.com/users/chengxy-nds/received_events","type":"User","site_admin":false}
     */

    private String zen;
    private int hook_id;
    private HookBean hook;
    private RepositoryBean repository;
    private SenderBean sender;


    @Data
    public static class HookBean {
        /**
         * type : Repository
         * id : 297538401
         * name : web
         * active : true
         * events : ["*"]
         * config : {"content_type":"json","insecure_ssl":"0","url":"https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=145a516a-dd15-421f-97a3-ba3bf1479369"}
         * updated_at : 2021-05-16T00:56:11Z
         * created_at : 2021-05-16T00:56:11Z
         * url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/hooks/297538401
         * test_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/hooks/297538401/test
         * ping_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/hooks/297538401/pings
         * last_response : {"code":null,"status":"unused","message":null}
         */

        private String type;
        private int id;
        private String name;
        private boolean active;
        private ConfigBean config;
        private String updated_at;
        private String created_at;
        private String url;
        private String test_url;
        private String ping_url;
        private LastResponseBean last_response;
        private List<String> events;


        @Data
        public static class ConfigBean {
            /**
             * content_type : json
             * insecure_ssl : 0
             * url : https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=145a516a-dd15-421f-97a3-ba3bf1479369
             */

            private String content_type;
            private String insecure_ssl;
            private String url;
        }

        @Data
        public static class LastResponseBean {
            /**
             * code : null
             * status : unused
             * message : null
             */

            private Object code;
            private String status;
            private Object message;

        }
    }

    @Data
    public static class RepositoryBean {
        /**
         * id : 275712523
         * node_id : MDEwOlJlcG9zaXRvcnkyNzU3MTI1MjM=
         * name : Springboot-Notebook
         * full_name : chengxy-nds/Springboot-Notebook
         * private : false
         * owner : {"login":"chengxy-nds","id":12745094,"node_id":"MDQ6VXNlcjEyNzQ1MDk0","avatar_url":"https://avatars.githubusercontent.com/u/12745094?v=4","gravatar_id":"","url":"https://api.github.com/users/chengxy-nds","html_url":"https://github.com/chengxy-nds","followers_url":"https://api.github.com/users/chengxy-nds/followers","following_url":"https://api.github.com/users/chengxy-nds/following{/other_user}","gists_url":"https://api.github.com/users/chengxy-nds/gists{/gist_id}","starred_url":"https://api.github.com/users/chengxy-nds/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/chengxy-nds/subscriptions","organizations_url":"https://api.github.com/users/chengxy-nds/orgs","repos_url":"https://api.github.com/users/chengxy-nds/repos","events_url":"https://api.github.com/users/chengxy-nds/events{/privacy}","received_events_url":"https://api.github.com/users/chengxy-nds/received_events","type":"User","site_admin":false}
         * html_url : https://github.com/chengxy-nds/Springboot-Notebook
         * description : Springboot-Notebook 是一系列以 springboot 为基础开发框架，整合 Redis 、 Rabbitmq 、ES 、MongoDB 、Springcloud、kafka、skywalking等互联网主流技术，实现各种常见功能点的综合性案例。
         * fork : false
         * url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook
         * forks_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/forks
         * keys_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/keys{/key_id}
         * collaborators_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/collaborators{/collaborator}
         * teams_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/teams
         * hooks_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/hooks
         * issue_events_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/issues/events{/number}
         * events_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/events
         * assignees_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/assignees{/user}
         * branches_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/branches{/branch}
         * tags_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/tags
         * blobs_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/git/blobs{/sha}
         * git_tags_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/git/tags{/sha}
         * git_refs_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/git/refs{/sha}
         * trees_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/git/trees{/sha}
         * statuses_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/statuses/{sha}
         * languages_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/languages
         * stargazers_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/stargazers
         * contributors_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/contributors
         * subscribers_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/subscribers
         * subscription_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/subscription
         * commits_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/commits{/sha}
         * git_commits_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/git/commits{/sha}
         * comments_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/comments{/number}
         * issue_comment_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/issues/comments{/number}
         * contents_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/contents/{+path}
         * compare_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/compare/{base}...{head}
         * merges_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/merges
         * archive_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/{archive_format}{/ref}
         * downloads_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/downloads
         * issues_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/issues{/number}
         * pulls_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/pulls{/number}
         * milestones_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/milestones{/number}
         * notifications_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/notifications{?since,all,participating}
         * labels_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/labels{/name}
         * releases_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/releases{/id}
         * deployments_url : https://api.github.com/repos/chengxy-nds/Springboot-Notebook/deployments
         * created_at : 2020-06-29T02:34:59Z
         * updated_at : 2021-05-15T15:16:45Z
         * pushed_at : 2021-05-08T06:36:56Z
         * git_url : git://github.com/chengxy-nds/Springboot-Notebook.git
         * ssh_url : git@github.com:chengxy-nds/Springboot-Notebook.git
         * clone_url : https://github.com/chengxy-nds/Springboot-Notebook.git
         * svn_url : https://github.com/chengxy-nds/Springboot-Notebook
         * homepage :
         * size : 696179
         * stargazers_count : 544
         * watchers_count : 544
         * language : Java
         * has_issues : true
         * has_projects : true
         * has_downloads : true
         * has_wiki : true
         * has_pages : false
         * forks_count : 303
         * mirror_url : null
         * archived : false
         * disabled : false
         * open_issues_count : 4
         * license : null
         * forks : 303
         * open_issues : 4
         * watchers : 544
         * default_branch : master
         */

        private int id;
        private String node_id;
        private String name;
        private String full_name;

        private boolean privateX;
        private OwnerBean owner;
        private String html_url;
        private String description;
        private boolean fork;
        private String url;
        private String forks_url;
        private String keys_url;
        private String collaborators_url;
        private String teams_url;
        private String hooks_url;
        private String issue_events_url;
        private String events_url;
        private String assignees_url;
        private String branches_url;
        private String tags_url;
        private String blobs_url;
        private String git_tags_url;
        private String git_refs_url;
        private String trees_url;
        private String statuses_url;
        private String languages_url;
        private String stargazers_url;
        private String contributors_url;
        private String subscribers_url;
        private String subscription_url;
        private String commits_url;
        private String git_commits_url;
        private String comments_url;
        private String issue_comment_url;
        private String contents_url;
        private String compare_url;
        private String merges_url;
        private String archive_url;
        private String downloads_url;
        private String issues_url;
        private String pulls_url;
        private String milestones_url;
        private String notifications_url;
        private String labels_url;
        private String releases_url;
        private String deployments_url;
        private String created_at;
        private String updated_at;
        private String pushed_at;
        private String git_url;
        private String ssh_url;
        private String clone_url;
        private String svn_url;
        private String homepage;
        private int size;
        private int stargazers_count;
        private int watchers_count;
        private String language;
        private boolean has_issues;
        private boolean has_projects;
        private boolean has_downloads;
        private boolean has_wiki;
        private boolean has_pages;
        private int forks_count;
        private Object mirror_url;
        private boolean archived;
        private boolean disabled;
        private int open_issues_count;
        private Object license;
        private int forks;
        private int open_issues;
        private int watchers;
        private String default_branch;


        @Data
        public static class OwnerBean {
            /**
             * login : chengxy-nds
             * id : 12745094
             * node_id : MDQ6VXNlcjEyNzQ1MDk0
             * avatar_url : https://avatars.githubusercontent.com/u/12745094?v=4
             * gravatar_id :
             * url : https://api.github.com/users/chengxy-nds
             * html_url : https://github.com/chengxy-nds
             * followers_url : https://api.github.com/users/chengxy-nds/followers
             * following_url : https://api.github.com/users/chengxy-nds/following{/other_user}
             * gists_url : https://api.github.com/users/chengxy-nds/gists{/gist_id}
             * starred_url : https://api.github.com/users/chengxy-nds/starred{/owner}{/repo}
             * subscriptions_url : https://api.github.com/users/chengxy-nds/subscriptions
             * organizations_url : https://api.github.com/users/chengxy-nds/orgs
             * repos_url : https://api.github.com/users/chengxy-nds/repos
             * events_url : https://api.github.com/users/chengxy-nds/events{/privacy}
             * received_events_url : https://api.github.com/users/chengxy-nds/received_events
             * type : User
             * site_admin : false
             */

            private String login;
            private int id;
            private String node_id;
            private String avatar_url;
            private String gravatar_id;
            private String url;
            private String html_url;
            private String followers_url;
            private String following_url;
            private String gists_url;
            private String starred_url;
            private String subscriptions_url;
            private String organizations_url;
            private String repos_url;
            private String events_url;
            private String received_events_url;
            private String type;
            private boolean site_admin;


        }
    }

    @Data
    public static class SenderBean {
        /**
         * login : chengxy-nds
         * id : 12745094
         * node_id : MDQ6VXNlcjEyNzQ1MDk0
         * avatar_url : https://avatars.githubusercontent.com/u/12745094?v=4
         * gravatar_id :
         * url : https://api.github.com/users/chengxy-nds
         * html_url : https://github.com/chengxy-nds
         * followers_url : https://api.github.com/users/chengxy-nds/followers
         * following_url : https://api.github.com/users/chengxy-nds/following{/other_user}
         * gists_url : https://api.github.com/users/chengxy-nds/gists{/gist_id}
         * starred_url : https://api.github.com/users/chengxy-nds/starred{/owner}{/repo}
         * subscriptions_url : https://api.github.com/users/chengxy-nds/subscriptions
         * organizations_url : https://api.github.com/users/chengxy-nds/orgs
         * repos_url : https://api.github.com/users/chengxy-nds/repos
         * events_url : https://api.github.com/users/chengxy-nds/events{/privacy}
         * received_events_url : https://api.github.com/users/chengxy-nds/received_events
         * type : User
         * site_admin : false
         */

        private String login;
        private int id;
        private String node_id;
        private String avatar_url;
        private String gravatar_id;
        private String url;
        private String html_url;
        private String followers_url;
        private String following_url;
        private String gists_url;
        private String starred_url;
        private String subscriptions_url;
        private String organizations_url;
        private String repos_url;
        private String events_url;
        private String received_events_url;
        private String type;
        private boolean site_admin;


    }
}
