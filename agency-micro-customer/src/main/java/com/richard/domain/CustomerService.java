package com.richard.domain;


import com.richard.infrastructure.presistences.CustumerEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerService {
    protected static final Logger LOGGER = Logger.getLogger(CustomerService.class);


    public List<CustumerEntity> findAll() {
        return CustumerEntity.listAll();
    }

    public CustumerEntity findById(long id) {
        return CustumerEntity.findById(id);
    }

    @Transactional
    public void deleteById(long id) {
        CustumerEntity.deleteById(id);
    }

    @Transactional
    public CustumerEntity create(CustumerEntity custumerEntity) {
        LOGGER.info("INIT create custumerEntity {}" + custumerEntity);
        custumerEntity.persist();

        LOGGER.info("END created custumerEntity {}" + custumerEntity);
        return custumerEntity;
    }

}
