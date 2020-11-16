package projekti;

import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignUp(Model model) {
        return "signup";
    }
    
    @PostMapping("/signup") 
    public String signup(@RequestParam String name, @RequestParam String username, @RequestParam String password) { 
        if (accountRepository.findByUsername(username) != null) {
            System.out.println("USERNAME RESERVED");
            return "redirect:/signup";
        }

        Account a = new Account();
        a.setName(name);
        a.setUsername(username);
        a.setPassword(passwordEncoder.encode(password));
        accountRepository.save(a);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(){
         return "redirect:/login";
    }

}
