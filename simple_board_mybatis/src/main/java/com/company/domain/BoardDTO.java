package com.company.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class BoardDTO {
	private int bno;
	private String title;
	private String	content;
	private String writer;
	private Date regdate;
	private Date updatedate;
}
