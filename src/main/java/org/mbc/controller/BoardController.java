package org.mbc.controller;

import org.mbc.domain.BoardVO;
import org.mbc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller	// url 분기와 jsp 연동을 담당한다.
@Log4j2
@RequestMapping("/board/*")	// http://192.168.111.104:80/board/*
@AllArgsConstructor		// 생성자 자동 주입 (모든 필드를 생성자를 통해 주입하도록 한다)
public class BoardController {

	// 리스트와 crud를 담당하는 분기 설정 (url)
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("BoardController.list 메서드 실행...");
		
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		// RedirectAttributes rttr 성공 후 이동할 경로를 기입한다.
		
		log.info("BoardController.register메서드 실행...");
		
		service.register(board);		// 객체 등록을 한다.
		
		rttr.addFlashAttribute("result", board.getBno());	// 이동할 계정을 배정
		// 전달한 값을 1회용으로, 프론트에서 alert 용으로 활용된다.
		
		return "redirect:/board/list";	// 성공 후 넘어갈 다음 페이지
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		log.info("BoardController.get 메서드 실행...");
		
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardController.modify 메서드 실행...");
		
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("BoardController.remove 메서드 실행...");
		
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "sucess");
		}
		
		return "redirect:/board/list";
	}
	
}
