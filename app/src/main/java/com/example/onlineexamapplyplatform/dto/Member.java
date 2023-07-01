package com.example.onlineexamapplyplatform.dto;

public class Member {

    private String username;
    private String memberEmail;
    private String password;

    public Member() {
    }

    public Member(String username, String memberEmail, String password) {
        this.username = username;
        this.memberEmail = memberEmail;
        this.password = password;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
