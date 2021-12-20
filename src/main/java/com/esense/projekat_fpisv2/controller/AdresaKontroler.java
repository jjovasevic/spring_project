package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.Adresa;
import com.esense.projekat_fpisv2.service.AdresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RequestMapping("")
@RestController
public class AdresaKontroler {

    private AdresaService adresaService;

    @Autowired
    public AdresaKontroler(AdresaService adresaService) {
        this.adresaService = adresaService;
    }

    @GetMapping("adresa")
    public List<Adresa> vratiAdrese(){
        return adresaService.getAll();
    }
}
