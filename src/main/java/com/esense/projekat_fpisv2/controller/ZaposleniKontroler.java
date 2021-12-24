package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.Zaposleni;
import com.esense.projekat_fpisv2.service.ZaposleniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
public class ZaposleniKontroler {

    private ZaposleniService zaposleniService;

    @Autowired
    public ZaposleniKontroler(ZaposleniService zaposleniService) {
        this.zaposleniService = zaposleniService;
    }

    @GetMapping("/zaposleni")
    public List<Zaposleni> vratiZaposlene(){
        return zaposleniService.getAll();
    }
}
