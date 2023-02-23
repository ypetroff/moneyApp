package bg.softuni.moneyApp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    @NotEmpty
    private String password;

    @NotEmpty
    @Size(min = 5, max = 16)
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")
    private String email;

    @NotEmpty
    @Size(min = 4, max = 15)
    private String username;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;
}
