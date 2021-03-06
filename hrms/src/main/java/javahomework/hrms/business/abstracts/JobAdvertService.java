package javahomework.hrms.business.abstracts;

import java.util.List;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.JobAdvert;
import javahomework.hrms.entities.dto.JobAdvertDto;

public interface JobAdvertService {

	Result add(JobAdvert jobAdvert);

	Result update(JobAdvert jobAdvert);

	Result delete(int id);

	Result changeOpenToClose(int id);

	DataResult<JobAdvert> getById(int id);

	DataResult<List<JobAdvert>> getAll();

	DataResult<List<JobAdvertDto>> getAllDetail();

	DataResult<List<JobAdvert>> getByIsActive();

	DataResult<List<JobAdvert>> getAllSortedByDate();

	DataResult<List<JobAdvert>> getAllOpenJobAdvertList();

	DataResult<List<JobAdvert>> findAllByOrderByPublishedAt();

	DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);
	
	DataResult<List<JobAdvert>> getAllByEmployerId(int employerId);

}
