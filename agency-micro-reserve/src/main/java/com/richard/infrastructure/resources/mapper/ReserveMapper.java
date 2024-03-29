package com.richard.infrastructure.resources.mapper;

import com.richard.infrastructure.persistences.ReserveEntity;
import com.richard.infrastructure.resources.response.ReserveResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ReserveMapper {

    ReserveResponse toEntity(ReserveEntity reserve);

    List<ReserveResponse> toEntityList(List<ReserveEntity> reservations);
}
