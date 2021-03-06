package javahomework.hrms.business.abstracts;

import java.util.List;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.AdvertStatus;
import javahomework.hrms.entities.concretes.Staff;

public interface StaffService {
	DataResult<List<Staff>> getAll();
	Result confirm(AdvertStatus status);
}
