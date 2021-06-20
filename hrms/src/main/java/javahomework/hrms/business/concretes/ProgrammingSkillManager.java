package javahomework.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.ProgrammingSkillService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.dataAccess.abstracts.ProgrammingSkillDao;
import javahomework.hrms.entities.concretes.ProgrammingSkill;

@Service
public class ProgrammingSkillManager implements ProgrammingSkillService {

	private ProgrammingSkillDao programmingSkillDao;

	@Autowired
	public ProgrammingSkillManager(ProgrammingSkillDao programmingSkillDao) {
		super();
		this.programmingSkillDao = programmingSkillDao;
	}

	@Override
	public Result add(ProgrammingSkill ability) {
		this.programmingSkillDao.save(ability);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<ProgrammingSkill>> getAll() {
		return new SuccessDataResult<List<ProgrammingSkill>>(this.programmingSkillDao.findAll());
	}

	@Override
	public DataResult<List<ProgrammingSkill>> getByJobSeeker(int JobSeekerId) {
		return new SuccessDataResult<List<ProgrammingSkill>>(
				this.programmingSkillDao.getAllByJobSeeker_id(JobSeekerId));
	}

}
