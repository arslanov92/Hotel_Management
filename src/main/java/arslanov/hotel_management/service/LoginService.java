/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arslanov.hotel_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import arslanov.hotel_management.dao_interface.DAO_User;
import arslanov.hotel_management.model.User;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    @Autowired
    public DAO_User user;
    
    public boolean checkLogin(String login){
          User  u = user.checkUserLogin(login);
           if (u!=null) {
            return true;
           } else
           {return false;}
                
    }
    public boolean chekPwd(String pwd){
        User  u = user.checkUserPassword(pwd);
           if (u!=null) {
            return true;
           } else
           {return false;}       
    }
    
    public long chekLoginAndPwd(String login, String pwd){
       User u = user.checkUserLoginAndPwd(login, pwd);
        if (u!=null) {
           long id = u.getUserId();
            return id;
           } else
           {return -1;}   
    }
    public Map<Integer,String> getNameLastNameLoginUser(String login, String pwd){
        User u = user.checkUserLoginAndPwd(login, pwd);
        String name = u.getFirstName();
        String lastName = u.getLastName();
        TreeMap<Integer,String> names = new TreeMap();
        names.put(1, name);
        names.put(2, lastName);
        return names;
    }
}
