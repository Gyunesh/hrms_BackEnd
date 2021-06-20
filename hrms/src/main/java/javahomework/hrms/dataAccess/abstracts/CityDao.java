package javahomework.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javahomework.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
	City getById(int id);
}
