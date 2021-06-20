package javahomework.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javahomework.hrms.business.abstracts.ImageService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.core.utilities.upload.ImageUploadService;
import javahomework.hrms.dataAccess.abstracts.ImageDao;
import javahomework.hrms.entities.concretes.Image;
import javahomework.hrms.entities.concretes.JobSeeker;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
		super();
		this.imageDao = imageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public Result upload(int id, MultipartFile file) {
		@SuppressWarnings("unchecked")
		Map<String, String> way = (Map<String, String>) this.imageUploadService.uploadImageFile(file).getData();
		JobSeeker seeker = new JobSeeker();
		Image image = new Image();
		seeker.setUserId(id);
		image.setJobSeeker(seeker);

		image.setUrl(way.get("url"));
		image.setUpdateDate(LocalDate.now());

		this.imageDao.save(image);
		return new SuccessResult();

	}

	@Override
	public DataResult<Image> getByJobSeeker(int jobSeekerId) {
		return new SuccessDataResult<Image>(this.imageDao.getByJobSeeker_userId(jobSeekerId));
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}

}
