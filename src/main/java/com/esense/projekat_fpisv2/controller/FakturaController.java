package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.dto.InsertObject;
import com.esense.projekat_fpisv2.dto.KupacInsertDTO;
import com.esense.projekat_fpisv2.entity.*;
import com.esense.projekat_fpisv2.service.FakturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{valuta}")
    public List<Faktura> vratiFakturePoValuti(@PathVariable String valuta){
        return fakturaService.findAllByValuta(valuta);
    }

    @GetMapping("/id/{sifraFakture}")
    public Faktura vratiFakturu(@PathVariable Long sifraFakture){
        return fakturaService.findById(sifraFakture);
    }

    @DeleteMapping("/{sifraFakture}")
    public String obrisiFakturu(@PathVariable String sifraFakture){
        return fakturaService.deleteById(Long.valueOf(sifraFakture.trim())); }

    @PostMapping
    public Faktura dodajFakturu(@RequestBody InsertObject insertObject) throws Exception {
        return fakturaService.save(insertObject);
    }




}
