package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankRestController {
	
	@GetMapping("/")
	public String wishMessage() {
		return "Welcome to ICICI bbank";
	}
	
	@GetMapping("/transfer")
	public String fundTransfer() {
		return "Fund transfer";
	}
	
	@GetMapping("/aboutus")
	public String aboutUs() {
		return "ICICI bank";
	}
	
	@GetMapping("/balance")
	public String balance() {
		return "Balance amount is 15k";
	}

}
