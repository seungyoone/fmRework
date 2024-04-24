package deliverySpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import deliverySpringProject.command.FileCommand;
import deliverySpringProject.service.FileDelService;
import jakarta.servlet.http.HttpSession;

@RestController
public class CheckRestController {
	@Autowired
	FileDelService fileDelService;
	
	@PostMapping("owner/fileDel")
	public String fileDel(FileCommand fileCommand, HttpSession session) {
		return fileDelService.execute(fileCommand,session);
	}
}
