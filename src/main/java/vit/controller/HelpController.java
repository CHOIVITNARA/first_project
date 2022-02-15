package vit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vit.domain.dto.NoticeSaveDto;
import vit.service.HelpService;
import vit.service.impl.HelpServiceImpl;

@Controller
public class HelpController {
	
	@Autowired
	private HelpService service;
	
	@GetMapping("/help")
	public String helpZone() {
		return "help/hindex";
	}
	@GetMapping("/help/notice")
	public String helpNotice(Model model, NoticeSaveDto dto ) {
		service.noticeList(model, dto);
		return "help/notice";
	}
	@GetMapping("noticeDetail/{nno}")
	public String noticeDetailPage(@PathVariable long nno, Model model){
		service.noticeDetail(nno, model);
		return "help/hnoticeDetail";
	}
}
