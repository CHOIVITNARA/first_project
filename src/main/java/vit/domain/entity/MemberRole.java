package vit.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MemberRole {
	
	USER("회원", "ROLE_USER"),
	ADMIN("관리자", "ROLE_ADMIN");
	
	final String title;
	final String role;
}
