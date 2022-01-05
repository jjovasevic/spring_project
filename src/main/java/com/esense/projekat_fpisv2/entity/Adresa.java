package com.esense.projekat_fpisv2.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "adresa")
@Table(name = "adresa")
public class Adresa {

    @EmbeddedId
    private AdresaIDembeddable id;

    @ManyToOne
    @JoinColumns({
            //name predstavlja naziv kolone u tabeli adresa, a referencedColumnName predstavlja kolonu u tabeli ulica
            @JoinColumn(name = "postanski_broj",referencedColumnName = "postanski_broj",insertable = false, updatable = false),
            @JoinColumn(name = "sifra_ulice",referencedColumnName = "sifra_ulice",insertable = false, updatable = false)
    })
    private Ulica ulica;

    @NonNull
    private String broj_adrese;


}
