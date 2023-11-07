package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * InfoDTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PageInfoDto(String seed, int results, int page, String version) {
}
