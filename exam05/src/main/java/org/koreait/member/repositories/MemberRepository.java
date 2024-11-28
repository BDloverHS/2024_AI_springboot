package org.koreait.member.repositories;

import org.koreait.member.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    // Member findByEmail(String email);
    Optional<Member> findByEmail(String email);

    // List<Member> findByNameContainingOrderByRegDtDesc(String keyword);

    // Pageable로 인해 Page 참조자료형을 써야함
    Page<Member> findByNameContainingOrderByRegDtDesc(String keyword, Pageable pageable);

}
