package com.study1.poststudy.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.study1.poststudy.dto.request.SignUpRequest;
import com.study1.poststudy.service.MemberServiceImpl;
import com.study1.poststudy.dto.request.LoginRequest;
import com.study1.poststudy.domain.Member;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController implements MemberOperations {
    private final MemberServiceImpl service;

    @Override
    public ResponseEntity<Member> signup(SignUpRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.signUp(dto));
    }

    @Override
    public ResponseEntity<Member> login(LoginRequest dto) {
        return ResponseEntity.ok(service.login(dto));
    }

    @Override
    public ResponseEntity<UserDetails> mypage(String email) {
        return ResponseEntity.ok(service.loadUserByUsername(email));
    }
}
