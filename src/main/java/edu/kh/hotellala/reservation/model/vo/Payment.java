package edu.kh.hotellala.reservation.model.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Payment {
	
	private int paymentNo;	// 결제번호
	private Date paymentDate; // 결제일
	
	private int optionCode; // 옵션코드 (1=성인,2=어린이,3=엑스트라베드=인원수)
	private String payType; // 결제방법
	private int roomRates; // 룸 가격
	
	private int refundNo; // 환불번호
	private char refundAmount; // 환불 금액
	private Date refundDate; // 환불 요청일
	private String refundReson; // 환불 사유

}
