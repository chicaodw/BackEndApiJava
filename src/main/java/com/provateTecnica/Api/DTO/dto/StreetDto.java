package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Street
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record StreetDto(
        int number,
        String name) {
}