package org.koreait.board.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

// 필수로 정의해야 할 어노테이션 2가지
@AllArgsConstructor
@EqualsAndHashCode // 겹치지 않도록 하기 위함


public class BoardViewId {
    private int uid;
    private long seq;
}
