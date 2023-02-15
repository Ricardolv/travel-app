package com.richard.infrastructure.resource.mapper;

import com.richard.infrastructure.persistences.ClientEntity;
import com.richard.infrastructure.resource.request.ClientRequest;
import com.richard.infrastructure.resource.response.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClientMapper {

    ClientResponse toEntity(ClientEntity client);
    List<ClientResponse> toEntityList(List<ClientEntity> clients);
    ClientEntity toEntity(ClientRequest clientRequest);
}
