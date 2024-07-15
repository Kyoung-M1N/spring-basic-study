package com.study1.poststudy.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import com.study1.poststudy.dto.request.SignUpRequest;
import com.study1.poststudy.dto.request.LoginRequest;
import com.study1.poststudy.domain.Member;

public interface MemberOperations {
    @PostMapping("/signup")
    ResponseEntity<Member> signup(@RequestBody SignUpRequest dto);

    @PostMapping("/login")
    ResponseEntity<Member> login(@RequestBody LoginRequest dto);

    @GetMapping("/mypage/{email}")
    ResponseEntity<UserDetails> mypage(@PathVariable String email);
    
    // @GetMapping("/login")
    // void getlogin();

    // @GetMapping
    // UserDetails home();
}
