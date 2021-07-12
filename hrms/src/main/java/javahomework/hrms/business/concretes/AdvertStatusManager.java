package javahomework.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.AdvertStatusService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.dataAccess.abstracts.AdvertStatusDao;
import javahomework.hrms.entities.concretes.AdvertStatus;

@Service
public class AdvertStatusManager implements AdvertStatusService{
	
	private AdvertStatusDao advertStatusDao;
	
	@Autowired
	public AdvertStatusManager(AdvertStatusDao advertStatusDao) {
		super();
		this.advertStatusDao=advertStatusDao;
	}

	@Override
	public Result add(AdvertStatus status) {
		this.advertStatusDao.save(status);
		return new SuccessResult("Status added.");
	}

	@Override
	public DataResult<List<AdvertStatus>> getAll() {
		return new SuccessDataResult<List<AdvertStatus>>(this.advertStatusDao.findAll());
	}
	
	

}
