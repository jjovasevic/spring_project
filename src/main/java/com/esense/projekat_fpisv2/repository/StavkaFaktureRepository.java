package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.StavkaFakture;
import com.esense.projekat_fpisv2.entity.StavkaFaktureIDembeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StavkaFaktureRepository extends JpaRepository<StavkaFakture, StavkaFaktureIDembeddable> {
}
