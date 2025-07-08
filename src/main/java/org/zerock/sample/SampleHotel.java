package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//@AllArgsConstructor	// 모든 필드값을 이용해 생성자 주입
@RequiredArgsConstructor	// @NonNull만 생성자로 넣는다.
public class SampleHotel {

	// 묵시적 자동 주입 : 
	// 스프링의 의존관계 주입에는 두 가지 방법이 있다 : 생성자 주입 / setter 주입
	// 생성자 주입은 롬북이 알아서 파라미터를 만들어 준다.
	// 생성자 주입의 경우 객체 생성 시 의존관계 주입이 필요하므로 좀 더 엄격하게 의존관계 주입을 체크한다.
	// 세터 주입은 값을 저장시 자동 객체를 생성해준다. @Setter(onmethod_ = @Qutowired)
	
	@NonNull	
	private Chef chef;	// 필드
	private Restaurant restaurant;
	private String name;
	
//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}	// 사용자 정의 생성자 -> 기본 생성자는 따로 없는 상태
	
}
