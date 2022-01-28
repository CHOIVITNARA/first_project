package vit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import vit.domain.dto.MemberSaveDto;
import vit.service.MemberService;
import vit.service.impl.MemberServiceimpl;

@RequiredArgsConstructor
@Controller
public class MemberController {

	private final MemberService service;
	
	@GetMapping("/log/page")
	public String loginPage() {
		return "login/loginPage";
	}
	@GetMapping("/log/member")
	public String logmember() {
		return "redirect:/";
	}
	
	@GetMapping("/log/join")
	public String joinPagePre() {
		return "login/join";
	}
	@GetMapping("/log/join1")
	public String joinPage1() {
		return "login/join1";
	}
	@PostMapping("/log/joinus")
	public String joinus(MemberSaveDto dto) {
		return service.joinus(dto);
	}
	
}
