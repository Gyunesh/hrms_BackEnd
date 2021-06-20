package javahomework.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javahomework.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer> {
	Job findByName(String name);
}
