package org.jpa.tp3.Cours ;

import jakarta.persistence.*;
import org.jpa.tp3.Modules.Module ;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String description;
    @ManyToOne
    private Module module;

    }