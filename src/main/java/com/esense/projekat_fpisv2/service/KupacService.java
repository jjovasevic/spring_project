package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.dto.KupacInsertDTO;
import com.esense.projekat_fpisv2.dto.KupacUpdateDTO;
import com.esense.projekat_fpisv2.entity.Adresa;
import com.esense.projekat_fpisv2.entity.AdresaIDembeddable;
import com.esense.projekat_fpisv2.entity.Kupac;
import com.esense.projekat_fpisv2.entity.Zaposleni;
import com.esense.projekat_fpisv2.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class KupacService{

    private KupacRepository kupacRepository;
    private GradService gradService;
    private UlicaService ulicaService;
    private AdresaService adresaService;
    private ZaposleniService zaposleniService;

    @Autowired
    public KupacService(KupacRepository kupacRepository, GradService gradService, UlicaService ulicaService, AdresaService adresaService, ZaposleniService zaposleniService) {
        this.kupacRepository = kupacRepository;
        this.gradService = gradService;
        this.ulicaService = ulicaService;
        this.adresaService = adresaService;
        this.zaposleniService = zaposleniService;
    }

    @Transactional
    public List<Kupac> getAll(){
        return kupacRepository.findAll();
    }

    @Transactional
    public Kupac getById(Long pib){
        Optional<Kupac> kupacOptional = kupacRepository.findById(pib);
        if(kupacOptional.isPresent()){
            return kupacOptional.get();
        }else{
            return null;
        }
    }

    @Transactional
    public List<Kupac> getByName(String naziv_kupca){
        return kupacRepository.findAllByNaziv_kupca(naziv_kupca);
    }

    @Transactional
    public Kupac insert(KupacInsertDTO kupacInsert) throws Exception {
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

            return kupacRepository.save(kupac);
        }else{
            throw new Exception("Adresa ne postoji.");
        }
    }

    @Transactional
    public Kupac update(KupacUpdateDTO kupacUpdate) throws Exception {
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

            return kupacRepository.save(kupac);
        }else{
            throw new Exception("Adresa ne postoji.");
        }
    }

    @Transactional
    public String deleteById(Long pib) {
        List<Kupac> postojeciKupci = kupacRepository.findAll();
        for(int i = 0; i < postojeciKupci.size(); i++){
            if(pib == postojeciKupci.get(i).getPib()){
                kupacRepository.deleteById(pib);
                return "Uspesno obrisan kupac iz baze.";
            }
        }
        return "Kupac nije obrisan jer ne postoji u bazi.";
    }

}
