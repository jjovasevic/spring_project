package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.Grad;
import com.esense.projekat_fpisv2.entity.Ulica;
import com.esense.projekat_fpisv2.entity.UlicaIDembeddable;
import com.esense.projekat_fpisv2.repository.UlicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UlicaService {

    private UlicaRepository ulicaRepository;

    @Autowired
    public UlicaService(UlicaRepository ulicaRepository) {
        this.ulicaRepository = ulicaRepository;
    }

    @Transactional
    public List<Ulica> getAll(){
        return ulicaRepository.findAll();
    }

    @Transactional
    public Ulica getById(UlicaIDembeddable sifra){
        return ulicaRepository.getById(sifra);
    }
}
