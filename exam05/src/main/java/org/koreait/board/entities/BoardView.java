package org.koreait.board.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Data
@Entity
@IdClass(BoardView.class)
public class BoardView {
    @Id
    @Column(name = "_UID")
    private int uid; // 회원 Unique 아이디

    @Id
    private long seq; // 게시글 번호
}
