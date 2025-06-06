package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.entity.MyUser;
import kr.ac.hansung.cse.hellospringdatajpa.service.RegistrationService;
import kr.ac.hansung.cse.hellospringdatajpa.service.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RegistrationServiceImpl registrationService;

    @GetMapping("/home")
    public String adminHome() {
        return "adminhome";
    }

    @GetMapping("/users")
    public String adminUsers(Model model) {
        List<MyUser> listUsers = registrationService.findAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "adminusers";
    }

}
