package javahomework.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javahomework.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
	List<Education> getByJobSeeker_userIdOrderByGraduationDateDesc(int jobSeekerId);
}
