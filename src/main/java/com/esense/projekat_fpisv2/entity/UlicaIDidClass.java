package com.esense.projekat_fpisv2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class UlicaIDidClass implements Serializable {

    private long postanski_broj;
    private String sifra_ulice;
}
