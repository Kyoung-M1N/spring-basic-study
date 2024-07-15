package com.study1.poststudy.service;

import com.study1.poststudy.dto.request.SignUpRequest;
import com.study1.poststudy.dto.request.LoginRequest;
import com.study1.poststudy.domain.Member;

public interface MemberService {
    public Member signUp(SignUpRequest dto);

    public Member login(LoginRequest dto);
}
