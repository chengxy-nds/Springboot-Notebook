package com.xiaofu.sharding.model;

public class TUser {

    private Long id;

    private String username;

    private String password;

    private Long shardingId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getShardingId() {
        return shardingId;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

}