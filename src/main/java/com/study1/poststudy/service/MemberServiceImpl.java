package com.study1.poststudy.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.study1.poststudy.repository.MemberRepository;
import com.study1.poststudy.dto.request.SignUpRequest;
import com.study1.poststudy.dto.request.LoginRequest;
import com.study1.poststudy.domain.Member;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService, UserDetailsService{
    private final MemberRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Member signUp(SignUpRequest dto) {
        return repository.save(Member.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build());
    }

    @Override
    public Member login(LoginRequest dto) {
        Member member = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException());
        if (passwordEncoder.matches(dto.getPassword(), member.getPassword())) {
            return member;
        }
        throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(email));
    }
}
