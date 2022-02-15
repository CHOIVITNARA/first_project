package vit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import vit.domain.dto.NoticeSaveDto;
import vit.domain.entity.NoticeEntity;
import vit.domain.entity.NoticeEntityRepository;
import vit.service.HelpService;

@Service
public class HelpServiceImpl implements HelpService {
	
	@Autowired
	private NoticeEntityRepository noticeEntityRepository;
	
	@Override
	public void noticeList(Model model, NoticeSaveDto dto) {
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

}
