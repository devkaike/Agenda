package com.kaike.filesAgenda.login.dto;

public record LoginResponse(String AccessToken, Long expiresIn, Long id, String nome) {
}