package javahomework.hrms.business.abstracts;

import javahomework.hrms.core.utilities.results.Result;

public interface VerificationCodeService {
	Result add(int userId);

	String generateCode();
}
