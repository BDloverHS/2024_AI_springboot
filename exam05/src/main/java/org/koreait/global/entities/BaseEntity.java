package org.koreait.global.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.sql.Update;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass // 다른 엔티티의 상위 클래스임을 알려주는 어노테이션
@EntityListeners(AuditingEntityListener.class) // 엔티티의 변화 감지를 확인할 수 있다!
public abstract class BaseEntity {
    @Column(updatable = false)
    // @CreationTimestamp // insert 시 시간 자동 저장
    @CreatedDate
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;

    @Column(insertable = false)
    // @UpdateTimestamp // update 시 시간 자동 저장
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime modDt;
}
