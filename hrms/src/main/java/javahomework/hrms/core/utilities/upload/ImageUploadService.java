package javahomework.hrms.core.utilities.upload;

import java.util.Map;


import org.springframework.web.multipart.MultipartFile;

import javahomework.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {

	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
