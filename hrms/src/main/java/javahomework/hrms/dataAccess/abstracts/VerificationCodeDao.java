package javahomework.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import javahomework.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {

}
