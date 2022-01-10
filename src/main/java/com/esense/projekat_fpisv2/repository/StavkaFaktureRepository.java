package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.Kupac;
import com.esense.projekat_fpisv2.entity.StavkaFakture;
import com.esense.projekat_fpisv2.entity.StavkaFaktureIDembeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StavkaFaktureRepository extends JpaRepository<StavkaFakture, StavkaFaktureIDembeddable> {

    @Query("SELECT sf FROM stavkafakture sf WHERE sf.id.sifraFakture = ?1")
    public List<StavkaFakture> findBySifraFakture(Long sifraFakture);

    @Modifying
    @Query("DELETE FROM stavkafakture sf WHERE sf.id.sifraStavke = ?1 AND sf.id.sifraFakture = ?2")
    public void deleteById(Long idStavke, Long idFakture);
}
