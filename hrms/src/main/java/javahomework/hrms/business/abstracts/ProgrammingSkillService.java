package javahomework.hrms.business.abstracts;

import java.util.List;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.ProgrammingSkill;

public interface ProgrammingSkillService {
	Result add(ProgrammingSkill ability);

	DataResult<List<ProgrammingSkill>> getAll();

	DataResult<List<ProgrammingSkill>> getByJobSeekerId(int JobSeekerId);
}
