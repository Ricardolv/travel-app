package com.richard.infrastructure.persistences;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVE")
public class ReserveEntity extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    public CustumerEntity custumerEntity;

    public CustumerEntity getCustumerEntity() {
        return custumerEntity;
    }

    public void setCustumerEntity(CustumerEntity custumerEntity) {
        this.custumerEntity = custumerEntity;
    }
}
