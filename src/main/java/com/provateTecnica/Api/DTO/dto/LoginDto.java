package com.provateTecnica.Api.DTO.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Login
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LoginDto(
                String uuid,
                String username,
                String password,
                String salt,
                String md5,
                String sha1,
                String sha256) {
}