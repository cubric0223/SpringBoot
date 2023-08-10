package dev.cubric.shopping_mall.Controller;

import dev.cubric.shopping_mall.Service.UserService;
import dev.cubric.shopping_mall.Entity.User;
import dev.cubric.shopping_mall.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/loginform")
    public String loginForm() {
        return "loginform";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session,
            Model model
    ) {
        Optional<User> user = userService.authenticateUser(email, password);

        if (user.isPresent()) {
            session.setAttribute("loggedInUser", user.get());
            return "redirect:/";
        } else {
            model.addAttribute("loginError", "이메일 혹은 패스워드를 확인해 주세요");
            return "loginform";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("loggedInUser");
        model.addAttribute("loggedInUser", null);
        return "redirect:/";
    }

    @GetMapping("/userReg")
    public String userRegForm() {
        return "userReg";
    }

    @PostMapping("/userReg")
    public String userReg(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        User user = new User(name, email, password);
        userRepository.save(user);
        return "redirect:/loginform";
    }
}
