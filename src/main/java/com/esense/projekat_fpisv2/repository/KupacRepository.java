package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

// @CrossOrigin("http://localhost:4200/")
@Repository
public interface KupacRepository extends JpaRepository<Kupac,Long> {

    @Query("SELECT k FROM Kupac k WHERE k.naziv_kupca LIKE %?1%")
    public List<Kupac> findAllByNaziv_kupca(String naziv);

}
