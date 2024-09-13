package com.odji.spring_back_end.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "demande")
@AllArgsConstructor
@NoArgsConstructor
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "motif")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "idlignedemande")
    private  LigneDemande lignedemande;

    @ManyToOne
    @JoinColumn(name = "idbureau")
    private  Bureau bureau;

    @ManyToOne
    @JoinColumn(name = "idpersonel")
    private  Personel personel;

}
