package org.mbc.domain;

import java.sql.Date;

import lombok.Data;

@Data	// 생성자, getter/setter, toString 등...
public class BoardVO {
	// 객체용으로 vo는 읽기전용 속성이 강하게 만드는 객체( getter 위주로 세팅 )
	// dto는 getter/setter 모두 가지고 활용하는 객체
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date date;
	private Date updateDate;

}
