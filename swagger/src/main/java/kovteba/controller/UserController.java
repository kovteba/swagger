package kovteba.controller;

import kovteba.dto.User;
import kovteba.repository.FakeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final FakeUserRepository fakeUserRepository;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        return ResponseEntity.ok(user);
    }

    @GetMapping("/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name) {

        return ResponseEntity.ok(fakeUserRepository.getByName(name));
    }

    @GetMapping("/getBy")
    public ResponseEntity<User> getUser1(@RequestParam(name = "role") String userRole) {

        return ResponseEntity.ok(fakeUserRepository.getByROle(userRole));
    }

}
