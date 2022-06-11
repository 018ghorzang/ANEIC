package aeic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import aeic.model.DocumentModel;
import aeic.model.NewsModel;
import aeic.model.VideoModel;
import aeic.services.DocumentsServices;
import aeic.services.NewsServices;
import aeic.services.VideoServices;


@Controller
public class DocumentCms {
	
	@Autowired
	DocumentsServices documentsServices; 
	
	@Autowired
	NewsServices newsServices;
	
	@Autowired
	VideoServices videoServices;
	
	@GetMapping("/doc")
	public String getDocumentCms() {	
		return "doc";
				
	}
	 
	
	/* UPLOADING DOCUMENTS */
	
	@PostMapping("/document/save")
	public String saveDocument(@ModelAttribute(name = "document")
	        DocumentModel document,
			RedirectAttributes ra,
			@RequestParam("document") MultipartFile multipartFile) throws IOException {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		int fileSize = (int) multipartFile.getSize();
		
		document.setName(fileName);
		document.setUploadTime(new Date());
		document.setSize(fileSize);
		
	     documentsServices.saveDocument(document);
	     
	    String   uploadDir = "./File-package/document/" + document.getId();
	    
	    Path uploadPath = Paths.get(uploadDir);
	    
	    if(!Files.exists(uploadPath)) {
	    	Files.createDirectories(uploadPath);
	    }
	    
	    
	    try(InputStream inputStream = multipartFile.getInputStream()){
	    	
	    	Path filePath = uploadPath.resolve(fileName);
	    	System.out.println(filePath.toFile().getAbsolutePath());
	    	Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
	    	
	    }catch (IOException e) {
	    	throw new IOException("Could not save uploaded file: " + fileName);
	    }
	    
	    ra.addFlashAttribute("message","The file has been saved successfully!");
		
		return "redirect:/doc";
	}
	
	
	/* UPLOADING IMAGES  & NEWS */
	
	@PostMapping("/news/save")
	public String saveImage(@ModelAttribute(name = "news")
	        NewsModel news,
			RedirectAttributes ra,
			@RequestParam("news") MultipartFile multipartFile) throws IOException {
		
		String imageName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		news.setImageUrl(imageName);
		news.setUploadTime(new Date());
		
		
	     newsServices.saveNews(news);
	     
	    String   uploadDir = "./File-package/image/" + news.getId();
	    
	    Path uploadPath = Paths.get(uploadDir);
	    
	    if(!Files.exists(uploadPath)) {
	    	Files.createDirectories(uploadPath);
	    }
	    
	    
	    try(InputStream inputStream = multipartFile.getInputStream()){
	    	
	    	Path filePath = uploadPath.resolve(imageName);
	    	System.out.println(filePath.toFile().getAbsolutePath());
	    	Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
	    	
	    }catch (IOException e) {
	    	throw new IOException("Could not save uploaded file: " + imageName);
	    }
	    
	    ra.addFlashAttribute("message","The image has been saved successfully!");
		System.out.println("this is the image url: " + news.getUrlPath());
		return "redirect:/doc";
	}
	
	
      /* UPLOADING VIDEOS */
	
	@PostMapping("/video/save")
	public String saveVideos(@ModelAttribute(name = "video")
	        VideoModel video,
			RedirectAttributes ra,
			@RequestParam("video") MultipartFile multipartFile) throws IOException {
		
		String videoName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		video.setVideoUrl(videoName);
		video.setUploadTime(new Date());
		
		
	     videoServices.saveVideo(video);
	     
	    String   uploadDir = "./File-package/video/" + video.getId();
	    
	    Path uploadPath = Paths.get(uploadDir);
	    
	    if(!Files.exists(uploadPath)) {
	    	Files.createDirectories(uploadPath);
	    }
	    
	    
	    try(InputStream inputStream = multipartFile.getInputStream()){
	    	
	    	Path filePath = uploadPath.resolve(videoName);
	    	System.out.println(filePath.toFile().getAbsolutePath());
	    	Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
	    	
	    }catch (IOException e) {
	    	throw new IOException("Could not save uploaded file: " + videoName);
	    }
	    
	    ra.addFlashAttribute("message","The video has been saved successfully!");
		System.out.println("this is the image url: " + video.getUrlPath());
		return "redirect:/doc";
	}
	
}




