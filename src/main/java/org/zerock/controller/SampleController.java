package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Controller	// servlet-context.xml 에서 Component-scan 으로 탐색 후 @Controller로 인해 빈객체로 등록된다.
@RequestMapping("/sample/*")	// http://192.168.111.104:80/controller/sample/* 의 요청에 반응한다.
@Log4j2		// resources 폴더에 log4j2.xml 파일 필수! 
public class SampleController {
	
	@RequestMapping("")		//http://192.168.111.104:80/controller/sample/""
	public void basic() {
		log.info("SampleController.basic() 메서드 실행!");
		log.info("return 이 void 이기 때문에 basic.jsp 파일을 찾습니다.");
		log.info("현재 /WEB-INF/views/basic.jsp가 없으므로 브라우저에 오류가 발생합니다.");
		
		// return 타입이 void 이므로 "파일 [/WEB-INF/views/sample.jsp]을(를) 찾을 수 없습니다." 가 출력
		// 기본적으로 url에 경로에 대한 jsp를 찾으려고 한다.
	}
	
	@RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})	// http://192.168.111.104:80/controller/sample/basic 으로 요청 -> get 과 post 요청 모두 처리
	public void basicGet1() {
		log.info("SampleController.basicGet1() 메서드 실행!");
		log.info("get 요청과 post 요청 모두 처리한다.");
		
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("SampleController.basicGet2() 메서드 실행!");
		log.info("get 요청에 반응한다");
	}
	
	@PostMapping("/basicOnlyPost")
	public void basicPost() {
		log.info("SampleController.basicPost() 메서드 실행!");
		log.info("post 요청에 반응한다");
	}
	
	@GetMapping("/ex01")	// http://192.168.111.104:80/controller/sample/ex01?name=000&age=00
	public String ex01(SampleDTO dto) {	// SampleDTO dto = new SampleDTO();	스프링에 의해 컨테이너의 객체를 가져온다.
		
		log.info("SampleController.ex01() 메서드 실행");
		log.info("get방식에 반응한다.");
		log.info("입력 dto 확인 : " + dto);
		
		return "ex01";		//servlet-context.xml 의 설정으로 인해 WEB-INF/views/ex01.jsp 를 브라우저에 출력한다.
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		log.info("name : " + name);
		log.info("age : " + age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")	// http://192.168.111.104:80/controller/sample/ex02List?ids=111&ids=222&ids=333
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		// 리스트로 넘어오는 데이터를 처리하는 메서드
		
		log.info("리스트로 넘어온 데이터 처리 : " + ids);
		log.info("리스트로 2번째 값 확인 : " + ids.get(2));
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		
		// url 경로에 배열로 들어오는 파라미터
		// /ex02Bean?list[0].name=kkw&list[2].age=33
		
		log.info("list SampleDTOs : " + list);
		
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("todo : " + todo);
		
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page")int page) {
		
		log.info("dto : " + dto);	// name, age
		log.info("page : " + page);
		
		return "sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("SampleController.ex05 메서드 실행");
		// 리턴이 void인 경우에는 자동으로 [WEB-INF/views/sample/ex05.jsp]를 찾는다.
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {	// @ResponseBody SampleDTO : 응답 바디에 객체를 담아 리턴을 한다.
		log.info("/ex06 메서드 실행!!");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("kkw");
		dto.setAge(33);
		
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		// ResponseEntity<String> 응답헤더 (200 ok, 404 page not found, 304 ...) 를 만들어 리턴한다.
		log.info("SampleController.ex07 메서드 실행");
		
		String msg = "{\"name\":\"kkw\"}";	// json 으로 {name : kkw} 가 들어간다.
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		// 헤더에 타입 추가용
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
		// msg에는 json 데이터 / header에는 json 타입/ 상태값은 ok -> 200
	}
}
