package com.richard.infrastructure.resources.mapper;


import com.richard.infrastructure.presistences.CustumerEntity;
import com.richard.infrastructure.resources.request.CustomerRequest;
import com.richard.infrastructure.resources.response.CustomerResponse;
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
