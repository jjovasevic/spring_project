package com.esense.projekat_fpisv2.dto;

import com.esense.projekat_fpisv2.entity.Adresa;
import com.esense.projekat_fpisv2.entity.Zaposleni;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KupacUpdateDTO {

    private long pib;

    private String naziv_kupca;

    private String email_kupca;

    private String telefon_kupca;

    private String potpis;

    private long postanski_broj;

    private String sifra_ulice;

    private long adresa_ID;

    private String jmbg;

}
