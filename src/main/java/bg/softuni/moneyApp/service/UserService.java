package bg.softuni.moneyApp.service;

import bg.softuni.moneyApp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private boolean isUsernameTaken(String username) {
        return this.userRepository.findByUsername(username).isPresent();
    }
}
