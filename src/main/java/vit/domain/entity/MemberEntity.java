package vit.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MemberEntity extends BaseEntity{
	
	@Id
	private String email;
	
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String name;
	@Column(nullable=true)
	private String gender;
	@Column(nullable=true)
	private String phoneNumber;
	@Column(nullable=true)
	private String birth;
	
	@Column(nullable=true)
	private boolean hanaAgree;
	@Column(nullable=true)
	private boolean personalAgree;
	@Column(nullable=true)
	private boolean personalOtherAgree;
	@Column(nullable=true)
	private boolean locationAgree;
	@Column(nullable=true)
	private boolean marcketingAgree;
	@Column(nullable=true)
	private boolean marcketingOtherAgree;
	
	private boolean isSocial;
	
	
	
	@Enumerated(EnumType.STRING)
	@Builder.Default
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<MemberRole> RoleSet=new HashSet<>();
	
	public void addRole(MemberRole role) {
		RoleSet.add(role);
	}

}
