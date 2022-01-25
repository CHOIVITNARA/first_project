package vit.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MemberRole {
	
	USER("ROLE_USER", "회원"),
	ADMIN("ROLE_ADMIN", "관리자");
	
	final String title;
	final String role;
}