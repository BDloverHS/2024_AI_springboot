package org.koreait.tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.member.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
@ActiveProfiles({"default", "test"})
public class Ex04 {
    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        em.getTransaction().begin();
    }

    @AfterEach
    void destroy() {
        em.getTransaction().commit();
    }

    @Test
    void test1() {
        for (int i = 1; i <= 10; i++) {
            Member member = new Member();
            member.setEmail("user" + i + "@test.org");
            member.setPassword("12345678");
            member.setName("사용자" + i);

            em.persist(member);
        }

        em.flush();
        em.clear();

        Member member1 = em.find(Member.class, 1L);
        Member member2 = em.find(Member.class, 1L);

    }
}
