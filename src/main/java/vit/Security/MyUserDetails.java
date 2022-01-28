package vit.Security;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import vit.domain.entity.MemberEntity;

@Getter
public class MyUserDetails extends User implements OAuth2User{
	
	private String name;
	private String nickName;
	private boolean isSocial;
	

	public MyUserDetails(MemberEntity entity) {
		super(entity.getEmail(), 
				entity.getPassword(),
				entity.getRoleSet().stream().map(role->new SimpleGrantedAuthority(role.getRole()))
				.collect(Collectors.toSet()));
		
		name=entity.getName();
		isSocial=entity.isSocial();
	}

	@Override
	public Map<String, Object> getAttributes() {
		return null;
	}

}
