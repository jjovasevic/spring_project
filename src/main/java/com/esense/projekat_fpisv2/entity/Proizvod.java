package com.esense.projekat_fpisv2.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "proizvod")
@Table(name = "proizvod", schema = "fpis")
public class Proizvod {

    @Id
    @Column(name = "sifra_proizvoda")
    private long sifraProizvoda;

    @NonNull
    @Column(name = "naziv_proizvoda")
    private String nazivProizvoda;

    @NonNull
    @Column(name = "cena_proizvoda")
    private double cenaProizvoda;

    @ManyToOne
    @JoinColumn(name = "jmid", referencedColumnName = "jmid",insertable = false, updatable = false)
    private JedinicaMere jedinicaMere;

    @ManyToOne
    @JoinColumn(name = "fabrikaID", referencedColumnName = "fabrikaID",insertable = false, updatable = false)
    private Fabrika fabrika;

    @ManyToOne
    @JoinColumn(name = "grupa_ID", referencedColumnName = "grupa_ID",insertable = false, updatable = false)
    private GrupaProizvoda grupaProizvoda;



}
