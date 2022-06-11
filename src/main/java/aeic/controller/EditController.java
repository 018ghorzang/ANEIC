package aeic.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aeic.model.DocumentModel;
import aeic.model.MessageTable;
import aeic.model.NewsModel;
import aeic.model.User;
import aeic.model.VideoModel;
import aeic.services.DocumentsServices;
import aeic.services.MessageServices;
import aeic.services.NewsServices;
import aeic.services.UserServices;
import aeic.services.VideoServices;

@Controller
public class EditController {

	
	@Autowired
	DocumentsServices documentsServices;
	
	@Autowired
	NewsServices newsServices;
	
	@Autowired
	VideoServices videoServices;
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	MessageServices messageServices;
	
	@GetMapping("/edit")
	public String getEdit(Model model) {
		
	 List<DocumentModel> getDocuments = documentsServices.getAll();
	 List<NewsModel> getNews = newsServices.getAll();
	 List<VideoModel> getVideos = videoServices.getAll();
	 List<User>       getUsers = userServices.getUser();
	 List<MessageTable> getMessages = messageServices.getAll();
	 
	 
	 
		 model.addAttribute("documents",getDocuments);
		 model.addAttribute("getNews",getNews);
		 model.addAttribute("videos",getVideos);
		 model.addAttribute("users",getUsers);
		 model.addAttribute("messages",getMessages);
		 return "edit";
	}
	
	
	
	// Find the document by id
	@RequestMapping("document/findById")
	@ResponseBody
	public Optional<DocumentModel>  findById(Long id){
		return documentsServices.findById(id);
}
	
	/* Update document Records*/
	@RequestMapping(value="/update/document", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(DocumentModel document) {
		document.setUploadTime(new Date());
		documentsServices.saveDocument(document);
		return "redirect:/edit";
	}
	
	
	/* Delete document Records*/
	@RequestMapping(value="/delete/document", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Long id) {
		documentsServices.delete(id);
		return "redirect:/edit";
	}
	
	
	// ********************* //
	// THE NEWS PART //
	
	// Find the News by id
	@RequestMapping("news/findById")
	@ResponseBody
	public Optional<NewsModel>  findNewsById(Long id){
		return newsServices.findById(id);
}
	
	/* Update document Records*/
	@RequestMapping(value="/update/news", method = {RequestMethod.PUT,RequestMethod.GET})
	public String updateNews(NewsModel news) {
		news.setUploadTime(new Date());
		newsServices.saveNews(news);
		return "redirect:/edit";
	}
	
	
	/* Delete document Record */
	@RequestMapping(value="/delete/news", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String deleteNews(Long id) {
		newsServices.delete(id);
		return "redirect:/edit";
	}
	
	
	// ********************* //
		// THE Videos PART //
	
	/* Delete video Record */
	
	@RequestMapping(value = "/delete/video", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String deleteVideo(Long id) {
		videoServices.delete(id);
		return "redirect:/edit";
	}
	
	
	
	// ********************* //
			// THE User Messages PART //
		
		/* Delete User Messages Record */
		
		@RequestMapping(value = "/delete/message", method = {RequestMethod.DELETE,RequestMethod.GET})
		public String deleteUserMessages(Integer id) {
			messageServices.messageDeleteById(id);
			return "redirect:/edit";
		}
}
