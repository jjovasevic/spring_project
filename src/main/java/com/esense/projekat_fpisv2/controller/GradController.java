package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.Grad;
import com.esense.projekat_fpisv2.service.GradService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// @RequestMapping("prost")
@CrossOrigin("http://localhost:4200/")
@RestController
public class GradController {

    private GradService gradService;

    @Autowired
    public GradController(GradService gradService) {
        this.gradService = gradService;
    }

    @GetMapping("/grad")
    public List<Grad> vratiGradove(){
        return gradService.getAll();
    }
}
