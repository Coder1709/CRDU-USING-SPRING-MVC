package org.nucleus.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController //This annotation is used to create RESTful web services using Spring MVC
public class HomeController {

    @RequestMapping(value = "/hello") //This annotation is used to map web requests onto specific handler classes and/or handler methods
    public String getHelloView(){

        return "HelloWorld"; //This will return the string "HelloWorld" when the URL is hit


    }


    //http://localhost:8081/SpringDay56/hello --Url to hit the above method in POSTMAN

}
