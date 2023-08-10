package kovteba.repository;

import kovteba.dto.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeUserRepository {

    private final List<User> list = new ArrayList<>();

    public FakeUserRepository() {
        list.add(new User("Dima", "ADMIN", "Kovteba"));
    }

    public User getByName(String name) {

        return list.stream()
                   .filter(user -> user.getName().equals(name))
                   .findFirst()
                   .orElseThrow();
    }

    public User getByROle(String role) {

        return list.stream()
                .filter(user -> user.getRole().equals(role))
                .findFirst()
                .orElseThrow();
    }
}
