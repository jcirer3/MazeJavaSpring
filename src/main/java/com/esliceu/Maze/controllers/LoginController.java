    package com.esliceu.Maze.controllers;

    import com.esliceu.Maze.services.LoginService;
    import jakarta.servlet.http.HttpSession;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;


    @Controller
    public class LoginController {
        @Autowired
        LoginService loginService;

        @GetMapping("/login")
        public String showLoginPage() {
            return "login";
        }

        @PostMapping("/perform-login")
        public String performLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
            boolean isValidUser = loginService.authenticate(username, password);

            if (isValidUser) {
                // Successful login: Store user in session
                session.setAttribute("user", username);
                return "redirect:/home"; // Redirect to a secured page after login
            }

            return "redirect:/login?error";
        }

        @GetMapping("/logout")
        public String logout(HttpSession session) {
            // Invalidate the session to log out the user
            session.invalidate();
            return "redirect:/login";
        }
    }
