package javahomework.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.Image;

public interface ImageService {
	Result upload(int id, MultipartFile file);

	DataResult<Image> getByJobSeeker(int jobSeekerId);

	DataResult<List<Image>> getAll();
}
