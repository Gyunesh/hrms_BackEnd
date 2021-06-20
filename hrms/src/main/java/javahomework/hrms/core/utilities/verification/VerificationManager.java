package javahomework.hrms.core.utilities.verification;

public class VerificationManager implements VerificationService {

	@Override
	public void verifyByCode(String code, String email) {
		System.out.println(code + "Code send your email :" + email);

	}

	@Override
	public void verifyByStaff(int id) {
		System.out.println("Verify by staff :" + id);

	}

}
