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
@Table(name = "grad", schema = "fpis")
public class Grad {

    @Id
    @Column(name = "postanski_broj")
    private long postanski_broj;

    @NonNull
    @Column(name = "naziv_grada")
    private String naziv_grada;

    @JsonIgnore
    @OneToMany(mappedBy = "grad", cascade = CascadeType.ALL)
    private List<Ulica> ulice = new ArrayList<>();

    public void dodajUlicu(Ulica ulica){

        if(ulica != null){

            if(ulice == null){
                ulice = new ArrayList<>();
            }

            ulice.add(ulica);
            ulica.setGrad(this);
        }
    }



}
