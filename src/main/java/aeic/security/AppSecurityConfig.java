package aeic.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import aeic.security.oauth2.CustomOAuth2UserService;
import aeic.security.oauth2.OAuth2LoginSuccessHandler;
import aeic.services.MyUserDetailsService;




@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private OAuth2LoginSuccessHandler auth2LoginSuccessHandler;
	
	@Autowired
	private  CustomOAuth2UserService customOAuth2UserService;
	
	 
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new MyUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests().antMatchers("/","/about","/coal","/doc","/videos",
				 "/biomass","/electricitygeneration","/importelectricity",
				 "/energyconsumption","/photo","/gas","/news","/organistion_chart",
				 "/petroluem","/solar","/wind","/maps","/license").permitAll()
		 
		.antMatchers("/assets/**","/File-package/**","/more/**").permitAll()
		.antMatchers("/delete/**","/doc","/user_message").hasAuthority("ADMIN")
		.antMatchers("/edit/**").hasAnyAuthority("ADMIN","EDITOR")
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.oauth2Login().successHandler(auth2LoginSuccessHandler)
		.and()
		.logout().permitAll();
	}
	

}











































/*
 * 
 * 
 * 
 * 
 * 
 * 
 * @Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		
			httpSecurity.antMatcher("/**").authorizeRequests()
			.antMatchers("/oauth2/**").permitAll()
		.antMatchers("/","index","/about","/team","/data","/videos","/photo",
				    "/data_chart","/File-package/**","/assets/**").permitAll()
		
		.anyRequest().authenticated()
		.and().oauth2Login()
		.userInfoEndpoint().userService(customOAuth2UserService)
		.and()
		.successHandler(auth2LoginSuccessHandler)
		.and()
		.logout().permitAll();
    	
	}
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */










// MYSQL DB AUTHENTICATION //

//
//@Bean
//public AuthenticationProvider authProvider() {
//	
//	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	
//	provider.setUserDetailsService(userDetailsService);
//	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//	return provider;
//}
//
//

	










/* test Purpose */
/*
@Override
@Bean
protected UserDetailsService userDetailsService() {
	
	List<UserDetails> users = new ArrayList<>();
	
	UserDetails u1 = User.withDefaultPasswordEncoder().username("ghorzang").password("12345").roles("USER").build();
	UserDetails u2 = User.withDefaultPasswordEncoder().username("milad").password("12345").roles("USER").build();
	UserDetails u3 = User.withDefaultPasswordEncoder().username("waziri").password("12345").roles("USER").build();
	
	
	users.add(u1);
	users.add(u2);
	users.add(u3);
	return new InMemoryUserDetailsManager(users);	
}
*/
