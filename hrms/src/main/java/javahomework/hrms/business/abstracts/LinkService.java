package javahomework.hrms.business.abstracts;

import java.util.List;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.Link;

public interface LinkService {
	Result add(Link link);

	DataResult<List<Link>> getAll();

	DataResult<List<Link>> getByJobSeeker(int jobSeekerId);
}
