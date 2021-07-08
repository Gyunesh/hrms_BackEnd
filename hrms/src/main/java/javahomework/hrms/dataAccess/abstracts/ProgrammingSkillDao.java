package javahomework.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javahomework.hrms.entities.concretes.ProgrammingSkill;

public interface ProgrammingSkillDao extends JpaRepository<ProgrammingSkill, Integer> {
	List<ProgrammingSkill> getAllByJobSeeker(int id);
}
