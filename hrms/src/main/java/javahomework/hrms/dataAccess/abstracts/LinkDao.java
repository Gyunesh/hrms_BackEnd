package javahomework.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javahomework.hrms.entities.concretes.Link;

public interface LinkDao extends JpaRepository<Link, Integer> {
	List<Link> getByJobSeeker_userId(int jobSeekerId);
}
