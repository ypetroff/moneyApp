package bg.softuni.moneyApp.service;

import bg.softuni.moneyApp.model.entity.UserRoleEntity;
import bg.softuni.moneyApp.model.enums.UserRole;
import bg.softuni.moneyApp.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    public UserRoleService(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initRole() {
        if(this.userRoleRepository.count() == 0) {
            this.userRoleRepository.saveAllAndFlush(
                    Arrays.stream(UserRole.values())
                            .map(value -> this.modelMapper.map(value, UserRoleEntity.class))
                            .toList()
            );
        }
    }
}
