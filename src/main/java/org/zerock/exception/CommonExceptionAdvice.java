package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice	// 예외처리목적
@Log4j2
public class CommonExceptionAdvice {
	// mvc 에서 예외처리를 담당하는 공통적인 지원 클래스
	
	@ExceptionHandler(Exception.class)	// 내장된 예외처리 객체로 사용 시
	public String except(Exception ex, Model model) {
		// Exception : 예외처리 통로
		// Model : 스프링 데이터 관리 객체
		log.error("CommonExceptionAdvice.except()....");
		log.error("예외 발생 : " + ex.getMessage());	// 콘솔에 찍히는 에러
		log.error(model);	// 모델에 저장된 예외문구 처리
		model.addAttribute("exception", ex);	// 예외 발생값을 Model 객체를 통해 보낸다.
		
		return "error_page";
	}	// 예외처리도 스프링이 관리를 해야한다. servlet-context.xml 에 Component scan을 해야 한다.
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)		// 404 오류에 대한 헨들링
	public String handle404(NoHandlerFoundException ex) {
		
		return "custom404";
	}
}
