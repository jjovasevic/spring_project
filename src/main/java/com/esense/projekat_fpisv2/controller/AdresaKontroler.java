package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.Adresa;
import com.esense.projekat_fpisv2.entity.AdresaIDembeddable;
import com.esense.projekat_fpisv2.entity.Ulica;
import com.esense.projekat_fpisv2.entity.UlicaIDembeddable;
import com.esense.projekat_fpisv2.service.AdresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RequestMapping("")
@CrossOrigin("http://localhost:4200/")
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

//    @GetMapping("adresa/{spoljniKljuc}")
//    public List<Adresa> vratiAdresePoSpoljnomKljucu(@PathVariable UlicaIDembeddable spoljniKljuc){
//        return adresaService.getByForeignKey(spoljniKljuc);
//    }

    @GetMapping("adresa/{grad}/{ulica}")
    public List<Adresa> vratiAdresePoSpoljnomKljucu(@PathVariable("grad") Long grad, @PathVariable("ulica") String ulica){
        return adresaService.getByForeignKey(grad,ulica);
    }
}
