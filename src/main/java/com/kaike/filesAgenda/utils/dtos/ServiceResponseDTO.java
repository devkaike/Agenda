package com.kaike.filesAgenda.utils.dtos;

public record ServiceResponseDTO<Type>(int status, Type message) {
    
}
