package vit.domain.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vit.domain.dto.NoticeSaveDto;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class NoticeEntity extends BaseEntity{
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long nno;
	@Column(nullable=false)
	private String section;
	@Column(nullable=false)
	private String subject;
	@Column(nullable=false)
	private String content;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "name")
	private MemberEntity memberEntity;
	
	public NoticeEntity updateDetail(NoticeSaveDto dto) {
		this.section=dto.getSection();
		this.subject=dto.getSubject();
		this.content=dto.getContent();
		return this;
	}
}
