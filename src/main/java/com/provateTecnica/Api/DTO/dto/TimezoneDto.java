package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Timezone
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TimezoneDto(
        String offset,
        String description) {
}
