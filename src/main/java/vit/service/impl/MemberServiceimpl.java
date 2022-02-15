package vit.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vit.domain.dto.MemberSaveDto;
import vit.domain.entity.MemberEntity;
import vit.domain.entity.MemberEntityRepository;
import vit.domain.entity.MemberRole;
import vit.service.MemberService;

@RequiredArgsConstructor
@Service
public class MemberServiceimpl implements MemberService {
	
	final MemberEntityRepository repository;
	final PasswordEncoder passwordEncoder;
	
	@Override
	public String joinus(MemberSaveDto dto) {
		MemberEntity entity=MemberEntity.builder()
				.email(dto.getEmailId()+"@"+dto.getEmailSite())
				.password(passwordEncoder.encode(dto.getPassword()))
				.name(dto.getName())
				.phoneNumber(dto.getPhoneNumber())
				.birth(dto.getBirth())
				.gender(dto.getGender())
				.hanaAgree(dto.isHanaAgree())
				.personalAgree(dto.isPersonalAgree())
				.personalOtherAgree(dto.isPersonalOtherAgree())
				.locationAgree(dto.isLocationAgree())
				.marcketingAgree(dto.isMarcketingAgree())
				.marcketingOtherAgree(dto.isMarcketingOtherAgree())
				.build();
		entity.addRole(MemberRole.USER);
		repository.save(entity);
		System.out.println(entity);
		return "login/join2";
	}

	@Override
	public String idCheck(String email) {
        if (repository.findById(email).isPresent()) {
            return "red";
        } else {
            return "green";
        }
    }

	
	
	
}
