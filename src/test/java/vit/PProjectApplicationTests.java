package vit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import vit.domain.dto.MemberSaveDto;
import vit.domain.entity.MemberEntity;
import vit.domain.entity.MemberEntityRepository;

@SpringBootTest
class PProjectApplicationTests {

	PasswordEncoder passwordEncoder;
	MemberEntityRepository memberEntityRepository;
	
	@Test
	void 멤버넣기(MemberSaveDto dto) {
		MemberEntity entity=MemberEntity.builder()
				.email("admin@naver.com")
				.password(passwordEncoder.encode("1234"))
				.birth("12345678")
				.gender("w")
				
				.build();
	}

}
