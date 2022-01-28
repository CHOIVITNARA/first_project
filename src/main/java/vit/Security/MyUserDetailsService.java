package vit.Security;

import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vit.domain.entity.MemberEntity;
import vit.domain.entity.MemberEntityRepository;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService{

	final MemberEntityRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<MemberEntity> result=repository.findById(username);
		
		//회원이 존재하는지
		if(result.isEmpty()) {
			throw new UsernameNotFoundException("회원이 존재하지 않습니다.");
		}
		//아이디가 있다
		MemberEntity entity=result.get();
		return new MyUserDetails(entity);
	}
}
