package com.esense.projekat_fpisv2.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "fabrika")
@Table(name = "fabrika")
public class Fabrika {

    @Id
    @Column(name = "fabrikaID")
    private String fabrikaID;

    @NonNull
    @Column(name = "naziv_fabrike")
    private String nazivFabrike;

}
