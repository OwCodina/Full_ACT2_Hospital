package com.hospitalVM.atenciones.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Audit {

    @Column(name = "created_at")
    private LocalDate createAt;

    @Column(name = "updated_at")
    private LocalDate updateAt;


    /**
     * Con este método genero autmaticamente la fecha de creacion de algún
     * elemento
     */
    @PrePersist
    public void prePersist(){
        this.createAt = LocalDate.now();
    }

    /**
     * Con este método genero automaticamente la fecha de la última modificación
     */
    @PreUpdate
    public void preUpdate(){
        this.updateAt = LocalDate.now();
    }
}
