package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.entity.Grad;
import com.esense.projekat_fpisv2.repository.GradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GradService{

    private GradRepository gradRepository;

    @Autowired
    public GradService(GradRepository gradRepository) {
        this.gradRepository = gradRepository;
    }

    @Transactional
    public List<Grad> getAll(){
        return gradRepository.findAll();
    }

    @Transactional
    public Grad getById(Long id){
        return gradRepository.getById(id);
    }
}
