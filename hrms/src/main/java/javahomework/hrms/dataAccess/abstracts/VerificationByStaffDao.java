package javahomework.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import javahomework.hrms.entities.concretes.VerificationByStaff;

public interface VerificationByStaffDao extends JpaRepository<VerificationByStaff, Integer> {

}
