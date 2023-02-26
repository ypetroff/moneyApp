package bg.softuni.moneyApp.model.dto;

import bg.softuni.moneyApp.validations.matchingPasswordAndConfirmPassword.MatchingPasswordAndConfirmPassword;
import bg.softuni.moneyApp.validations.uniqueUsername.UniqueUsername;
import bg.softuni.moneyApp.validations.uniqueEmail.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MatchingPasswordAndConfirmPassword
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {

    @UniqueEmail
    @NotEmpty
    @Size(min = 3, message = "Password should be at least 3 characters long")
    private String password;

    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    @Size(min = 5, message = "Email should be at least 5 characters long")
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$", message = "Enter valid email address")
    private String email;

    @UniqueUsername
    @NotEmpty
    @Size(min = 4, max = 15, message = "Username should be between 4 and 15 characters long")
    private String username;

    @NotEmpty
    @Size(min = 3, max = 15, message = "First name should be between 4 and 15 characters long")
    private String firstName;

    @NotEmpty
    @Size(min = 3, max = 15, message = "Last name should be between 4 and 15 characters long")
    private String lastName;
}
