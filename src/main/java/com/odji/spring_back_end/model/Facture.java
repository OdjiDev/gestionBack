package com.odji.spring_back_end.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.mapping.List;
import java.util.List;
import java.util.Date;


@Data
@Builder
@Entity
@Table(name = "facture")
@AllArgsConstructor
@NoArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", unique = true)
    private Integer numero;

    @Column(name = "code")
    private String code;

//    @Column(name = "datecommande")
//    @Temporal(TemporalType.DATE)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private String datecommande;

    @Column(name = "total")
    private Number total;

    @ManyToOne
    @JoinColumn(name = "idfournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "facture")
    private List<LigneFacture> lignefacture;



}
