package bg.softuni.moneyApp.service;

import bg.softuni.moneyApp.model.dto.UserRegisterDTO;
import bg.softuni.moneyApp.model.entity.UserEntity;
import bg.softuni.moneyApp.model.enums.UserRole;
import bg.softuni.moneyApp.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class UserService {

    private static final String DEFAULT_PASSWORD = "12345";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @PostConstruct
    private void initDB() {

        if(this.userRepository.count() == 0) {
            UserRegisterDTO admin = initUser("admin");
            UserRegisterDTO user = initUser("user");

            this.userRepository.saveAllAndFlush(
                    Stream.of(admin, user)
                            .map(dto -> this.modelMapper.map(dto, UserEntity.class))
                            .toList());
        }
    }

    private UserRegisterDTO initUser(String role) {
        return UserRegisterDTO.builder()
                .username(role)
                .password(DEFAULT_PASSWORD)
                .firstName("firstName")
                .lastName("lastName")
                .email(role + "@example.com")
                .build();
    }

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public boolean isUsernameFreeToUse(String username) {
        return this.userRepository.findByUsername(username).isEmpty();
    }

    public boolean isEmailFreeToUse(String email) {
        return this.userRepository.findByEmail(email).isEmpty();
    }

    public void createUser(UserRegisterDTO userRegisterDTO) {
        this.userRepository.saveAndFlush(
                this.modelMapper.map(userRegisterDTO, UserEntity.class)
        );
    }
}
