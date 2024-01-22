package in.ineuron.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	
	@GetMapping("/balance")
	public String showBalance(Map<String,Object> map) {
		System.out.println("BankController.showBalance()");
		map.put("balance_amt", new Random().nextInt(100000));
		return "show_balance";
	}
	
	@GetMapping("/loanApprove")
	public String approveLoan(Map<String,Object> map) {
		map.put("amount", new Random().nextInt(100000));
		return "loan";
	}
	
	@GetMapping("/denied")
	public String accessDenied(Map<String,Object> map) {
		map.put("username",SecurityContextHolder.getContext().getAuthentication().getName());
	return "denied";
	}

}
