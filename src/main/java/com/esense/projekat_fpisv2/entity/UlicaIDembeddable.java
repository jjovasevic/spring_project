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
public class UlicaIDembeddable implements Serializable {

    private long postanski_broj;
    @Column(length = 10)
    private String sifra_ulice;
}
