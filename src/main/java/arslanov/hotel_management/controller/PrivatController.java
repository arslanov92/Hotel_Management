
package arslanov.hotel_management.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@WebServlet(name = "private_controller", urlPatterns = {"/private"})
public class PrivatController {
    protected ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ModelAndView mv = new ModelAndView("private_article");         
        response.setContentType("text/html;charset=UTF-8");
        if ("/private".equals(request.getServletPath())){
            mv.addObject("name", request.getUserPrincipal().getName()); 
//            request.getRequestDispatcher("WEB-INF/private/private_article.jsp").
//forward(request, response);
        }else
        if ("/logout".equals(request.getServletPath())){
            HttpSession session = request.getSession(false);
            if (session!= null){
                session.invalidate();
            }
            response.sendRedirect("/");
        }
        return mv;
    }
}
