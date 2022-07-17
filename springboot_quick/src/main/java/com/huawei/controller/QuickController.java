package com.huawei.controller;

import com.huawei.model.*;
import com.huawei.repsitory.MovieRepsitory;
import com.huawei.repsitory.PersonRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class QuickController {

    @Autowired
    private PersonRepsitory personRepsitory;

    @Autowired
    private MovieRepsitory movieRepsitory;

    @PostMapping(path = "/quick")
    public User quick(User user) {
        System.out.println("hello spring ");
        user.setAge(29);
        user.setDates(Arrays.asList(new Date()));
        user.setName("小明");
        return user;
    }

    @GetMapping(path = "/find/movie")
    public List<MovieNode> findMovie() {
        return movieRepsitory.findAll();
    }

    @GetMapping(path = "/find/person")
    public List<PersonNode> findPerson() {
        return personRepsitory.findAll();
    }
}
