package learnajax.controller;


import learnajax.beans.ResultBean;
import learnajax.beans.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/get1")
    public ResultBean<String> get1() {
        System.out.println("faq");
        System.out.println("-----------------TestController.get1()---------------------------");
        return new ResultBean<>("get1 o98k");
    }

    @GetMapping("/api/demoinfo")
    public ResultBean<User> demoinfo() {
        User user = new User();
        user.setAge(23);
        user.setName("DIO");
        System.out.println("======called====== in" + System.currentTimeMillis());
        return new ResultBean<>(user);
    }
}
