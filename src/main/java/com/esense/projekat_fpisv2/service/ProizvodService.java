package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.Proizvod;
import com.esense.projekat_fpisv2.repository.ProizvodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Proizvod getOne(Long id) throws Exception {
        Optional<Proizvod> optionalProizvod = proizvodRepository.findById(id);

        if(optionalProizvod.isPresent()){
            return optionalProizvod.get();
        }else{
            throw new Exception("Trazeni proizvod ne postoji.");
        }
    }

}
