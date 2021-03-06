package javahomework.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javahomework.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvert"})
public class Employer extends User {

	@Column(name = "company_name")
	@NotBlank
	@NotNull
	private String companyName;

	@Column(name = "website")
	@NotBlank
	@NotNull
	private String webSite;

	@Column(name = "phone")
	@NotBlank
	@NotNull
	private String phone;

	@Column(name = "is_activated")
	private boolean isActivated;
	
	 @OneToMany(mappedBy="employer")
	 private List<JobAdvert> jobAdvert;

}
