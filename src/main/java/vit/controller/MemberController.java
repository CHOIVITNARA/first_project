package vit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/log/page")
	public String loginPage() {
		return "login/loginPage";
	}
	@GetMapping("/log/join")
	public String joinPagePre() {
		return "login/join";
	}
	@GetMapping("/log/join1")
	public String joinPage1() {
		return "login/join1";
	}
}
