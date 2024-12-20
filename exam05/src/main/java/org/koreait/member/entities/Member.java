package org.koreait.member.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.koreait.global.entities.BaseEntity;
import org.koreait.member.constants.Authority;


import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
// @Table(name="KT_MEMBER")
public class Member extends BaseEntity {
    @Id //  기본키
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    private Long seq;

    @Column(length = 65, nullable = false, unique = true)
    private String email;

    @JsonIgnore // JSON 문자열 변환 배제
    @Column(length = 65, nullable = false)
    private String password;

    @Column(length = 40, nullable = false)
    private String name;

    // @Lob // 오라클 기준 CLOB
    // DB에는 생기지 않음
    @Transient
    private String introduction;

    @Enumerated(EnumType.STRING)
    @Column(length=10, nullable = false)
    private Authority authority;

    /*
    @Temporal(TemporalType.TIME)
    private Data birthDt;
     */

    @OneToOne // adress_seq
    private Address address;
}