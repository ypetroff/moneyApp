package bg.softuni.moneyApp.service;

import bg.softuni.moneyApp.config.security.*;
import bg.softuni.moneyApp.model.dto.UserRegisterDTO;
import bg.softuni.moneyApp.model.entity.user.UserEntity;
import bg.softuni.moneyApp.model.entity.user.AppUser;
import bg.softuni.moneyApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        UserRegisterDTO user = UserRegisterDTO
                .builder()
                .firstName(request.getFirstName())
                .lastName((request.getLastName()))
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                //add role .role(Role.USER)..
                .build();


        userRepository.saveAndFlush(
                this.modelMapper.map(user, UserEntity.class)
        );

        var jwtToken = jwtService.generateToken(
                this.modelMapper.map(user, AppUser.class)
        );
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = this.userRepository.findByEmail(request.getEmail())
                .orElseThrow(); //add exception

        var jwtToken = jwtService.generateToken(
                this.modelMapper.map(user, AppUser.class)
        );
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
