package com.esense.projekat_fpisv2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "faktura")
@Table(name = "faktura")
public class Faktura {

    @Id
    @Column(name = "sifra_fakture")
    private long sifraFakture;

    @NonNull
    @Column(name = "datum_prometa")
    private Date datumPrometa;

    @NonNull
    @Column(name = "valuta")
    private String valuta;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "npID", referencedColumnName = "npID",insertable = false, updatable = false)
    private NacinPlacanja nacinPlacanja;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "niID", referencedColumnName = "niID",insertable = false, updatable = false)
    private NacinIsporuke nacinIsporuke;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "jmbg", referencedColumnName = "jmbg",insertable = false, updatable = false)
    private Zaposleni zaposleni;

    @NonNull
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "postanski_broj", referencedColumnName = "postanski_broj"),
            @JoinColumn(name = "sifra_ulice", referencedColumnName = "sifra_ulice"),
            @JoinColumn(name = "adresa_ID", referencedColumnName = "adresa_ID")
    })
    private Adresa adresa;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faktura")
    private List<StavkaFakture> stavkeFakture = new ArrayList<>();

    public void dodajStavkuFakture(StavkaFakture stavka){

        if(stavka != null){
            if(stavkeFakture == null){
                stavkeFakture = new ArrayList<>();
            }

            stavkeFakture.add(stavka);
            stavka.setFaktura(this);
        }
    }








}
