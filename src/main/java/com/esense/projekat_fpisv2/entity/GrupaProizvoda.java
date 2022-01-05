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
@Entity(name = "grupaproizvoda")
@Table(name = "grupaproizvoda", schema = "fpis")
public class GrupaProizvoda {

    @Id
    @Column(name = "grupa_ID")
    private String grupaID;

    @NonNull
    @Column(name = "naziv_grupe")
    private String nazivGrupe;


}
