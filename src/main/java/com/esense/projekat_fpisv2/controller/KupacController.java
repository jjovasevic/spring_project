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
    private GradService gradService;
    private UlicaService ulicaService;
    private AdresaService adresaService;
    private ZaposleniService zaposleniService;

    @Autowired
    public KupacController(KupacService kupacService, GradService gradService, UlicaService ulicaService, AdresaService adresaService, ZaposleniService zaposleniService) {
        this.kupacService = kupacService;
        this.gradService = gradService;
        this.ulicaService = ulicaService;
        this.adresaService = adresaService;
        this.zaposleniService = zaposleniService;
    }

    @GetMapping("/kupac")
    public List<Kupac> vratiKupce(){
        return kupacService.getAll();
    }


    @GetMapping("/kupac/id/{pib}")
    public Kupac vratiKupca(@PathVariable Long pib) {
        Optional<Kupac> kupacOptional = kupacService.getById(pib);

        if(kupacOptional.isPresent()){
            return kupacOptional.get();
        }else{
            return null;
        }
    }

    @GetMapping("/kupac/{naziv}")
    public List<Kupac> vratiKupce(@PathVariable String naziv){
        return kupacService.getByName(naziv);
    }

    @PostMapping("/kupac")
    public Kupac dodajKupca(@RequestBody KupacInsertDTO kupacInsert) throws Exception {

        Zaposleni zaposleni = zaposleniService.getById(kupacInsert.getJmbg());

        AdresaIDembeddable id_adrese = new AdresaIDembeddable();
        id_adrese.setAdresa_ID(kupacInsert.getAdresa_ID());
        id_adrese.setSifra_ulice(kupacInsert.getSifra_ulice());
        id_adrese.setPostanski_broj(kupacInsert.getPostanski_broj());

        Optional<Adresa> optionalAdresa = adresaService.getById(id_adrese);

        if(optionalAdresa.isPresent()) {
            Adresa adresa = optionalAdresa.get();

            Kupac kupac = new Kupac(kupacInsert.getNaziv_kupca(),
                    kupacInsert.getEmail_kupca(), kupacInsert.getTelefon_kupca(), kupacInsert.getPotpis(), adresa, zaposleni);

            return kupacService.insert(kupac);
        }else{
            throw new Exception("Adresa ne postoji.");
        }
    }

    @DeleteMapping("/kupac/{pib}")
    public String obrisiKupca(@PathVariable Long pib){
        return kupacService.deleteById(pib);
    }

    @PutMapping("/kupac")
    public Kupac promeniKupca(@RequestBody KupacUpdateDTO kupacUpdate) throws Exception {

        Zaposleni zaposleni = zaposleniService.getById(kupacUpdate.getJmbg());

        AdresaIDembeddable id_adrese = new AdresaIDembeddable();
        id_adrese.setAdresa_ID(kupacUpdate.getAdresa_ID());
        id_adrese.setSifra_ulice(kupacUpdate.getSifra_ulice());
        id_adrese.setPostanski_broj(kupacUpdate.getPostanski_broj());

        Optional<Adresa> optionalAdresa = adresaService.getById(id_adrese);

        if(optionalAdresa.isPresent()) {
            Adresa adresa = optionalAdresa.get();



            Kupac kupac = new Kupac(kupacUpdate.getPib(),kupacUpdate.getNaziv_kupca(),
                                    kupacUpdate.getEmail_kupca(), kupacUpdate.getTelefon_kupca(),
                                    kupacUpdate.getPotpis(), adresa, zaposleni);

            return kupacService.update(kupac);
        }else{
            throw new Exception("Adresa ne postoji.");
        }
    }

}
