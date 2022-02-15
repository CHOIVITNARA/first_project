package vit.domain.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class TravelSaveDto {
	
	private long tno;
	private String travelCode;
	private String travelName;
	private String subName;
	private long adultPrice;
	private long childPrice;
	private long indfantPrice;
	private long sYear;
	private long sMonth;
	private long sDay;
	private long eYear;
	private long eMonth;
	private long eDay;
	private String travelDate;
	private String tag;
	
	private String airplaneName;
	private String airplaneNumber;
	
	private long availableNumber; 
	private long leastavailableNumber;
	private long hotelGrade;
	
	private boolean airplane;
	private boolean noairplane;
	private boolean onlyUsTour;
	private boolean groupTour;
	private boolean noshopping;
	private boolean global;
	
	private long tfno;
	private String filePath;
	private String fileOrgName;
	private String fileNewName;
}