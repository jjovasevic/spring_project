package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.Ulica;
import com.esense.projekat_fpisv2.service.UlicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RequestMapping("")
@RestController
public class UlicaKontroler {

    private UlicaService ulicaService;

    @Autowired
    public UlicaKontroler(UlicaService ulicaService) {
        this.ulicaService = ulicaService;
    }

    @GetMapping("ulica")
    public List<Ulica> vratiUlice(){
        return ulicaService.getAll();
    }
}
