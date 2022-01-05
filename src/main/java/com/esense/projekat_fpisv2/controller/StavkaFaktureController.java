package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.StavkaFakture;
import com.esense.projekat_fpisv2.service.StavkaFaktureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("stavka")
@CrossOrigin("http://localhost:4200/")
@RestController
public class StavkaFaktureController {

    private StavkaFaktureService stavkaFaktureService;

    @Autowired
    public StavkaFaktureController(StavkaFaktureService stavkaFaktureService) {
        this.stavkaFaktureService = stavkaFaktureService;
    }

    @GetMapping
    public List<StavkaFakture> vratiSveStavke(){ return stavkaFaktureService.getAll(); }
}
