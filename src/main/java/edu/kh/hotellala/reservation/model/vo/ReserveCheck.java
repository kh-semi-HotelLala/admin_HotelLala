package edu.kh.hotellala.reservation.model.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@ToString
public class ReserveCheck {

	private int reservationNo; // 예약번호
	private String requestNo;	// 주문번호 // OR202206110930599
	private char reservationFlag; // 예약상태
	private int paymentNo;	// 결제번호
	private int roomNo;	// 객실 호수	
	private String extraRequest; // 추가 요청사항
	
	private String memberName;//회원이름
	private String memberTel; //전화번호
	private String memberBR;// 생년월일
	private String memberAddress; //주소
	
	private Date checkIn; // 체크인 날짜
	private Date checkOut; // 체크아웃 날짜
	private Date paymentDate; // 결제일
	
	private int optionCode; // 옵션코드 (1=성인,2=어린이,3=엑스트라베드=인원수)
	private String payType; // 결제방법
	private int roomRates; // 룸 가격
	
}
