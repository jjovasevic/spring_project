package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.Adresa;
import com.esense.projekat_fpisv2.entity.AdresaIDembeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, AdresaIDembeddable> {

}
