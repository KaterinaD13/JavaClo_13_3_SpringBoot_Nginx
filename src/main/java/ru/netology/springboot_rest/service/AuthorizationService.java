package ru.netology.springboot_rest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.springboot_rest.exception.InvalidCredentials;
import ru.netology.springboot_rest.exception.UnauthorizedUser;
import ru.netology.springboot_rest.repository.UserRepository;
import ru.netology.springboot_rest.user.Authorities;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}