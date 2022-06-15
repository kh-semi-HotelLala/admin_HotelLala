package edu.kh.hotellala.reservation.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
	
	private String memberName;//회원이름
	private String memberTel; //전화번호
	private String memberBR;// 생년월일
	private String memberAddress; //주소

}
