package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Registered
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RegisteredDto(
        String date,
        int age) {
}