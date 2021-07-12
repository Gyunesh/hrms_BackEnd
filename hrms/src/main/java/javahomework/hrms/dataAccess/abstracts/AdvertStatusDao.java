package javahomework.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javahomework.hrms.entities.concretes.AdvertStatus;

public interface AdvertStatusDao extends JpaRepository<AdvertStatus, Integer> {

}
