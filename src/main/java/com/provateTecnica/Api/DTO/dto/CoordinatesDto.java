package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Coordinates
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CoordinatesDto(
        String latitude,
        String longitude) {
}
