package javahomework.hrms.business.abstracts;

import java.util.List;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.AdvertStatus;

public interface AdvertStatusService {
	
	Result add(AdvertStatus status);
	
	DataResult<List<AdvertStatus>> getAll();

}
