package com.miha.librarymanagementsystem.services;

import com.miha.librarymanagementsystem.entities.Book;
import com.miha.librarymanagementsystem.entities.Member;
import com.miha.librarymanagementsystem.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberByID(Long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (memberOptional.isPresent()) {
            return memberOptional.get();
        }
        return null;
    }

    @Override
    public Member updateMemberByID(Member member, Long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (memberOptional.isPresent()) {
            member.setId(id);
            return memberRepository.save(member);
        }
        return null;
    }

    @Override
    public String deleteMemberByID(Long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (memberOptional.isPresent()) {
            memberRepository.deleteById(id);
            return "Member with ID " + id + " deleted successfully";
        }
        return null;
    }
}
