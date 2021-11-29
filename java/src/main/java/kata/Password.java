package kata;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import kata.Validator.DigitValidator;
import kata.Validator.LengthValidator;
import kata.Validator.LetterValidator;
import kata.Validator.SpecialCharValidator;

public class Password {
    private final List<Validator> userValidators = asList(
            new LengthValidator(7),
            new DigitValidator(),
            new LetterValidator());

    private final List<Validator> adminValidators = asList(
            new LengthValidator(10),
            new DigitValidator(),
            new LetterValidator(),
            new SpecialCharValidator());

    public List<String> check(String password) {
        return validate(password, userValidators);
    }

    public List<String> checkAdmin(String password) {
        return validate(password, adminValidators);
    }

    private List<String> validate(String password, List<Validator> validators) {

        return validators.stream()
                .flatMap(v -> v.validate(password).stream())
                .collect(Collectors.toList());
    }
}
