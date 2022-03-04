package vit.service.impl;

import java.io.File;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import vit.domain.dto.NoticeSaveDto;
import vit.domain.dto.TravelSaveDto;
import vit.domain.entity.MemberEntity;
import vit.domain.entity.NoticeEntity;
import vit.domain.entity.NoticeEntityRepository;
import vit.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private NoticeEntityRepository noticeEntityRepository;
	//글저장
	@Override
	public void noticeSave(NoticeSaveDto dto, Principal principal) {
		NoticeEntity entity=NoticeEntity.builder()
				.section(dto.getSection())
				.subject(dto.getSubject())
				.content(dto.getContent())
				.memberEntity(MemberEntity.builder().name(principal.getName()).build())
				.build();
		
		noticeEntityRepository.save(entity);
		
	}
	
	@Override
	public void noticeList(Model model) {
		
		Sort sort=Sort.by(Direction.DESC, "nno");
		Pageable pageable=PageRequest.of(0, 5, Direction.DESC, "nno");
		Page<NoticeEntity> entity=noticeEntityRepository.findAll(pageable);
		model.addAttribute("noticeList", entity);
	}

	@Override
	public void noticeDetail(long nno, Model model) {
		NoticeEntity result=noticeEntityRepository.findById(nno).orElseThrow();
		model.addAttribute("noticeDetail", result);
		
	}
	
	//삭제
	@Override
	public void noticeDelete(long nno) {
		noticeEntityRepository.deleteById(nno);
	}
	
	//수정
	@Override
	public void noticeUpdate(Long nno, NoticeSaveDto dto, Principal principal) {
		NoticeEntity result=noticeEntityRepository.findById(nno).orElseThrow();
		result.updateDetail(dto);
		
		noticeEntityRepository.save(result);
	}
		
	@Override
	public void travelSave(TravelSaveDto dto, MultipartFile file) throws Exception{
		String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\file";
		
		UUID uuid=UUID.randomUUID();
		
		String fileNewName = uuid + "_" + file.getOriginalFilename();
		
		File saveFile = new File(projectPath,fileNewName);
		
		file.transferTo(saveFile);
		
	}
	

}
