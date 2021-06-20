package javahomework.hrms.core.utilities.verification;

public interface VerificationService {
	void verifyByCode(String code, String email);

	void verifyByStaff(int id);
}
