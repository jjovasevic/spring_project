package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.Proizvod;
import com.esense.projekat_fpisv2.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("proizvod")
@CrossOrigin("http://localhost:4200/")
@RestController
public class ProizvodController {

    private ProizvodService proizvodService;

    @Autowired
    public ProizvodController(ProizvodService proizvodService) {
        this.proizvodService = proizvodService;
    }

    @GetMapping
    public List<Proizvod> vratiSveProizvode(){
        return proizvodService.getAll();
    }
}
