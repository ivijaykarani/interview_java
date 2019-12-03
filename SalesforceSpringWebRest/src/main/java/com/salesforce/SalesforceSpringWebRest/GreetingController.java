package com.salesforce.SalesforceSpringWebRest;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greet() {
        return "Hello There!";
    }

    @GetMapping(value = "/greet2")
    public String greet2(@RequestParam String name,
                         @RequestParam(required = false) String time) {
        if (time == null)
            time = "day";
        return "Hello There!, Your name is " + name + ", Glad to see you joined at " + time;
    }

    @GetMapping(value = "/user/{id}/name")
    public String greet3(@PathVariable(value = "id") int id) {
        return "Hello There!, with id " + id;
    }

    @GetMapping(value = "/request-header")
    public String language(@RequestHeader(value="Accept-Language") String language) {
        return "Header Language: " + language;
    }
}