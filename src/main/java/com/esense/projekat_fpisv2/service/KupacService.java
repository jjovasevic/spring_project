package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.Kupac;
import com.esense.projekat_fpisv2.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public Kupac insert(Kupac kupac){
        return kupacRepository.save(kupac);
    }

//    public void delete(Kupac kupac){
//        kupacRepository.delete(kupac);
//    }
}
