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

    @PostMapping
    public String dodajFakturu(@RequestBody InsertObject insertObject) throws Exception {
        return fakturaService.save(insertObject);
    }
}
