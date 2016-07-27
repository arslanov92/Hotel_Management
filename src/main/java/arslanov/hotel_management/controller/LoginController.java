package arslanov.hotel_management.controller;

import arslanov.hotel_management.dao_interface.DAO_User;
import arslanov.hotel_management.model.User;
import arslanov.hotel_management.service.LoginService;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    public DAO_User userDao;
    @Autowired
    public LoginService loginService;

    private static final Logger logger = LoggerFactory.getLogger(LookUpController.class);

    @RequestMapping(value = "login")
    public ModelAndView doLogin(@RequestParam("login") String login,
            @RequestParam("pwd") String pwd,
            HttpSession session) {
        ModelAndView mv = new ModelAndView("index");
        long id = loginService.chekLoginAndPwd(login, pwd);
        if (id > 0) {
            Map<Integer, String> names = loginService.getNameLastNameLoginUser(login, pwd);
            String name = names.get(1);
            String lastName = names.get(2);
            session.setAttribute("name", name);
            session.setAttribute("lastName", lastName);
            session.setAttribute("userId", id);
            logger.info("logged in login {}", login);
        } else {
            mv.setViewName("error");
            mv.addObject("msg", "Ошибка входа в систему");
            mv.addObject("details", "Пользователя с таким логином и паролем не найдено");
            logger.error("error logging LOGIN {}", login);
        }
        return mv;
    }

    @RequestMapping(value = "logout")
    public ModelAndView doLogout(HttpSession session, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("index");
        session.invalidate();
        return mv;
    }

    @RequestMapping(value = "registration")
    public ModelAndView viewRegistration() {
        ModelAndView mv = new ModelAndView("registration");
        return mv;
    }

    @RequestMapping(value = "registrationDo")
    public ModelAndView signUp(@RequestParam("login") String login, @RequestParam("pwd") String pwd,
            @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
            HttpSession session) {
        ModelAndView mv = new ModelAndView("index");
        if (loginService.checkLogin(login)) {
            mv.setViewName("registration");
            mv.addObject("msg", "Ошибка регистрации");
            mv.addObject("details", "Пользователь с таким логином уже существует");
            return mv;
        }
        User u = new User();
        u.setLogin(login);
        u.setPwd(pwd);
        u.setFirstName(firstName);
        u.setLastName(lastName);
        logger.info(userDao.getClass().getName());
        userDao.createNewUser(u);
        long id = loginService.chekLoginAndPwd(login, pwd);
        session.setAttribute("name", firstName);
        session.setAttribute("lastName", lastName);
        session.setAttribute("userId", id);
        mv.setViewName("index");
        return mv;

    }

}
