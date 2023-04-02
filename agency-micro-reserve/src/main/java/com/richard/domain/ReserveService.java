package com.richard.domain;

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
    public ReserveEntity create(Long codeCustomer) {
        LOGGER.info("INIT create id cutomer {}" + codeCustomer);

        ReserveEntity reserveEntity = new ReserveEntity();
        reserveEntity.setcodeCustomer(codeCustomer);
        reserveEntity.persist();

        LOGGER.info("END created reserveEntity {}" + reserveEntity);
        return reserveEntity;
    }

    @Transactional
    public void deleteById(long id) {
        ReserveEntity.deleteById(id);
    }

    public ReserveEntity findById(long id) {
        return ReserveEntity.findById(id);
    }

}
