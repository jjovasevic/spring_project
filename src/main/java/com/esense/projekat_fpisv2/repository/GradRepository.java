package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.Grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradRepository extends JpaRepository<Grad,Long> {
}
