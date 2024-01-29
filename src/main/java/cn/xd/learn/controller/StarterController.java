package cn.xd.learn.controller;

import com.xd.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarterController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/learn/starter")
    public String sayHello() {
        return helloService.sayHelloXd("name");
    }
}
