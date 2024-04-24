package deliverySpringProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import deliverySpringProject.command.FileCommand;
import deliverySpringProject.domain.FileDTO;
import jakarta.servlet.http.HttpSession;

@Service
public class FileDelService {
	public String execute(FileCommand fileCommand, HttpSession session) {
		String num = "";
		
		Boolean newFile = true;
		List<FileCommand> list = (List<FileCommand>)session.getAttribute("fileList");
		if(list == null) {
			list = new ArrayList<FileCommand>();
		}
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getStoreFile().equals(fileCommand.getStoreFile())) {
				list.remove(i);
				newFile = false;
				num = "0";
				break;
			}
		}
		if(newFile) {
			list.add(fileCommand);
			num = "1";
		}
		session.setAttribute("fileList", list);
		return num;
	}
}
