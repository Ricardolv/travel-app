package com.richard.infrastructure.persistences;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = ReserveEntity.FIND_All_BY_CODE_CUSTOMER ,
                    query = "from ReserveEntity r where r.custumerEntity.id = ?1")
})
@Entity
@Table(name = "RESERVE")
public class ReserveEntity extends PanacheEntity {
    protected static final String FIND_All_BY_CODE_CUSTOMER = "ReserveEntity.findAllByCodeCustomer";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_customer")
    public CustumerEntity custumerEntity;

    public CustumerEntity getCustumerEntity() {
        return custumerEntity;
    }
    public void setCustumerEntity(CustumerEntity custumerEntity) {
        this.custumerEntity = custumerEntity;
    }

    /********* Queries *********/
    public static List<ReserveEntity> findAllByCodeCustomer(long code) {
        return find("#".concat(FIND_All_BY_CODE_CUSTOMER), code).list();
    }
}
