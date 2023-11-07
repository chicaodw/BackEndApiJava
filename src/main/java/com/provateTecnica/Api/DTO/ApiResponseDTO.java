package com.provateTecnica.Api.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.provateTecnica.Api.DTO.dto.PageInfoDto;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseDTO {
    List<UserDTO> results;
    private PageInfoDto info;
}
