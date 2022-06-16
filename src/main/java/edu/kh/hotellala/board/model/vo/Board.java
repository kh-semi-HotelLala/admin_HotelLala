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

	private int boardNo; //게시글번호
	private String category; //카테고리
	private int cNo; //카테고리 번호
	private String title; 	//제목
	private String content; //내용
	private String createDate; //작성일
	private int adminNo; //작성한 관리자
}
//게시글 번호
//카테고리
//게시글 제목
//작성일: cannot insert NULL into ("HOTEL_LALA"."BOARD"."BOARD_TITLE")