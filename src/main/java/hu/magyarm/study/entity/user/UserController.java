package hu.magyarm.study.entity.user;

import com.auth0.jwt.JWT;
import hu.magyarm.study.security.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static hu.magyarm.study.security.SecurityConstants.*;

@RestController
@RequestMapping("/users")
public class
UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ApplicationUserMapper applicationUserMapper;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRegistrationDate(new Date());
        applicationUserRepository.save(user);
    }

    @GetMapping("/{email}")
    public ApplicationUserDto getUserByEmail(@PathVariable("email") String email) {
        return applicationUserMapper.applicationUserToApplicationUserDto(applicationUserRepository.findByEmail(email));
    }

    @DeleteMapping
    public void deleteUser() {
        ApplicationUser user = applicationUserRepository.findByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName());
        applicationUserRepository.delete(user);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody ApplicationUser user) {
        ApplicationUser currentUser = applicationUserRepository.findByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName());
        user.setId(currentUser.getId());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_STRING, TOKEN_PREFIX + JWTAuthenticationFilter.createJWTToker(user.getEmail()));
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}