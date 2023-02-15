package com.richard.domain;

import com.richard.infrastructure.persistences.ClientEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClientService {

    public List<ClientEntity> findAll() {
        return ClientEntity.listAll();
    }

    public ClientEntity findById(long id) {
        return ClientEntity.findById(id);
    }

    @Transactional
    public void deleteById(long id) {
        ClientEntity.deleteById(id);
    }

    @Transactional
    public ClientEntity create(ClientEntity clientEntity) {
        clientEntity.persist();
        return clientEntity;
    }

}
