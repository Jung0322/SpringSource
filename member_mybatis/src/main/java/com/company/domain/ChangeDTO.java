package com.company.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChangeDTO {
	private String userid;
	private String password; //���� ��й�ȣ
	private String new_password;
	private String confirm_password; // ������ ��й�ȣ
}