package com.esense.projekat_fpisv2.repository;


import com.esense.projekat_fpisv2.entity.Faktura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura,Long> {
}
