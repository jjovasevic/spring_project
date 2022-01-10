package com.esense.projekat_fpisv2.repository;


import com.esense.projekat_fpisv2.entity.Faktura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura,Long> {

    @Query("SELECT f FROM faktura f WHERE f.valuta LIKE %?1%")
    public List<Faktura> findAllByValuta(String valuta);



}
