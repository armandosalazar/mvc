package mvc.controllers;

import mvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class BasicController {

    @GetMapping(path = {"/hola", "/hi"})
    public String hola(@RequestParam(name = "name", required = false, defaultValue = "Luis") String name, @RequestParam String lastname, Model model) {
        System.out.println(name.getClass() + " >>> " + name);
        System.out.println(name.getClass().equals(String.class));
        model.addAttribute("name", name);
        model.addAttribute("lastname", lastname);
        Map<String, String> map = new HashMap<>();
        map.put("name", "Armando");
        map.put("lastname", "Salazar");
        map.put("age", "24");
        model.addAttribute("person", map);
        return "index";
    }

    // @GetMapping(path = {"/usuarios", "users"})
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Model model) {
        User users[] = new User[10];
        users[0] = new User("0", "0");
//        for (int i = 1; i < users.length; i++) {
//            users[i] = new User(users[0].getName() + i, users[0].getLastname() + i);
//        }
//        for (User user :
//                users) {
//            System.out.println(user);
//        }
        model.addAttribute("users", users);
        return "users";
    }
}
