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
@Entity(name = "nacinisporuke")
@Table(name = "nacinisporuke", schema = "fpis")
public class NacinIsporuke {

    @Id
    @Column(name = "niID")
    private String niID;

    @NonNull
    @Column(name = "nacin_isporuke")
    private String nazivIsporuke;


}
