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
public class MemberlEntity extends BaseEntity{
	
	@Id
	String email;
	
	@Column(nullable=false)
	String password;
	@Column(nullable=false)
	String name;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<MemberRole> RoleSet=new HashSet<>();
	
	public void addRole(MemberRole role) {
		RoleSet.add(role);
	}

}
