package com.odji.spring_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "facturereparer")
@AllArgsConstructor
@NoArgsConstructor
public class FactureReparer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;


    @Column(name = "date")
    private Instant date;

    @ManyToOne
    @JoinColumn(name = "idsociete")
    private Societe societe ;

    @OneToMany(mappedBy = "facturereparer")
    private List<LigneFactureReparer> lignefacturereparer;
}
