package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloSpringController {
/*
    // Handle request at path /hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }
*/
/*
    //lives /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {

        return "Goodbye, Spring!";
    }
*/
/*
    //lives /hello/hello
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {

        return "Hello, " + name + "!";
    }


/*
    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {

        return "Hello, " + name + "!";
    }
*/
    // /hello/form
    @GetMapping("form")
    public String helloForm(){

        return "<html>" +
                "<body>" +
                "<form action= '/hello/hello' method = 'post'>" + // submit request to hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value="/hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {

        System.out.println("Name: " + name);
        System.out.println("Language: " + language);

        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Gunten tag";
        }

        return greeting + " " + n;
    }
}