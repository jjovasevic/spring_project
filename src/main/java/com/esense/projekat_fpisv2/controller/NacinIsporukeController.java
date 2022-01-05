package com.esense.projekat_fpisv2.controller;

import com.esense.projekat_fpisv2.entity.NacinIsporuke;
import com.esense.projekat_fpisv2.service.NacinIsporukeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("nacinIsporuke")
@CrossOrigin("http://localhost:4200/")
@RestController
public class NacinIsporukeController {

    private NacinIsporukeService nacinIsporukeService;

    public NacinIsporukeController(NacinIsporukeService nacinIsporukeService) {
        this.nacinIsporukeService = nacinIsporukeService;
    }

    @GetMapping
    public List<NacinIsporuke> vratiSveNacineIsporuke(){return nacinIsporukeService.getAll(); }

    @GetMapping("/{id}")
    public NacinIsporuke vratiNacinIsporuke(@PathVariable String id){
        try {
            return nacinIsporukeService.getOne(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
