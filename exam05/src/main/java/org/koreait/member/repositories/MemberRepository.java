package org.koreait.member.repositories;

import org.koreait.member.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    //Member findByEmail(String email);
    Optional<Member> findByEmail(String email);

    //List<Member> findByNameContainingOrderByRegDtDesc(String keyword, Pageable pageable);
    Page<Member> findByNameContainingOrderByRegDtDesc(String keyword, Pageable pageable);

    /**
     * JPQL - 엔티티 기준이 SQL문 작성, 절대 테이블괴 테이블 컬럼이 아니다.
     * Query 어노테이션에서 테이블명이 아닌 엔티티명
     *
     * @param keyword
     * @return
     */
    @Query("SELECT m FROM Member m WHERE m.name LIKE :key ORDER BY m.regDt DESC")
    List<Member> getMembers(@Param("key") String keyword);

}