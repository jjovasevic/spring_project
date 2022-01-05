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
@Entity(name = "jedinicamere")
@Table(name = "jedinicamere")
public class JedinicaMere {

    @Id
    @Column(name = "jmid")
    private String jmid;

    @NonNull
    @Column(name = "naziv_jm")
    private String nazivJM;

}
