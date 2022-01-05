package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.NacinPlacanja;
import com.esense.projekat_fpisv2.service.NacinPlacanjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("nacinPlacanja")
@CrossOrigin("http://localhost:4200/")
@RestController
public class NacinPlacanjaController {

    private NacinPlacanjaService nacinPlacanjaService;

    public NacinPlacanjaController(NacinPlacanjaService nacinPlacanjaService) {
        this.nacinPlacanjaService = nacinPlacanjaService;
    }

    @GetMapping
    public List<NacinPlacanja> vratiSveNacinePlacanja(){ return nacinPlacanjaService.getAll(); }

    @GetMapping("/{id}")
    public NacinPlacanja vratiNacinPlacanja(@PathVariable String id){
        try {
            return nacinPlacanjaService.getOne(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
