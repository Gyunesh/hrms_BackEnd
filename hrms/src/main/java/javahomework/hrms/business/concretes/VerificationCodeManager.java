package javahomework.hrms.business.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.VerificationCodeService;
import javahomework.hrms.core.utilities.results.Result;

import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.dataAccess.abstracts.VerificationCodeDao;
import javahomework.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;

	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(int userId) {
		VerificationCode verifyCode = new VerificationCode();
		verifyCode.setCode(this.generateCode());

		this.verificationCodeDao.save(verifyCode);
		return new SuccessResult();
	}

	@Override
	public String generateCode() {
		UUID code = UUID.randomUUID();
		return code.toString();
	}

}
