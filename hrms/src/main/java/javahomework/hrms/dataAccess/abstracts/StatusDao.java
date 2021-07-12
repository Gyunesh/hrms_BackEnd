package javahomework.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javahomework.hrms.entities.concretes.Status;

public interface StatusDao extends JpaRepository<Status, Integer> {

}
