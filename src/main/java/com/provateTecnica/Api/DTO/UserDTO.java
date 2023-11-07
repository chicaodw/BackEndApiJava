package com.provateTecnica.Api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.provateTecnica.Api.DTO.dto.DobDto;
import com.provateTecnica.Api.DTO.dto.IdDto;
import com.provateTecnica.Api.DTO.dto.LocationDto;
import com.provateTecnica.Api.DTO.dto.LoginDto;
import com.provateTecnica.Api.DTO.dto.NameDto;
import com.provateTecnica.Api.DTO.dto.PictureDto;
import com.provateTecnica.Api.DTO.dto.RegisteredDto;

/**
 * UserDTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDTO(
                String gender,
                NameDto name,
                LocationDto location,
                String email,
                LoginDto login,
                DobDto dob,
                RegisteredDto registered,
                String phone,
                String cell,
                IdDto id,
                PictureDto picture,
                String nat) {
}
