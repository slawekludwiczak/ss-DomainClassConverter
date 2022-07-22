package pl.javastart.demo.controller;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.demo.domain.ApplicationUser;
import pl.javastart.demo.service.UserService;

@Controller
class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/edit")
    String getUserEditForm(@CurrentSecurityContext(expression = "authentication.name") String username,
                           Model model) {
        ApplicationUser currentUser = userService.findByUsername(username).orElseThrow();
        currentUser.setPassword(null); //clear password to not show it in form
        model.addAttribute("user", currentUser);
        return "userEditForm";
    }

    @PostMapping("/user/update")
    String editUser(ApplicationUser user) {
        userService.partialUpdate(user);
        return "redirect:/success";
    }
}
