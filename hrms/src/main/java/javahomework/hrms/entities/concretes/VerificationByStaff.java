package javahomework.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "verification_by_staff")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VerificationByStaff {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "staff_id")
	private int staffId;

	@Column(name = "confirm_date", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate confirmDate = LocalDate.now();
}
