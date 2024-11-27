package org.koreait.member.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.koreait.global.entities.BaseEntity;


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
    @Column(length = 65, nullable = false)
    private String password;
    @Column(length = 40, nullable = false)
    private String name;

    @Lob // 오라클 기준 CLOB
    private String introduction;

    /*
    @Temporal(TemporalType.TIME)
    private Data birthDt;
     */
}