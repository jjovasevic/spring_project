package com.esense.projekat_fpisv2.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KupacInsertDTO {

    // private long pib;

    private String naziv_kupca;

    private String email_kupca;

    private String telefon_kupca;

    private String potpis;

    private long postanski_broj;

    private String sifra_ulice;

    private long adresa_ID;

    private String jmbg;

//    private String naziv_grada;
//    private String naziv_ulice;
//    private long adresa_id;
//    private String ime_prezime;


}
