package javahomework.hrms.business.abstracts;

import java.util.List;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.Education;

public interface EducationService {

	Result add(Education education);

	DataResult<List<Education>> getAll();

	DataResult<List<Education>> getByJobSeekerOrderByGraduationDateDesc(int jobSeekerId);
}
