package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.NacinIsporuke;
import com.esense.projekat_fpisv2.repository.NacinIsporukeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NacinIsporukeService {

    private NacinIsporukeRepository nacinIsporukeRepository;

    public NacinIsporukeService(NacinIsporukeRepository nacinIsporukeRepository) {
        this.nacinIsporukeRepository = nacinIsporukeRepository;
    }

    @Transactional
    public List<NacinIsporuke> getAll(){ return nacinIsporukeRepository.findAll(); }

    @Transactional
    public NacinIsporuke getOne(String id) throws Exception {
        Optional<NacinIsporuke> optionalNacinIsporuke = nacinIsporukeRepository.findById(id);

        if(optionalNacinIsporuke.isPresent()){
            return optionalNacinIsporuke.get();
        }else{
            throw new Exception("Trazeni nacin isporuke ne postoji.");
        }
    }


}
