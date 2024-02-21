package ca.sheridancollege.vutran.controllers;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.vutran.beans.Account;
import ca.sheridancollege.vutran.beans.Country;

@Controller
public class HomeController {
	final private String REST_URL = "http://localhost:50000/account";
	
	@GetMapping("/") 
    public String index(Model model, RestTemplate restTemplate) {
        ResponseEntity<ArrayList<Account>> responseEntity =
                (ResponseEntity<ArrayList<Account>>) restTemplate.getForEntity(REST_URL, new ArrayList<Account>().getClass());
        model.addAttribute("accountList", responseEntity.getBody());
        return "index";
    }
	
	@GetMapping("/blankForm")
    public String blankAccountForm(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("countries", Country.values());
        return "add";
    }
	
	@PostMapping("/add")
    public String insertAccount(Model model, @ModelAttribute Account account, RestTemplate restTemplate) {
        restTemplate.postForLocation(REST_URL, account);
        ResponseEntity<ArrayList<Account>> responseEntity =
        (ResponseEntity<ArrayList<Account>>) restTemplate.getForEntity(REST_URL, new ArrayList<Account>().getClass());
        model.addAttribute("accountList", responseEntity.getBody());
        return "index";
    }
}
