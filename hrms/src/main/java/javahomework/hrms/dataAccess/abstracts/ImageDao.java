package javahomework.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javahomework.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {
	Image getByJobSeeker_userId(int jobSeekerId);
}
