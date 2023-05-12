package com.university.backendForFaculty.Controllers;


import com.university.backendForFaculty.DbScripts.DbInit;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init")
public class InitController {
    @Autowired
    DbInit initter;

    @GetMapping("/")
    public void init(){
        initter.initDB();
    }
}
