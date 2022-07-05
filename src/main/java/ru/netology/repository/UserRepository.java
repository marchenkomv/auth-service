package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.types.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<String, String> users = new ConcurrentHashMap<>();
    private final Map<String, List<Authorities>> accessRights = new ConcurrentHashMap<>();

    public UserRepository() {
        users.put("admin", "1111");

        List<Authorities> authoritiesList = new ArrayList<>();
        authoritiesList.add(Authorities.READ);
        authoritiesList.add(Authorities.WRITE);
        authoritiesList.add(Authorities.DELETE);

        accessRights.put("admin", authoritiesList);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return users.get(user).equals(password) ? accessRights.get(user) : new ArrayList<>();
    }
}
