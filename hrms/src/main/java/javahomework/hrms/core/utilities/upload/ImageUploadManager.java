package javahomework.hrms.core.utilities.upload;

import java.io.IOException;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.ErrorDataResult;
import javahomework.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploadManager implements ImageUploadService {

	private Cloudinary cloudinary;

	public ImageUploadManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dfanj1ub5", "api_key", "271794592959794",
				"api_secret", "21wmFGpjv-plkpK5-D0ctAbwxVo"));
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(),
					ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return new ErrorDataResult<Map>();
	}
}
