package javahomework.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.EducationService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.dataAccess.abstracts.EducationDao;
import javahomework.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {
	private EducationDao educationdao;

	@Autowired
	public EducationManager(EducationDao educationdao) {
		super();
		this.educationdao = educationdao;
	}

	@Override
	public Result add(Education education) {
		this.educationdao.save(education);
		return new SuccessResult("education added");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationdao.findAll(), "educations listed");
	}

	@Override
	public DataResult<List<Education>> getByJobSeekerOrderByGraduationDateDesc(int jobSeekerId) {
		return new SuccessDataResult<List<Education>>(
				this.educationdao.getByJobSeeker_userIdOrderByGraduationDateDesc(jobSeekerId));
	}

}
