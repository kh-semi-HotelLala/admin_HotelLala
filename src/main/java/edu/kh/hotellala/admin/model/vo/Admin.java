package edu.kh.hotellala.admin.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Admin {
	private int adminNo;
	private String adminName;
	private String adminTel;
	private String adminEmail;
}
