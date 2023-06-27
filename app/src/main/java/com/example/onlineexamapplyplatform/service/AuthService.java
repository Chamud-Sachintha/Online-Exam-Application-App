package com.example.onlineexamapplyplatform.service;

import com.example.onlineexamapplyplatform.dto.Member;

public class AuthService {

    public boolean checkMemberLoginCredentials(Member memberDTO) throws Exception {
        try {
            if (memberDTO.getMemberEmail().equals("test@gmail.com") && memberDTO.getPassword().equals("123")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("There is an Error Occur" + e.getMessage());
        }
    }
}
