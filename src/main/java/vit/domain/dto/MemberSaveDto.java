package vit.domain.dto;

import lombok.Data;

@Data
public class MemberSaveDto {

	
	private String emailId;
	private String emailSite;
	
	private String password;
	private String name;
	private String gender;
	private String phoneNumber;
	private String birth;

	private boolean hanaAgree;
	private boolean personalAgree;
	private boolean personalOtherAgree;
	private boolean locationAgree;
	private boolean marcketingAgree;
	private boolean marcketingOtherAgree;
}
