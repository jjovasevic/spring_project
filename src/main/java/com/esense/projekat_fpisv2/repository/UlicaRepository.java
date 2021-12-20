package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.Ulica;
import com.esense.projekat_fpisv2.entity.UlicaIDembeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UlicaRepository extends JpaRepository<Ulica, UlicaIDembeddable> {
}
