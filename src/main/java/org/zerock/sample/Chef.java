package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component	// 어노테이션을 통한 의존관계 주입
@Data		// lombok.Data : DTO 처리용 ( getter/setter, toString, equlas 등...)
public class Chef {
	
	private String name;
	private int age;
	
}
