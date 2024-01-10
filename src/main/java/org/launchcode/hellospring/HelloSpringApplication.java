package org.launchcode.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
public class HelloSpringApplication {
	@GetMapping("hello")
	@ResponseBody
	public String hello() {
		return "Hello, Spring!";
	}

	@GetMapping("form")
	@ResponseBody
	public String form() {
		String html =
				"<html>" +
						"<body>" +
						"<form method = 'post' action = '/hi'>" +
						"<input type = 'text' name = 'coder' />" +
						"<select name = 'lang'>" +
						"<option value = 'Hello'>English</option>" +
						"<option value = 'Bonjour'>French</option>" +
						"<option value = 'Hola'>Spanish</option>" +
						"<option value = 'Xin Chao'>Vietnamese</option>" +
						"<option value = 'Namaste'>Indian</option>" +
						" </select>"+
						"<input type = 'submit' value = 'Greet Me!' />" +
						"</form>" +
						"</body>" +
						"</html>";
		return  html;
	}

	@RequestMapping(value = "hi", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String hi(@RequestParam String lang, @RequestParam String coder) {
		return lang + " " + coder;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
