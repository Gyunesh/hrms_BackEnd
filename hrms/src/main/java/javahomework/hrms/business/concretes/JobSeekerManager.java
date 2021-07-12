package javahomework.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.CoverLetterService;
import javahomework.hrms.business.abstracts.EducationService;
import javahomework.hrms.business.abstracts.ExperienceService;
import javahomework.hrms.business.abstracts.ForeignLanguageService;
import javahomework.hrms.business.abstracts.ImageService;
import javahomework.hrms.business.abstracts.JobSeekerService;
import javahomework.hrms.business.abstracts.LinkService;
import javahomework.hrms.business.abstracts.ProgrammingSkillService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.dataAccess.abstracts.JobSeekerDao;
import javahomework.hrms.entities.concretes.JobSeeker;
import javahomework.hrms.entities.dto.CvDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private ProgrammingSkillService programmingSkillService;
	private CoverLetterService coverLetterService;
	private EducationService educationService;
	private ExperienceService experienceService;
	private ImageService imageService;
	private ForeignLanguageService foreignLanguageService;
	private LinkService linkService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, ProgrammingSkillService programmingSkillService,
			CoverLetterService coverLetterService, EducationService educationService,
			ExperienceService experienceService, ImageService imageService,
			ForeignLanguageService foreignLanguageService, LinkService linkService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.programmingSkillService = programmingSkillService;
		this.coverLetterService = coverLetterService;
		this.educationService = educationService;
		this.experienceService = experienceService;
		this.foreignLanguageService = foreignLanguageService;
		this.imageService = imageService;
		this.linkService = linkService;

	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Job Seekers are listed.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Job Seeker added.");
	}

	@Override
	public DataResult<JobSeeker> get(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(id).get());
	}

	@Override
	public DataResult<CvDto> getCv(int jobSeekerId) {
		CvDto cv = new CvDto();
		cv.setCoverLetters(this.coverLetterService.getByJobSeeker(jobSeekerId).getData());
		cv.setEducations(this.educationService.getByJobSeekerOrderByGraduationDateDesc(jobSeekerId).getData());
		cv.setExperiences(this.experienceService.getByJobSeekerOrderByLeaveDateDesc(jobSeekerId).getData());
		cv.setForeignLanguages(this.foreignLanguageService.getByJobSeeker(jobSeekerId).getData());
		cv.setImage(this.imageService.getByJobSeeker(jobSeekerId).getData());
		cv.setJobSeeker(this.get(jobSeekerId).getData());
		cv.setLinks(this.linkService.getByJobSeeker(jobSeekerId).getData());
		cv.setProgrammingSkills(this.programmingSkillService.getByJobSeekerId(jobSeekerId).getData());

		return new SuccessDataResult<CvDto>(cv);
	}

}
