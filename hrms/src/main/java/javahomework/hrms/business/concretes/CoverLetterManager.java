package javahomework.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.CoverLetterService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.dataAccess.abstracts.CoverLetterDao;
import javahomework.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService {

	private CoverLetterDao coverLetterdao;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterdao) {
		super();
		this.coverLetterdao = coverLetterdao;
	}

	@Override
	public Result add(CoverLetter letter) {
		this.coverLetterdao.save(letter);
		return new SuccessResult("letter added");
	}

	@Override
	public DataResult<List<CoverLetter>> getByJobSeeker(int jobSeekerId) {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterdao.getByJobSeeker_userId(jobSeekerId));
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterdao.findAll(), "letters listed");
	}

}
