package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Id
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IdDto(String name, String value) {
}