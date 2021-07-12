package javahomework.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.AdvertStatusService;
import javahomework.hrms.business.abstracts.StaffService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.dataAccess.abstracts.StaffDao;
import javahomework.hrms.entities.concretes.AdvertStatus;
import javahomework.hrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService {

	private StaffDao staffDao;
	private AdvertStatusService advertStatusService;

	@Autowired
	public StaffManager(StaffDao staffDao, AdvertStatusService advertStatusService) {
		super();
		this.staffDao = staffDao;
		this.advertStatusService = advertStatusService;
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll());
	}

	@Override
	public Result confirm(AdvertStatus status) {
		this.advertStatusService.add(status);
		return new SuccessResult("Posting confirmed.");
	}

}
