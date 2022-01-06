package com.esense.projekat_fpisv2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FakturaInsert {

    private long sifraFakture;

    private Date datumPrometa;
    private String valuta;
    private String npID;
    private String niID;
    private String jmbg;
    private long postanskiBroj;
    private String sifraUlice;
    private long adresaID;



}
