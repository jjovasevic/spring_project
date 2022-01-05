package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.NacinPlacanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacinPlacanjaRepository extends JpaRepository<NacinPlacanja,String> {
}
