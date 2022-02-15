package vit.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoticeSaveDto {

	private long nno;
	private String section;
	private String subject;
	private String content;
	
	private String name;
	private LocalDateTime createdDate;
}
