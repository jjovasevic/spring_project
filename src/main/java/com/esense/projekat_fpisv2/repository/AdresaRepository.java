package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.Adresa;
import com.esense.projekat_fpisv2.entity.AdresaIDembeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, AdresaIDembeddable> {
//    @Query("SELECT new com.esense.projekat_fpisv2.entity.Adresa(a.id.adresa_ID,a.id.sifra_ulice,a.id.postanski_broj) FROM adresa a WHERE a.id.adresa_ID=?1 AND a.id.sifra_ulice=?2 AND a.id.postanski_broj=?3")
//    public Adresa getAdressById(Long adresa_id, String sifra_ulice, Long postanski_broj);


}
