package com.miha.librarymanagementsystem.controllers;

import com.miha.librarymanagementsystem.entities.Member;
import com.miha.librarymanagementsystem.services.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    MemberServiceImpl memberService;

    @GetMapping
    public ResponseEntity<?> getAllMember() {
        List<Member> members = memberService.getAllMember();
        if (members.isEmpty()) {
            return new ResponseEntity<>("Member list is empty", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(members, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.createMember(member), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMemberByID(@PathVariable("id") Long id) {
        Member member = memberService.getMemberByID(id);

        if (member == null) {
            return new ResponseEntity<>("Member not found!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMemberByID(@RequestBody Member member, @PathVariable("id") Long id) {
        Member updatedMember = memberService.updateMemberByID(member, id);
        if (updatedMember == null) {
            return new ResponseEntity<>("Member ID not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemberByID(@PathVariable("id") Long id) {
        String result = memberService.deleteMemberByID(id);
        if (result == null) {
            return new ResponseEntity<>("Member ID not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
