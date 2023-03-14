package bg.softuni.moneyApp.web;

import bg.softuni.moneyApp.model.dto.UserRegisterDTO;
import bg.softuni.moneyApp.service.UserService;
import bg.softuni.moneyApp.utils.RegistrationResponse;
import jakarta.validation.Valid;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
     public ResponseEntity<RegistrationResponse> registerUser(@Valid @RequestBody
                                                             UserRegisterDTO userRegisterDTO,
                                                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            bindingResult.getFieldErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .forEach(errorMessages::add);

            return ResponseEntity
                    .badRequest()
                    .body(new RegistrationResponse("Invalid input fields",
                                                            errorMessages,
                                                            userRegisterDTO));
        }

        this.userService.createUser(userRegisterDTO);

        return ResponseEntity.ok(new RegistrationResponse("Registration successful"));


    }

}
