package com.study1.poststudy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study1.poststudy.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
    Optional<Member> findByEmail(String email);
}
