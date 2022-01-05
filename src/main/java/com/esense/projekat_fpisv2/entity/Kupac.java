package com.esense.projekat_fpisv2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "kupac")
public class Kupac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pib;

    @NonNull
    @Column(name = "naziv_kupca")
    private String naziv_kupca;

    @NonNull
    @Column(name = "email_kupca")
    private String email_kupca;

    @NonNull
    @Column(name = "telefon_kupca")
    private String telefon_kupca;

    @NonNull
    @Column(name = "potpis")
    private String potpis;

    @NonNull
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "adresa_ID",referencedColumnName = "adresa_ID"),
            @JoinColumn(name = "sifra_ulice",referencedColumnName = "sifra_ulice"),
            @JoinColumn(name = "postanski_broj",referencedColumnName = "postanski_broj")
    })
    private Adresa adresa;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jmbg")
    private Zaposleni zaposleni;

    public Kupac(String naziv_kupca, String email_kupca, String telefon_kupca, String potpis, Optional<Adresa> adresa, Zaposleni zaposleni) {
    }

}
