package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Picture
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PictureDto(String large, String medium, String thumbnail) {
}