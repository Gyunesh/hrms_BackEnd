package javahomework.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import javahomework.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {

}
