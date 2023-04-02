package com.richard.infrastructure.persistences;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = ReserveEntity.FIND_All_BY_CODE_CUSTOMER ,
                    query = "from ReserveEntity r where r.codeCustomer = ?1")
})
@Entity
@Table(name = "RESERVE")
public class ReserveEntity extends PanacheEntity {
    protected static final String FIND_All_BY_CODE_CUSTOMER = "ReserveEntity.findAllByCodeCustumer";
    @Column(name = "code_customer")
    public Long codeCustomer;

    public Long getcodeCustomer() {
        return codeCustomer;
    }
    public void setcodeCustomer(Long codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    /********* Queries *********/
    public static List<ReserveEntity> findAllByCodeCustomer(long code) {
        return find("#".concat(FIND_All_BY_CODE_CUSTOMER), code).list();
    }
}
