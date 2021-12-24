package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.Kupac;
import com.esense.projekat_fpisv2.entity.Ulica;
import com.esense.projekat_fpisv2.entity.UlicaIDembeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UlicaRepository extends JpaRepository<Ulica, UlicaIDembeddable> {

    @Query("SELECT u FROM Ulica u WHERE u.id.postanski_broj=?1")
    public List<Ulica> findAll(Long postanski_broj);
}
