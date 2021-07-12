package javahomework.hrms.entities.dto;

import java.util.List;

import javahomework.hrms.entities.concretes.CoverLetter;
import javahomework.hrms.entities.concretes.Education;
import javahomework.hrms.entities.concretes.Experience;
import javahomework.hrms.entities.concretes.ForeignLanguage;
import javahomework.hrms.entities.concretes.Image;
import javahomework.hrms.entities.concretes.JobSeeker;
import javahomework.hrms.entities.concretes.Link;
import javahomework.hrms.entities.concretes.ProgrammingSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	private JobSeeker jobSeeker;
	private Image image;
	private List<CoverLetter> coverLetters;
	private List<Education> educations;
	private List<Experience> experiences;
	private List<ProgrammingSkill> programmingSkills;
	private List<ForeignLanguage> foreignLanguages;
	private List<Link> links;
}
