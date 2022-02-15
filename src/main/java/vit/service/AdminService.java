package vit.service;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import vit.domain.dto.NoticeSaveDto;
import vit.domain.dto.TravelSaveDto;

public interface AdminService {

	void noticeSave(NoticeSaveDto dto, Principal principal);

	void noticeList(Model model);

	void noticeDetail(long nno, Model model);

	void noticeDelete(long nno);

	void travelSave(TravelSaveDto dto, MultipartFile file) throws Exception;

	void noticeUpdate(NoticeSaveDto dto, Principal principal);

}
