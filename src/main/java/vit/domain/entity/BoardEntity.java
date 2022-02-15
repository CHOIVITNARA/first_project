package vit.domain.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BoardEntity extends BaseEntity{
	
	@Id
	private long bno;
	@Column(nullable=false)
	private String section;
	@Column(nullable=false)
	private String subject;
	@Column(nullable=false)
	private String content;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="name")
	private MemberEntity memberEntity;
}
