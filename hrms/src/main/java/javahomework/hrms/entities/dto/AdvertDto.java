package javahomework.hrms.entities.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertDto {
	
	private int id;
	private String companyName;
	private String name;
	private int  openPositionCount;
	private LocalDate publishedAt;
	private LocalDate deadline;
	private boolean isOpen;
}
