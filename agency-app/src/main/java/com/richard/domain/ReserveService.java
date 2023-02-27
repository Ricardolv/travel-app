package com.richard.domain;

import com.richard.infrastructure.persistences.CustumerEntity;
import com.richard.infrastructure.persistences.ReserveEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ReserveService {
    protected static final Logger LOGGER = Logger.getLogger(ReserveService.class);

    public List<ReserveEntity> findAll() {
        return ReserveEntity.listAll();
    }

    @Transactional
    public ReserveEntity create(String nameCustomer) {

        LOGGER.info("INIT create name {}" + nameCustomer);

        ReserveEntity reserveEntity = new ReserveEntity();
        CustumerEntity custumerEntity = new CustumerEntity();
        custumerEntity.setName(nameCustomer);
        reserveEntity.setCustumerEntity(custumerEntity);
        reserveEntity.persist();

        LOGGER.info("END created reserveEntity {}" + reserveEntity);
        return reserveEntity;
    }
}
