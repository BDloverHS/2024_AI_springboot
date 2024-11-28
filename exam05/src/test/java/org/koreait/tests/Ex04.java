package org.koreait.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.member.constants.Authority;
import org.koreait.member.entities.Member;
import org.koreait.member.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles({"default", "test"})
public class Ex04 {
    @Autowired
    private MemberRepository repository;

    // 10명의 인원을 추가
    @BeforeEach
    void init() {
        Faker faker = new Faker();
        List<Member> members = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Member member = new Member();
            member.setEmail(faker.internet().emailAddress());
            member.setPassword(faker.regexify("[a-zA-Z0-9]{8,16}"));
            member.setAuthority(Authority.USER);
            member.setName(faker.name().fullName());
            members.add(member);
        }

        repository.saveAllAndFlush(members);
    }

    @Test
    void test1() {
        // 비어두면 모두 나옴
        // List<Member> members = repository.findByNameContainingOrderByRegDtDesc("");
        // members.forEach(System.out::println);

        // 0페이지, 한 페이지 당 3개 씩
        Pageable pageable = PageRequest.of(2,3);
        Page<Member> data = repository.findByNameContainingOrderByRegDtDesc("", pageable);

        List<Member> members = data.getContent(); // 조회된 목록
        long total = data.getTotalElements(); // 전체 개수
        int pages = data.getTotalPages(); // 전체 페이지 수

        members =
    }

    @Test
    void test2() {
        Pageable pageable = PageRequest.of(1,3); // 1~2 페이지
        // page 자료형을 쓰는 어노테이션
        Page<Member> data =  repository.findAll(pageable);
        List<Member> members = data.getContent();

    }
}
