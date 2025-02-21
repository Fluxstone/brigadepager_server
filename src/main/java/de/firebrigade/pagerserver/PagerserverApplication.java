package de.firebrigade.pagerserver;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PagerserverApplication {

	public static void main(String[] args) {

		try {
			FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.getApplicationDefault()).build();
			FirebaseApp.initializeApp(options);
			SpringApplication.run(PagerserverApplication.class, args);
		} catch (Exception e) {
			System.out.println("SOMETHING WENT WRONG WITH FIREBASE INITIALIZATION");
			throw new RuntimeException(e);
		}

	}

}
