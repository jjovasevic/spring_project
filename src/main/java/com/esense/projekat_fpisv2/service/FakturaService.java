package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.Faktura;
import com.esense.projekat_fpisv2.repository.FakturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FakturaService {

    private FakturaRepository fakturaRepository;

    @Autowired
    public FakturaService(FakturaRepository fakturaRepository) {
        this.fakturaRepository = fakturaRepository;
    }

    @Transactional
    public List<Faktura> getAll(){ return fakturaRepository.findAll(); }
}
