package com.richard.infrastructure.resource.mapper;

import com.richard.infrastructure.persistences.CustumerEntity;
import com.richard.infrastructure.resource.request.CustomerRequest;
import com.richard.infrastructure.resource.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {

    CustomerResponse toEntity(CustumerEntity client);
    List<CustomerResponse> toEntityList(List<CustumerEntity> clients);
    CustumerEntity toEntity(CustomerRequest customerRequest);
}
