package com.esense.projekat_fpisv2.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "stavkafakture")
@Table(name = "stavkafakture")
public class StavkaFakture {

    @EmbeddedId
    private StavkaFaktureIDembeddable id;

    @NonNull
    @Column(name = "opis")
    private String opis;

    @NonNull
    @Column(name = "EAN")
    private String EAN;

    @NonNull
    @Column(name = "kolicina")
    private int kolicina;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "sifra_proizvoda", referencedColumnName = "sifra_proizvoda",insertable = false, updatable = false)
    private Proizvod proizvod;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "sifra_fakture", referencedColumnName = "sifra_fakture",insertable = false, updatable = false)
    private Faktura faktura;

}
