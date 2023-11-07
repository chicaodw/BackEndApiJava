package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dob
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DobDto(String date, int age) {
}
