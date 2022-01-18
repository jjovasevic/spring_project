package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.Adresa;
import com.esense.projekat_fpisv2.entity.AdresaIDembeddable;
import com.esense.projekat_fpisv2.entity.Ulica;
import com.esense.projekat_fpisv2.entity.UlicaIDembeddable;
import com.esense.projekat_fpisv2.repository.AdresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AdresaService {

    private AdresaRepository adresaRepository;

    @Autowired
    public AdresaService(AdresaRepository adresaRepository) {
        this.adresaRepository = adresaRepository;
    }

    @Transactional
    public List<Adresa> getAll(){
        return adresaRepository.findAll();
    }

    @Transactional
    public Optional<Adresa> getById(AdresaIDembeddable id){
        return adresaRepository.findById(id);
    }

    @Transactional
    public List<Adresa> getByForeignKey(Long grad, String ulica) {
        return adresaRepository.findAll(grad,ulica);
    }



}
