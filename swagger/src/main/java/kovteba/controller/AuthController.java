package kovteba.controller;

import kovteba.dto.Auth;
import kovteba.dto.UserNotFound;
import kovteba.repository.FakeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final FakeUserRepository fakeUserRepository;

    @PostMapping("")
    public ResponseEntity auth(@RequestBody Auth auth) {

        try {
            var byName = fakeUserRepository.getByName(auth.getName());
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("token", UUID.randomUUID().toString());

            return ResponseEntity.ok()
                                 .headers(responseHeaders)
                                 .body(byName);
        } catch (NoSuchElementException e) {

            return ResponseEntity.badRequest().body(new UserNotFound(e.getMessage()));
        }
    }
}
