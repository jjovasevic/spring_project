package com.esense.projekat_fpisv2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class StavkaFaktureIDembeddable implements Serializable {

    @Column(name = "sifra_stavke")
    private long sifraStavke;

    @Column(name = "sifra_fakture")
    private long sifraFakture;
}
