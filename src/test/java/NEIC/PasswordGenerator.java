package NEIC;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String pass = "BigEditorOfMis";
		
		String encondePassword = encoder.encode(pass);
		
	     System.out.println("This is encripted Password: " + encondePassword);

	}

}
