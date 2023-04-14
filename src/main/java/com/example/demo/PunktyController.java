package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/punkty")
public class PunktyController {
    List<String> users;

    public PunktyController() {
        users = new CopyOnWriteArrayList<String>();
        users.addAll(Arrays.asList("Student1", "Student2", "Student3"));

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<String> getUsers()
    {
        return users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    int addUser(@RequestBody String user)
    {
        users.add(user);
        return users.size();
    }
}
