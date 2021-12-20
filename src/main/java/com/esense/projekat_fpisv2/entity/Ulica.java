package com.esense.projekat_fpisv2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "ulica", schema = "fpis")
//@IdClass(UlicaIDidClass.class)
public class Ulica {

    //prvi nacin:
    //klasa postaje id
    @EmbeddedId
    private UlicaIDembeddable id;

    @ManyToOne // (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "postanski_broj", referencedColumnName = "postanski_broj",insertable = false, updatable = false)
    private Grad grad;

    @NonNull
    private String naziv_ulice;

    @JsonIgnore
    @OneToMany(mappedBy = "ulica", cascade = CascadeType.ALL)
    private List<Adresa> adrese = new ArrayList<>();

    public void dodajAdresu(Adresa adresa){

        if(adresa != null){
            if(adrese == null){
                adrese = new ArrayList<>();
            }

            adrese.add(adresa);
            adresa.setUlica(this);
        }
    }

    //kraj prvog nacina, drugacije je koristio joinColumn

    //drugi nacin
//    @Id
//    private String sifra_ulice;
//    @Id
//    private long postanski_broj;
    //kraj drugog nacina



}
