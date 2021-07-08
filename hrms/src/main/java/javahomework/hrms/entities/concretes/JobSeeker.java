package javahomework.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javahomework.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = true)
public class JobSeeker extends User {

	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;

	@Column(name = "nationality_id")
	@NotBlank
	@NotNull
	@Size(min = 11, max = 11)
	private String nationalityId;

	@Column(name = "date_of_birth")
	@NotNull
	private Date dateOfBirth;
	
	@OneToOne(mappedBy="jobSeeker", fetch=FetchType.LAZY)
	@JsonIgnore
	private Image image;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<Experience> experience;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<ProgrammingSkill> programmingSkill;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<Education> education;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<ForeignLanguage> language;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<Link> link;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<CoverLetter> coverLetter;

}
