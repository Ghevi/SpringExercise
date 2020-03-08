package com.ghevi.demo.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class HelloController {

    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello world!";
    }

    @RequestMapping("/proper")  // Doesnt need to be value and method because by default it's a GET
    public String sayProperHello(){
        return "Hello there, how are you?";
    }

    @RequestMapping("/user_entry")
    public String userForm(){ //this html form below should be part of a html file, not here
        return "<form action=\"/greeting/user_greeting\" method=\"POST\">\n" +
                "  <label for=\"fname\">First name:</label><br>\n" +
                "  <input type=\"text\" id=\"fname\" name=\"fname\"<br>\n" +
                "  <label for=\"lname\">Last name:</label><br>\n" +
                "  <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> ";
    }

    @RequestMapping(value="/user_greeting", method = RequestMethod.POST) // if we change to GET here and above in the html form,
                                                                         // these two params will be displayed in the browser URL as "query" parameters.
    public String printUserGreeting(@RequestParam String fname, @RequestParam String lname){
        return "Hello there, " + fname + " " + lname;
    }

    @RequestMapping(value="/orders/{id}", method = RequestMethod.GET) // {id} is called a path variable
    public String getOrder(@PathVariable String id){                  // so it needs the right annotation
        return "Order ID: " + id;
    }
}
