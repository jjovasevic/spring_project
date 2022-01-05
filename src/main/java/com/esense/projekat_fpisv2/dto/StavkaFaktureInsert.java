package com.esense.projekat_fpisv2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StavkaFaktureInsert {

    private long sifraStavke;
    private String opis;
    private String ean;
    private int kolicina;
    private long sifraProizvoda;

}
