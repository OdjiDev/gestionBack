package com.odji.spring_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "signaler")
@AllArgsConstructor
@NoArgsConstructor

public class Signaler {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String etat;

   @ManyToOne
   @JoinColumn(name = "idproduit")
   private Produit produit;

   @ManyToOne
   @JoinColumn(name = "idpersonel")
   private Personel personel;
}
