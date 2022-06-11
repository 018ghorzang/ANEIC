package aeic.security.oauth2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import aeic.controller.Authentication_Provider;
import aeic.model.User;
import aeic.services.UserServices;


@Component
public class OAuth2LoginSuccessHandler  extends SimpleUrlAuthenticationSuccessHandler{
	
	 
	
	@Autowired
   private UserServices userServices;
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		CustomOAuth2User customOAuth2user = (CustomOAuth2User) authentication.getPrincipal();
		
		String email = customOAuth2user.getEmail();
		String name  = customOAuth2user.getName();

		  User user  = userServices.getUserByEmail(email);
		  
		  if(user == null) {
			  // Register as a new User
			  
			  userServices.createNewUserAfterOAuthLoginSuccess(email,name,
					 Authentication_Provider.GOOGLE );
			  System.out.println( "This is Empty user : ");
			 
		  } else {
			  // Update existing User
			  
			  userServices.updateUserAfterOAuthLoginSuccess(user,name,
					  Authentication_Provider.GOOGLE);
			  System.out.println( "This is not Empty user : ");
			  System.out.println(customOAuth2user.getAuthorities());
		  }
		
		System.out.println( "Customer's email: "+ email);
		System.out.println( "Customer's name: "+ name);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	
	

}
