package javahomework.hrms.business.abstracts;

import java.util.List;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.Status;

public interface StatusService {
	Result add(Status status);
	
	DataResult<List<Status>> getAll();

}
