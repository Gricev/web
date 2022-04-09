package com.gricev.web.controllers;

import com.gricev.web.models.*;
import com.gricev.web.repo.PostRepository;
import com.gricev.web.repo.RegistrateEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
public class MainController extends Configs {


    @Autowired
    private RegistrateEntityRepository registrateEntityRepository;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("title", "Главная");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        return "about";
    }

    @GetMapping("/666")
    public String yA(Model model) {
        model.addAttribute("title", "Спроси у Яндекса");
        return "ya";

    }

    @GetMapping("/price")
    public String getPrice(Model model) {
        model.addAttribute("title", "Подписка");
        return "price";
    }

    @GetMapping("/sign-in")
    public String signIn(Model model) {
        model.addAttribute("title", "Авторизация");
        return "sign-in";
    }

    @PostMapping("/sign-in")
    public String signInPost(@RequestParam String email, @RequestParam String password, Model model) {

        DataBaseHandler dbHandler = new DataBaseHandler();
        RegistrateEntity registrateEntity = new RegistrateEntity();
        registrateEntity.setEmail(email);
        registrateEntity.setPassword(password);
        ResultSet result = dbHandler.getUser(registrateEntity);
        try {
            if (result.next()) {
                return "redirect:/userhome";
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        if (email.isEmpty() || (password.isEmpty())) {
            System.err.println("Вы ввели пустой логин или пароль");
            return "sign-in";
        } else {
            System.err.println("Вы ввели некорректный логин или пароль.");
            return "sign-in";
        }

    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("title", "Регистрация");
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpUserAdd(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email,
                                @RequestParam String country, @RequestParam String password, @RequestParam long phonenumber,
                                @RequestParam String sex, Model model) {
        RegistrateEntity registrateEntity = new RegistrateEntity(firstname, lastname, email, country, password, phonenumber, sex);
        if (!email.equals("gricev10@mail.ru")) {
            registrateEntityRepository.save(registrateEntity);
            return "redirect:/sign-in";
        } else {
            System.err.println("Такой пользователь уже усществует");
            return "redirect:/sign-up";
        }
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }

    @GetMapping("/userhome")
    public String getUserHome(@RequestParam(value = "firstname", required = false) String firstname,
                              @RequestParam(value = "lastname", required = false) String lastname, Model model) {
        model.addAttribute("user", "Приветствуем, " + firstname + " " + lastname);
//        if () {
//            return "userhome";
//        } else {
//            return "redirect:/sign-in";
//        }
        return "userhome";
    }
}