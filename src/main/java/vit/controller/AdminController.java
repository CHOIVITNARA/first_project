package vit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vit.domain.dto.NoticeSaveDto;
import vit.domain.dto.TravelSaveDto;
import vit.service.AdminService;
import vit.service.impl.AdminServiceImpl;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/admin")
	public String adminPage(){
		return "admin/aindex";
	}
	@GetMapping("/admin/helpNotice")
	public String noticePage(Model model){
		service.noticeList(model);
		return "admin/help/notice";
	}
	@GetMapping("/admin/noticeWrite")
	public String noticeWritePage(){
		return "admin/help/noticeWrite";
	}
	@PostMapping("/noticeWrite/save")
	public String noticeWriteSave(NoticeSaveDto dto, Principal principal){
		service.noticeSave(dto, principal);
		return "redirect:/admin/helpNotice";
	}
	@GetMapping("/admin/noticeDetail/{nno}")
	public String noticeDetailPage(@PathVariable long nno, Model model){
		service.noticeDetail(nno, model);
		return "admin/help/noticeDetail";
	}
	@GetMapping("/admin/noticeDelete/{nno}")
	public String noticeDelete(@PathVariable long nno){
		service.noticeDelete(nno);
		return "redirect:/admin/helpNotice";
	}
	@GetMapping("/admin/main/line1")
	public String main1UploadPage(){
		return "admin/main/line1";
	}
	@GetMapping("/admin/main/line2")
	public String main2UploadPage(){
		return "admin/main/line2";
	}
	@GetMapping("/admin/main/line3")
	public String main3UploadPage(){
		return "admin/main/line3";
	}
	
	@GetMapping("/admin/travel")
	public String travelPage(){
		return "admin/travel/travelList";
	}
	@GetMapping("/admin/travelWrite")
	public String travelWritePage(){
		return "admin/travel/travelWrite";
	}
	@PostMapping("/admin/travelWrite")
	public String travelWriteSave(TravelSaveDto dto, MultipartFile file) throws Exception{
		service.travelSave(dto, file);
		return "admin/travel/travelWrite";
	}
	@PostMapping("/admin/noticeUpdate/{nno}")
	public String noticeDetailPage(NoticeSaveDto dto, Principal principal){
		service.noticeUpdate(dto, principal);
		return "admin/help/noticeDetail";
	}
}
