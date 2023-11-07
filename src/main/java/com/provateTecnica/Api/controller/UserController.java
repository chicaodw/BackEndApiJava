
package com.provateTecnica.Api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.provateTecnica.Api.model.UserModel;
import com.provateTecnica.Api.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserModel> getUsers(
            @RequestParam(defaultValue = "200") int results,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "1") int pageSize) {
        return userService.getUsers(results, page, pageSize);
    }

    @GetMapping("/users/idUser")
    public UserModel getUserById(@RequestParam("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/idUser/thumbnail")
    public ResponseEntity<String> getUserThumbnailBase64(@RequestParam("id") Long id) {
        String thumbnailBase64 = userService.getUserThumbnailBase64(id);
        if (thumbnailBase64 != null) {
            return ResponseEntity.ok(thumbnailBase64);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users/search/")
    public List<UserModel> getSearchUsers(@RequestParam("keyword") String keyword) {
        return userService.getSearchUserByKeyword(keyword);
    }

    @GetMapping("/users/statistics")
    public ResponseEntity<Map<String, Object>> getStatitics() {
        Map<String, Object> statistics = userService.calcStatistics();
        return ResponseEntity.ok(statistics);
    }

}
