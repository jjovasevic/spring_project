package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.Zaposleni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZaposleniRepository extends JpaRepository<Zaposleni, String> {
}
