package vit.service;

import org.springframework.ui.Model;

import vit.domain.dto.NoticeSaveDto;

public interface HelpService {

	void noticeList(Model model, NoticeSaveDto dto);

	void noticeDetail(long nno, Model model);

}
