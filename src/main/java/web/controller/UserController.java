package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(ModelMap model) {
        model.addAttribute("show", userService.usersList());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") @Valid User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.adduser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, @PathVariable("id") long id) {
        userService.update(user);
        return "redirect:/users";
    }


    @DeleteMapping
    public String delete(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}