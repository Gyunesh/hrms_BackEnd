package javahomework.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javahomework.hrms.entities.concretes.JobAdvert;
import javahomework.hrms.entities.dto.AdvertDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	@Query("From JobAdvert where isOpen = true")
	List<JobAdvert> getAllOpenJobAdvertList();

	@Query("From JobAdvert where isOpen = true Order By publishedAt Desc")
	List<JobAdvert> findAllByOrderByPublishedAtDesc();

	@Query("From JobAdvert where isOpen = true and employer_id =:id")
	List<JobAdvert> getAllOpenJobAdvertByEmployer(int id);

	JobAdvert getById(int id);

	@Query("From JobAdvert where isActive=true ")
	List<JobAdvert> getByIsActive();

	@Query("Select new  javahomework.hrms.entities.dto(j.id, e.companyName,j.name,j.openPositionCount,j.publishedAt,j.appDeadline,j.isActive) From Employer e Inner Join e.jobAdvert j ")
	List<AdvertDto> getByAdvertDetail();

	@Query("Select new  javahomework.hrms.entities.dto(j.id, e.companyName,j.name,j.openPositionCount,j.publishedAt,j.appDeadline,j.isActive) From Employer e Inner Join e.jobAdvert j Where j.isActive=true ")
	List<AdvertDto> getAdvertDetailByActive();
}
