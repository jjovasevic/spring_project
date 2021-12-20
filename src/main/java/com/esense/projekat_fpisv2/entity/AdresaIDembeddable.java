package com.esense.projekat_fpisv2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Embeddable
public class AdresaIDembeddable implements Serializable {

    private long postanski_broj;
    @Column(length = 10)
    private String sifra_ulice;
    private long adresa_ID;
}
