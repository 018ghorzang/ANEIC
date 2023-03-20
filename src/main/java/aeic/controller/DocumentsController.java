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
import aeic.repository.PhotosRepository;
import aeic.services.DocumentsServices;
import aeic.services.PhotosServices;



@Controller
public class DocumentsController {
	
//	public static String directory = System.getProperty("user.dir")+" uploadFiles";
	
    @Autowired 
    DocumentsServices documentsServices;
    
    @Autowired
    PhotosRepository photosRepository;
    
    @Autowired 
	PhotosServices phtoPhotosServices;
	
	
	 @GetMapping("/document")
	 public String getDocuments(Model model) {
		 List<DocumentModel> getDocuments = documentsServices.getAll();
		 
		  
		 model.addAttribute("documents",getDocuments);
		 return "documents";
	 }
	 
	 
	 	
	 
	 // Use for Downloading Purpose //
	 @GetMapping("/file/")
		public void downloadFile(@ModelAttribute(name = "document")
	    DocumentModel document,

	           HttpServletResponse response) throws Exception {
			
			 String   uploadDir = "./File-package/document/" + document.getId() +"/" + document.getName();
			 
			 Path uploadPath = Paths.get(uploadDir);
			 Path filePath = uploadPath;
			 
			 String getPath =  filePath.toFile().getAbsolutePath();
			
			if(document.getName().indexOf(".pdf")>-1) response.setContentType("application/pdf");
			if(document.getName().indexOf(".docx")>-1) response.setContentType("application/msword");
			if(document.getName().indexOf(".xls")>-1) response.setContentType("application/vnd.ms-excel");
			if(document.getName().indexOf(".csv")>-1) response.setContentType("application/vnd.ms-excel");
			if(document.getName().indexOf(".ppt")>-1) response.setContentType("application/ppt");
			if(document.getName().indexOf(".jpg")>-1) response.setContentType("image/jpeg");
			if(document.getName().indexOf(".gif")>-1) response.setContentType("image/gif");
			if(document.getName().indexOf(".zip")>-1) response.setContentType("application/zip");
			
			response.setHeader("Content-Disposition","attachment; name=" + document.getName());
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












// STOR DIRECT INTO DATABASE //


/*
@PostMapping("/upload")
public String uploadFile(@RequestParam("document") 
MultipartFile multipartFile , RedirectAttributes re) throws IOException {
	 
	 String fileName = org.springframework.util.StringUtils.cleanPath(
			 multipartFile.getOriginalFilename());
	 
	 DocumentModel document = new DocumentModel();
	 
	 document.setName(fileName);
	 document.setContent(multipartFile.getBytes());
	 document.setSize(multipartFile.getSize());
	 document.setUploadTime(new Date());
	 documentsRepository.save(document);
	 
	 re.addFlashAttribute("message","File has been Upload successfully!");
	 
	 return "redirect:/documents";
}




	 @RequestMapping("/upload")
	 public String uploadFile(Model model,@RequestParam("files") MultipartFile [] files) {
		 StringBuilder fileName = new StringBuilder();
		 
		 for(MultipartFile file: files) {
			 Path fileNameAndPath = Paths.get(directory, file.getOriginalFilename());
			 fileName.append(fileNameAndPath);
			 try {
				 Files.write(fileNameAndPath,file.getBytes());
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
		 }
		 model.addAttribute("msg","Successfully upload files:");
		 System.out.println("Successfully uploaded!:"+fileName);
		 return "redirect:/documents";
	 }



	    @PostMapping("/users/save")
	    public String  saveUser(PhotosModel photo,
	            @RequestParam("image") MultipartFile multipartFile,
	            Model model) throws IOException {
	         
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        
	        photo.setPhotos(fileName);
	         
	        PhotosModel savedPhots = photosRepository.save(photo);
	 
	        String uploadDir = "user-photos/" + savedPhots.getId();
	 
	        FileUploadUtil.saveFile("images", fileName, multipartFile);
	        
	        model.addAttribute("photo","This is for demo purpose"); 
	        
	        return "redirect:/documents";
	    }

*/
