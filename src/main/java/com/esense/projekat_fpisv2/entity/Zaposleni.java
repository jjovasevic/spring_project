package com.esense.projekat_fpisv2.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "zaposleni", schema = "fpis")
public class Zaposleni {

    @Id
    @Column(name = "jmbg")
    private String jmbg;

    @NonNull
    @Column(name = "ime_prezime")
    private String ime_prezime;
}
