package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProizvodRepository extends JpaRepository<Proizvod,Long> {
}
