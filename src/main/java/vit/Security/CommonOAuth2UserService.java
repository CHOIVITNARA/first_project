package vit.Security;

import java.util.Map;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vit.domain.entity.MemberEntity;
import vit.domain.entity.MemberEntityRepository;
import vit.domain.entity.MemberRole;

@RequiredArgsConstructor
@Service
public class CommonOAuth2UserService extends DefaultOAuth2UserService{ //교재에 나와있는 OAuth2UserService는 설정이 복잡해서 이걸로 상속받는 걸로!
	
	CommonOAuth2Provider co;
	private final PasswordEncoder passwordEncoder;
	private final MemberEntityRepository memberEntityRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oauth2User=super.loadUser(userRequest); //소셜정보를 가지고 가서 페이지에 뿌려야 해서 oauth2User는 인증정보를 담고 있음.
		//인증된 상황
		String registrationId=userRequest.getClientRegistration().getRegistrationId();
		
		Map<String, Object> map=oauth2User.getAttributes();
		for(String key: map.keySet()) {
			System.out.println(key+": "+map.get(key));
		}
		
		//DefaultOAuth2User //소셜유저
		return saveSocialUser(registrationId, oauth2User);
	}
	//DefaultOAuth2User //소셜유저
	private OAuth2User saveSocialUser(String registrationId, OAuth2User oauth2User) {
		String email=null;
		String name=null;
		if(registrationId.equals("google")) {
			email=oauth2User.getAttribute("email");
			name=oauth2User.getAttribute("name");
		}else if(registrationId.equals("naver")) {
			Map<String, Object> result=oauth2User.getAttribute("response");
			email=(String)result.get("email");
			name=(String)result.get("name");
		}
		//이미 가입되어있는지 가입여부체크
		Optional<MyUserDetails> socialCheck=memberEntityRepository.findById(email)
				.map(MyUserDetails::new);
		if(socialCheck.isPresent()) { //아이디가 존재하면
			return socialCheck.get(); //세이브 할 필요도 없고 이미 존재하는 정보를 받아오면 됨.
		}
		//가입정보 없을시 소셜정보 회원가입처리
		MemberEntity entity=MemberEntity.builder()
				.email(email).name(name).isSocial(true)
				.password(passwordEncoder.encode("socialUser"+System.currentTimeMillis()))
				.build();
		entity.addRole(MemberRole.USER);
		//MyUserDetails //일반유저
		MemberEntity result=memberEntityRepository.save(entity);
		MyUserDetails myUserDetails=new MyUserDetails(result);
		
		return myUserDetails; //정보를 이걸로 리턴해주고 있음.
	} 

	//securityConfig에서 인증후 이리로 넘어오게 됨.

}
