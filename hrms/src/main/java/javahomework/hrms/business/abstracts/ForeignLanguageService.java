package javahomework.hrms.business.abstracts;

import java.util.List;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	Result add(ForeignLanguage foreignLanguage);

	DataResult<List<ForeignLanguage>> getAll();

	DataResult<List<ForeignLanguage>> getByJobSeeker(int jobSeekerId);
}
