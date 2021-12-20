package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

// @CrossOrigin("http://localhost:4200/")
@Repository
public interface KupacRepository extends JpaRepository<Kupac,Long> {
}
