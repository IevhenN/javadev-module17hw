package home.hw.module17hw.sevice;

import home.hw.module17hw.model.User;
import home.hw.module17hw.model.request.UserRequest;
import home.hw.module17hw.repository.RoleRepository;
import home.hw.module17hw.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Transactional
    public String createUser(UserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            return "User with that name already exists";
        }

        User user = new User();
        System.out.println("userRequest.getUsername() = " + userRequest.getUsername());
        System.out.println("userRequest.getPassword() = " + userRequest.getPassword());
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        roleRepository.findByName("USER").ifPresent(user::addRole);

        userRepository.save(user);

        return "User created";
    }

    public User findByName(String username) {
        System.out.println("username = " + username);
        Optional<User> byUsername = userRepository.findByUsername(username);
        System.out.println("byUserName = " + byUsername);

        return byUsername.orElseThrow();
    }
}
