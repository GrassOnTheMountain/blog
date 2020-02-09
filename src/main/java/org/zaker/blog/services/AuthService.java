package org.zaker.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.zaker.blog.entity.User;

import java.util.Optional;

@Service
public class AuthService {
    private final UserService userService;

    @Autowired
    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(userService.getUserByUserName(authentication == null ? null : authentication.getName()));
    }
}
