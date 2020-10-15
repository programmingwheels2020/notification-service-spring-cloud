package com.verizontraining.notificationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmailController {

	@GetMapping("/send-registration-email/{email}")
	@HystrixCommand(fallbackMethod = "SendRegistrationEmailFallback")
	public String SendRegistrationEmail(@PathVariable("email") String email) {

		//throw new RuntimeException("Not Available");
		// System.out.println("Successfully send Email to "+email);
		 return "Success";
	}

	public String SendRegistrationEmailFallback( String email) {

		return "This is fallback";
	}

}
