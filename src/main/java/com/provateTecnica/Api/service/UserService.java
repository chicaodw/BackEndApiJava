package com.provateTecnica.Api.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.provateTecnica.Api.DTO.ApiResponseDTO;
import com.provateTecnica.Api.DTO.UserDTO;
import com.provateTecnica.Api.exception.CustomException;
import com.provateTecnica.Api.model.UserModel;
import com.provateTecnica.Api.util.CellFormatUtil;
import com.provateTecnica.Api.util.DataUlti;
import com.provateTecnica.Api.util.StatisticsUtil;

@Service
public class UserService {

    @Value("${api.url}")
    private String URL_EXTERNA;

    private final List<UserModel> users = new ArrayList<>();
    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "userCache", key = "'users:' + #page + ':' + #pageSize")
    public List<UserModel> getUsers(int results, int page, int pageSize) {

        if (users.isEmpty()) {
            String apiUrl = URL_EXTERNA + String.format("/?results=%d&page=%d",
                    results, page);
            ApiResponseDTO apiResponseDTO = restTemplate.getForObject(apiUrl,
                    ApiResponseDTO.class);

            if (apiResponseDTO != null && apiResponseDTO.getResults() != null) {
                users.addAll(apiResponseDTO.getResults()
                        .stream()
                        .map(this::mapToUser)
                        .collect(Collectors.toList()));

            }
        }

        int totalResults = users.size();
        int totalPages = (int) Math.ceil((double) results / pageSize);
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + totalPages, totalResults);

        if (startIndex < totalResults) {
            return users.subList(startIndex, endIndex);
        } else {
            return Collections.emptyList();
        }

    }

    private UserModel mapToUser(UserDTO userDto) {
        UserModel user = new UserModel();
        user.setGender(userDto.gender());
        user.setName(userDto.name().first());
        user.setLast_name(userDto.name().last());
        user.setCity(userDto.location().city());
        user.setState(userDto.location().state());
        user.setCountry(userDto.location().country());
        user.setEmail(userDto.email());
        user.setBirthday(DataUlti.formatDateString(userDto.dob().date()));
        user.setCell(CellFormatUtil.formatCell(userDto.cell()));
        user.setThumbnail(userDto.picture().thumbnail());
        return user;
    }

    public UserModel getUserById(long id) {

        for (UserModel user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public String getUserThumbnailBase64(long id) {
        UserModel user = getUserById(id);
        if (user != null) {
            try {
                URL url = new URL(user.getThumbnail());
                InputStream inputStream = url.openStream();
                byte[] bytes = IOUtils.toByteArray(inputStream);
                return Base64.getEncoder().encodeToString(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<UserModel> getSearchUserByKeyword(String keyword) {
        if (keyword.length() < 3 && keyword.length() > 63) {
            throw new CustomException(
                    "A pesquisa deve conter no minimo 3 caracteres");
        } else if (keyword.matches(".*\\d.*")) {
            throw new CustomException(
                    "Você deve informar apenas letras");
        }

        List<UserModel> filter = new ArrayList<>();

        for (UserModel user : users) {
            if (user.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    user.getLast_name().toLowerCase().contains(keyword.toLowerCase()) ||
                    user.getCity().toLowerCase().contains(keyword.toLowerCase()) ||
                    user.getState().toLowerCase().contains(keyword.toLowerCase()) ||
                    user.getCountry().toLowerCase().contains(keyword.toLowerCase()) ||
                    user.getEmail().toLowerCase().contains(keyword.toLowerCase())) {

                filter.add(user);

            }
        }

        if (filter.isEmpty()) {
            throw new CustomException(
                    "Nenhum usuário encontrato!");
        }
        return filter;

    }

    public Map<String, Object> calcStatistics() {
        Map<String, Integer> genderCount = new HashMap<>();
        Map<String, Integer> countryCount = new HashMap<>();
        Map<String, Integer> ageRenderCount = new HashMap<>();

        for (UserModel user : users) {
            // Count Gender
            genderCount.put(user.getGender(), genderCount.getOrDefault(user.getGender(), 0) + 1);

            // Count Country
            countryCount.put(user.getCountry(), countryCount.getOrDefault(user.getCountry(), 0) + 1);

            // calc age
            int age = StatisticsUtil.calculateAge(user.getBirthday());
            String ageRange = StatisticsUtil.determineAgeRange(age);
            ageRenderCount.put(ageRange, ageRenderCount.getOrDefault(ageRange, 0) + 1);
        }

        Map<String, Object> statistics = new LinkedHashMap<>();
        statistics.put("genders", genderCount);
        statistics.put("age_range", ageRenderCount);
        statistics.put("countries", countryCount);

        return statistics;

    }

}
