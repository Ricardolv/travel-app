package com.richard.infrastructure.resource.mapper;

import com.richard.infrastructure.persistences.ReserveEntity;
import com.richard.infrastructure.resource.response.ReserveResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ReserveMapper {

    @Mapping(source = "custumerEntity", target = "customerResponse")
    ReserveResponse toEntity(ReserveEntity reserve);


    List<ReserveResponse> toEntityList(List<ReserveEntity> reservations);
}
