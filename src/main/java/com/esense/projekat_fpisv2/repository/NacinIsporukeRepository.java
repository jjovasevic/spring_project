package com.esense.projekat_fpisv2.repository;

import com.esense.projekat_fpisv2.entity.NacinIsporuke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacinIsporukeRepository extends JpaRepository<NacinIsporuke,String> {
}
