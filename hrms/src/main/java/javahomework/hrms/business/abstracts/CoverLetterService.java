package javahomework.hrms.business.abstracts;

import java.util.List;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	Result add(CoverLetter letter);

	DataResult<List<CoverLetter>> getByJobSeeker(int jobSeekerId);

	DataResult<List<CoverLetter>> getAll();
}
