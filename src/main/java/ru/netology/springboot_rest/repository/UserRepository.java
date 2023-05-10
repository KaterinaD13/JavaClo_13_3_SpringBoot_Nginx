package ru.netology.springboot_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springboot_rest.user.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("User1") && password.equals("qwerty1")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("User2") && password.equals("qwerty2")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else if (user.equals("User3") && password.equals("qwerty3")) {
            Collections.addAll(authorities, Authorities.READ);
        }
        return authorities;
    }
}