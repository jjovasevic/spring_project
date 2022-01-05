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
@Entity(name = "nacinplacanja")
@Table(name = "nacinplacanja")
public class NacinPlacanja {

    @Id
    @Column(name = "npID")
    private String npID;

    @NonNull
    @Column(name = "nacin_placanja")
    private String nacinPlacanja;

}
