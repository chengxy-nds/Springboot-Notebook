package com.xiaofu.webhook.vo;

import lombok.Data;

@Data
public class GithubUser {


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
     * name : 程序员内点事
     * company : null
     * blog :
     * location : null
     * email : null
     * hireable : null
     * bio : 公众号：程序员内点事
     * twitter_username : null
     * public_repos : 6
     * public_gists : 0
     * followers : 73
     * following : 0
     * created_at : 2015-06-04T09:22:44Z
     * updated_at : 2021-05-29T04:09:56Z
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
    private String name;
    private Object company;
    private String blog;
    private Object location;
    private Object email;
    private Object hireable;
    private String bio;
    private Object twitter_username;
    private int public_repos;
    private int public_gists;
    private int followers;
    private int following;
    private String created_at;
    private String updated_at;
}
