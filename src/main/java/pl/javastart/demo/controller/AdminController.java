package pl.javastart.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.javastart.demo.domain.ApplicationUser;
import pl.javastart.demo.domain.Role;
import pl.javastart.demo.repository.UserRoleRepository;
import pl.javastart.demo.service.UserService;

import java.util.List;

@Controller
class AdminController {
    private final UserService userService;
    private final UserRoleRepository userRoleRepository;

    public AdminController(UserService userService, UserRoleRepository userRoleRepository) {
        this.userService = userService;
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping("/admin")
    String getAdminPage(Model model) {
        List<ApplicationUser> users = userService.findAll();
        model.addAttribute("users", users);
        return "adminPanel";
    }

    @GetMapping("/admin/edit-user/{user}")
    String editUser(@PathVariable ApplicationUser user, Model model) {
        user.setPassword(null); //clear password to not show it in form
        model.addAttribute("user", user);
        Iterable<Role> roles = userRoleRepository.findAll();
        model.addAttribute("roles", roles);
        return "adminUserEditForm";
    }
}
