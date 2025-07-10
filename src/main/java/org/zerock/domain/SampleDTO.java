package org.zerock.domain;

import lombok.Data;

@Data	// lombok이 DTO를 관리한다.
public class SampleDTO {
	
	// 자바빈즈 규약
	// 1. 필드는 private 
	// 2. 생성자는 기본생성자가 필수이다.
	// 3. getter, setter를 사용한다.
	// lombok을 사용하면 자동생성된다.
	
	private String name;
	private int age;

}
