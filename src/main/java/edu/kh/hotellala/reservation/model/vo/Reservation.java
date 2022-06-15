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
public class Reservation {

	private String requestNo;	// 주문번호 // OR202206110930599
	private Date checkIn; // 체크인 날짜
	private Date checkOut; // 체크아웃 날짜
	private String dateRange; // 숙박 기간(N박)
	private int adultCount; // 예약 인원(어른)
	private int childCount; // 예약 인원(아이)
	private int memberNo; // 회원 번호
	private String roomType; // 객실 종류
	private String extraRequest; // 추가 요청사항
	private char reservationFlag; // 예약상태
	private int roomNo;	// 객실 호수	
	
	private Date paymentDate; // 결제일

	private String memberName;//회원이름
	private String memberTel; //전화번호
	private String memberBR;// 생년월일
	private String memberAddress; //주소
	
}
