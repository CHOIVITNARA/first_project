package vit.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TravelEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tno;
	@Column
	private String travelCode;
	@Column
	private String travelName;
	@Column
	private String subName;
	@Column
	private long adultPrice;
	@Column
	private long childPrice;
	@Column
	private long infantPrice;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private String travelDate;
	@Column
	private String tag;
	
	@Column
	private String airplaneName;
	@Column
	private String airplaneNumber;
	
	@Column
	private long availableNumber; 
	@Column
	private long leastavailableNumber;
	@Column
	private long hotelGrade;
	
	@Column
	private boolean airplane;
	@Column
	private boolean noairplane;
	@Column
	private boolean onlyUsTour;
	@Column
	private boolean groupTour;
	@Column
	private boolean noshopping;
	@Column
	private boolean global;
	
}
