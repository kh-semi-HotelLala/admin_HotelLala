package edu.kh.hotellala.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardQNA {
	private int qnaNo;
	private String category;
	private String title;
	private String content;
	private String answer;
	private String adminName;
	private String memberName;
	private String createDt;
	private String memberTel;
	private String memberEmail;
	private String answeContent;
}
