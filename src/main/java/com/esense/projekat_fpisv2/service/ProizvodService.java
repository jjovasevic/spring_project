package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.Proizvod;
import com.esense.projekat_fpisv2.repository.ProizvodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProizvodService{

    private ProizvodRepository proizvodRepository;

    @Autowired
    public ProizvodService(ProizvodRepository proizvodRepository) {
        this.proizvodRepository = proizvodRepository;
    }

    @Transactional
    public List<Proizvod> getAll(){
        return proizvodRepository.findAll();
    }
}
