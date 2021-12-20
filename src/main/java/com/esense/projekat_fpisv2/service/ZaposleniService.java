package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.Ulica;
import com.esense.projekat_fpisv2.entity.UlicaIDembeddable;
import com.esense.projekat_fpisv2.entity.Zaposleni;
import com.esense.projekat_fpisv2.repository.ZaposleniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ZaposleniService {

    private ZaposleniRepository zaposleniRepository;

    @Autowired
    public ZaposleniService(ZaposleniRepository zaposleniRepository) {
        this.zaposleniRepository = zaposleniRepository;
    }

    @Transactional
    public List<Zaposleni> getAll(){
        return zaposleniRepository.findAll();
    }

    @Transactional
    public Zaposleni getById(String jmbg){
        return zaposleniRepository.getById(jmbg);
    }
}
