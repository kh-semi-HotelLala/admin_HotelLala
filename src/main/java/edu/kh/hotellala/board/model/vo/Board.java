package edu.kh.hotellala.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Board {

	private int boardNo;
	private String category;
	private String content;
	private String boardType;
	private String 작성일;
	
}
//기타	1번글 공지사항 제목	1번 공지사항 기타 카테고리 내용입니다	NOTICE	22/06/13