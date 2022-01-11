package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.StavkaFakture;
import com.esense.projekat_fpisv2.repository.StavkaFaktureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StavkaFaktureService {

    private StavkaFaktureRepository stavkaFaktureRepository;

    @Autowired
    public StavkaFaktureService(StavkaFaktureRepository stavkaFaktureRepository) {
        this.stavkaFaktureRepository = stavkaFaktureRepository;
    }

    @Transactional
    public List<StavkaFakture> getAll(){ return stavkaFaktureRepository.findAll(); }

    @Transactional
    public List<StavkaFakture> getAllByIdSifre(Long id){
        List<StavkaFakture> stavke = stavkaFaktureRepository.findBySifraFakture(id);
        if(stavke != null){
            return stavke;
        }else{
            return null;
        }
    }

    @Transactional
    public void deleteOne(Long idStavke, Long idFakture){ stavkaFaktureRepository.deleteById(idStavke,idFakture); }
}
