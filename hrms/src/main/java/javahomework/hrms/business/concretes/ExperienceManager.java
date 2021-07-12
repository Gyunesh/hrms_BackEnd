package javahomework.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.ExperienceService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.dataAccess.abstracts.ExperienceDao;
import javahomework.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {
	private ExperienceDao experiencedao;

	@Autowired
	public ExperienceManager(ExperienceDao experiencedao) {
		super();
		this.experiencedao = experiencedao;
	}

	@Override
	public Result add(Experience exp) {
		this.experiencedao.save(exp);
		return new SuccessResult("exp added!");
	}

	@Override
	public DataResult<List<Experience>> getByJobSeekerOrderByLeaveDateDesc(int jobSeekerId) {
		return new SuccessDataResult<List<Experience>>(
				this.experiencedao.getByJobSeeker_userIdOrderByLeaveDateDesc(jobSeekerId));
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experiencedao.findAll(), "exps listed");
	}

	@Override
	public DataResult<List<Experience>> getByJobSeekerId(int JobSeekerId) {
		
		return new SuccessDataResult<List<Experience>>(this.experiencedao.getByJobSeeker_userId(JobSeekerId));
	}

}
