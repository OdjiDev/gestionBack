package com.odji.spring_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "reparer")
@AllArgsConstructor
@NoArgsConstructor

public class Reparer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    private  String motif;

    @OneToMany(mappedBy = "reparer")
    private List<LigneReparation>ligneReparation ;

    @OneToMany(mappedBy = "reparer")
    private List<LigneFactureReparer>ligneFactureReparer;

}
