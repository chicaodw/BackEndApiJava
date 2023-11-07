package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Location
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LocationDto(
                StreetDto street,
                String city,
                String state,
                String country,
                String postcode,
                CoordinatesDto coordinates,
                TimezoneDto timezone) {
}