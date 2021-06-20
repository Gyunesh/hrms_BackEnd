package javahomework.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.ForeignLanguageService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.dataAccess.abstracts.ForeignLanguageDao;
import javahomework.hrms.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

	private ForeignLanguageDao foreignLanguageDoa;

	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDoa) {
		super();
		this.foreignLanguageDoa = foreignLanguageDoa;
	}

	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDoa.save(foreignLanguage);
		return new SuccessResult("Language added.");
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDoa.findAll());
	}

	@Override
	public DataResult<List<ForeignLanguage>> getByJobSeeker(int jobSeekerId) {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDoa.getByJobSeeker_userId(jobSeekerId));
	}

}
