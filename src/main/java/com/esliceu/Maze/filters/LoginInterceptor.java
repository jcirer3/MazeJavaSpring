package com.esliceu.Maze.filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //Torna true si ha anat be o false si ha anat malament
        System.out.println("Dins interceptor");
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if (user == null) {
            //L'usuari no ha fet login
            response.sendRedirect("/login");
            return false;
        }
        //L'usuari ha fet login
        return true;
    }
}
