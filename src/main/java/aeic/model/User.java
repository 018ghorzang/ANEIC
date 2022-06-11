package aeic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.authentication.AuthenticationProvider;

import aeic.controller.Authentication_Provider;

  @Entity
  public class User {
		
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String username;
	private String password;
	private String name;
	private String email;
	private boolean enabled;
	
	
		@Enumerated(EnumType.STRING)
	 @Column(name = "auth_provider")
	private Authentication_Provider authentication_Provider;
		
		
		@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
		@JoinTable(name = "users_roles",
		joinColumns = @JoinColumn(name = "id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
				
		 private Set<Role> roles = new HashSet<>();

	public User(Integer id, String username, String password, String name, String email,
				Authentication_Provider authentication_Provider, Set<Role> roles,boolean enabled) {
			this.id = id;
			this.username = username;
			this.password = password;
			this.name = name;
			this.email = email;
			this.authentication_Provider = authentication_Provider;
			this.roles = roles;
			this.enabled = enabled;
		}


	public User() {
		
	}

	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Authentication_Provider getAuthentication_Provider() {
		return authentication_Provider;
	}



	public void setAuthentication_Provider(Authentication_Provider authentication_Provider) {
		this.authentication_Provider = authentication_Provider;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	public Authentication_Provider getAuthenticationProvider() {
		return authentication_Provider;
	}

	public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
		this.authentication_Provider = authentication_Provider;
	}
	

	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
  
	 public boolean isEnabled() {
		 return enabled;
	 }


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", enabled=" + enabled + ", authentication_Provider=" + authentication_Provider + ", roles="
				+ roles + "]";
	}	
	

}
