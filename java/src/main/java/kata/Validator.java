package kata;

import java.util.Optional;

interface Validator {

    Optional<String> validate(String password);

    final class LetterValidator implements Validator {

        @Override
        public Optional<String> validate(String password) {
            return containsLetter(password)
                    ? Optional.empty()
                    : Optional.of("Password must contain a letter");
        }


        private boolean containsLetter(String password) {
            return password.matches(".*[a-zA-Zéèêôà].*");
        }


    }

    class DigitValidator implements Validator {

        @Override
        public Optional<String> validate(String password) {
            return password.matches(".*\\d.*")
                    ? Optional.empty()
                    : Optional.of("Password needs to contain atleast one digit");
        }

    }

    class SpecialCharValidator implements Validator {

        @Override
        public Optional<String> validate(String password) {
            return containsSpecialCharacter(password)
                    ? Optional.empty()
                    : Optional.of("Password needs to contain atleast one special character");
        }

        private boolean containsSpecialCharacter(String password) {
            String nonWordCharacter = "\\W";
            return password.matches(".*" + nonWordCharacter + ".*");
        }


    }

    final class LengthValidator implements Validator {
        private final int length;

        public LengthValidator(int length) {
            this.length = length;
        }

        @Override
        public Optional<String> validate(String password) {
            return password.length() >= length
                    ? Optional.empty() :
                    Optional.of("Password needs to be " + length + " chars long");
        }
    }
}