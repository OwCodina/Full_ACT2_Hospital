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

    @PrePersist
    public void prePersist(){
        this.createAt = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updateAt = LocalDate.now();
    }
}
