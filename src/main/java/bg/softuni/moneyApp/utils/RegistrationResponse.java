package bg.softuni.moneyApp.utils;

import bg.softuni.moneyApp.model.dto.UserRegisterDTO;

import java.util.ArrayList;
import java.util.List;

public class RegistrationResponse {

    private String message;
    private List<String> errors;
    private UserRegisterDTO userRegisterDTO;

    public RegistrationResponse(String message) {
        this.message = message;
        this.errors = new ArrayList<>();
    }

    public RegistrationResponse(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public RegistrationResponse(String message, List<String> errors, UserRegisterDTO userRegisterDTO) {
        this.message = message;
        this.errors = errors;
        this.userRegisterDTO = userRegisterDTO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

