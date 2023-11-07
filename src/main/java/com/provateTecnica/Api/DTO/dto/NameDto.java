package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NameDto(
        String title,
        String first,
        String last) {
}