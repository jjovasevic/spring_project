package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.Faktura;
import com.esense.projekat_fpisv2.service.FakturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("faktura")
@CrossOrigin("http://localhost:4200/")
@RestController
public class FakturaController {

    private FakturaService fakturaService;

    @Autowired
    public FakturaController(FakturaService fakturaService) {
        this.fakturaService = fakturaService;
    }

    @GetMapping
    public List<Faktura> vratiSveFakture(){
        return fakturaService.getAll();
    }
}
