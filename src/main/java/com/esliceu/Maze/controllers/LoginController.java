    package com.esliceu.Maze.controllers;

    import com.esliceu.Maze.model.User;
    import com.esliceu.Maze.services.LoginService;
    import jakarta.servlet.http.HttpSession;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.security.InvalidAlgorithmParameterException;
    import java.security.NoSuchAlgorithmException;


    @Controller
    public class LoginController {
        @Autowired
        LoginService loginService;

        @GetMapping("/login")
        public String showLoginPage() {
            return "login";
        }
        @GetMapping("/logout")
        public String logout(HttpSession session) {
            session.invalidate();
            return "redirect:/login";
        }
        @PostMapping("/perform-login")
        public String performLogin(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) throws NoSuchAlgorithmException {
            User user = loginService.authenticate(username, password);

            if (user != null){
                session.setAttribute("user", user);
                return "redirect:/start";
            }
            return "login";
        }
    }
