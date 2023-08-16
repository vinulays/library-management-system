package com.miha.librarymanagementsystem.services;

import com.miha.librarymanagementsystem.entities.Member;

import java.util.List;

public interface MemberService {
    Member createMember(Member member);

    List<Member> getAllMember();

    Member getMemberByID(Long id);

    Member updateMemberByID(Member member, Long id);

    String deleteMemberByID(Long id);

}
