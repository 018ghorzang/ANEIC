package aeic.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import aeic.model.DocumentModel;
import aeic.model.MapsModel;
import aeic.services.MapsService;

@Controller
public class maps {
	
	@Autowired
	MapsService mapsService;
	
	@GetMapping("/maps")
	public String getServices(Model model) {
		
		List<MapsModel> getMaps = mapsService.getAll();
		
		model.addAttribute("maps",getMaps);
		return "/maps";
	}
	
	

	 // Use for Downloading Purpose //
	 @GetMapping("/maps/")
		public void downloadMaps(@ModelAttribute(name = "maps")
	    MapsModel map, HttpServletResponse response) throws Exception {
			
			 String   uploadDir = "./File-package/maps/" + map.getId() +"/" + map.getMapName();
			 
			 Path uploadPath = Paths.get(uploadDir);
			 Path filePath = uploadPath;
			 
			 String getPath =  filePath.toFile().getAbsolutePath();
			
			if(map.getMapName().indexOf(".pdf")>-1) response.setContentType("application/pdf");
			if(map.getMapName().indexOf(".docx")>-1) response.setContentType("application/msword");
			if(map.getMapName().indexOf(".xls")>-1) response.setContentType("application/vnd.ms-excel");
			if(map.getMapName().indexOf(".csv")>-1) response.setContentType("application/vnd.ms-excel");
			if(map.getMapName().indexOf(".ppt")>-1) response.setContentType("application/ppt");
			if(map.getMapName().indexOf(".jpg")>-1) response.setContentType("image/jpeg");
			if(map.getMapName().indexOf(".gif")>-1) response.setContentType("image/gif");
			if(map.getMapName().indexOf(".zip")>-1) response.setContentType("application/zip");
			
			response.setHeader("Content-Disposition","attachment; name=" + map.getMapName());
			response.setHeader("Content-Transfer-Encoding","binary");
			
			try {
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
				System.out.println("This is the uploading file: "+getPath);
				FileInputStream fis = new FileInputStream(getPath);
				
				int len;
				byte[] buf = new byte[1024];
				while((len = fis.read(buf)) > 0) {
					bos.write(buf,0,len);
				}
				bos.close();
				response.flushBuffer();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	  
	
}
