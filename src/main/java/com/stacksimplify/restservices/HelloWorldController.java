package com.stacksimplify.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
    @Autowired
    private ResourceBundleMessageSource messageSource;
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
    @GetMapping("/hello-int")
    public String getMessagesInI18NFormat2(){
        return messageSource.getMessage("label.hello",null, LocaleContextHolder.getLocale());
    }
}
