package com.stacksimplify.restservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

    //Method
    //URI -/ helloworld
    //GET method needed
    //@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
    @GetMapping("/helloworld1")
    public String helloWorld(){

        return "Hello World";
    }

    @GetMapping("/helloworld-bean")
    public  UserDetails helloWorldBean(){
        return new UserDetails("rabeeka", "sadiq", "karachi");
    }
}
