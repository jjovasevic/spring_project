package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.Kupac;
import com.esense.projekat_fpisv2.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class KupacService{

    private KupacRepository kupacRepository;

    @Autowired
    public KupacService(KupacRepository kupacRepository) {
        this.kupacRepository = kupacRepository;
    }

    @Transactional
    public List<Kupac> getAll(){
        return kupacRepository.findAll();
    }

    @Transactional
    public Optional<Kupac> getById(Long pib){
        return kupacRepository.findById(pib);
    }

    @Transactional
    public List<Kupac> getByName(String naziv_kupca){
        return kupacRepository.findAllByNaziv_kupca(naziv_kupca);
    }

    @Transactional
    public Kupac insert(Kupac kupac){
        return kupacRepository.save(kupac);
    }

    @Transactional
    public Kupac update(Kupac kupac){
        return kupacRepository.save(kupac);
    }

    @Transactional
    public void deleteById(Long pib){
        kupacRepository.deleteById(pib);
    }
}
