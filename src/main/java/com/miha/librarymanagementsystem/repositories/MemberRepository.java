package com.miha.librarymanagementsystem.repositories;

import com.miha.librarymanagementsystem.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
