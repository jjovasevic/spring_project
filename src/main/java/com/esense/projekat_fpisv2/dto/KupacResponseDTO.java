package com.esense.projekat_fpisv2.dto;

import com.esense.projekat_fpisv2.entity.Adresa;
import com.esense.projekat_fpisv2.entity.Zaposleni;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KupacResponseDTO {

    private long pib;

    private String naziv_kupca;

    private String email_kupca;

    private String telefon_kupca;

    private String potpis;

    private Adresa adresa;

    private Zaposleni zaposleni;

}
