package az.maqa.hateoas.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Util {

	@Value("${image.folder.path}")
	private String FOLDER_PATH;

	public void saveImage(MultipartFile file) {
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(FOLDER_PATH + file.getOriginalFilename());
			Files.write((java.nio.file.Path) path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
