package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.Adresa;
import com.esense.projekat_fpisv2.entity.Kupac;
import com.esense.projekat_fpisv2.entity.NacinPlacanja;
import com.esense.projekat_fpisv2.repository.NacinPlacanjaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NacinPlacanjaService {

    private NacinPlacanjaRepository nacinPlacanjaRepository;

    public NacinPlacanjaService(NacinPlacanjaRepository nacinPlacanjaRepository) {
        this.nacinPlacanjaRepository = nacinPlacanjaRepository;
    }

    @Transactional
    public List<NacinPlacanja> getAll(){ return nacinPlacanjaRepository.findAll(); }

    @Transactional
    public NacinPlacanja getOne(String id) throws Exception {

        Optional<NacinPlacanja> optionalNacinPlacanja = nacinPlacanjaRepository.findById(id);

        if(optionalNacinPlacanja.isPresent()) {
            NacinPlacanja nacinPl = optionalNacinPlacanja.get();
            return nacinPl;
        }else{
            throw new Exception("Trazeni nacin placanja ne postoji.");
        }
    }
}
