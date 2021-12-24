package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.Ulica;
import com.esense.projekat_fpisv2.service.UlicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RequestMapping("")
@CrossOrigin("http://localhost:4200/")
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


    @GetMapping("ulica/{postanskiBroj}")
    public List<Ulica> vratiUlicePoPostanskomBroju(@PathVariable Long postanskiBroj){
        return ulicaService.getByPostalCode(postanskiBroj);
    }
}
