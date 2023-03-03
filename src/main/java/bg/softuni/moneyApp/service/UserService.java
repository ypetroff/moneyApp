package bg.softuni.moneyApp.service;

import bg.softuni.moneyApp.model.dto.UserRegisterDTO;
import bg.softuni.moneyApp.model.entity.UserEntity;
import bg.softuni.moneyApp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

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
