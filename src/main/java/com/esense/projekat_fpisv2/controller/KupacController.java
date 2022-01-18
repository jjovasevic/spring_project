package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.dto.KupacInsertDTO;
import com.esense.projekat_fpisv2.dto.KupacUpdateDTO;
import com.esense.projekat_fpisv2.entity.*;
import com.esense.projekat_fpisv2.service.*;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200/")
@RestController
// @RequestMapping("/")
public class KupacController {

    private KupacService kupacService;

    @Autowired
    public KupacController(KupacService kupacService) {
        this.kupacService = kupacService;
    }

    @GetMapping("/kupac")
    public List<Kupac> vratiKupce(){
        return kupacService.getAll();
    }


    @GetMapping("/kupac/id/{pib}")
    public Kupac vratiKupca(@PathVariable Long pib) {
        return kupacService.getById(pib);
    }

    @GetMapping("/kupac/{naziv}")
    public List<Kupac> vratiKupce(@PathVariable String naziv){
        return kupacService.getByName(naziv);
    }

    @PostMapping("/kupac")
    public Kupac dodajKupca(@RequestBody KupacInsertDTO kupacInsert) {
        try {
            return kupacService.insert(kupacInsert);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/kupac/{pib}")
    public String obrisiKupca(@PathVariable Long pib){
        return kupacService.deleteById(pib);
    }

    @PutMapping("/kupac")
    public Kupac promeniKupca(@RequestBody KupacUpdateDTO kupacUpdate){
        try {
            return kupacService.update(kupacUpdate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
