package kata;

import static org.junit.Assert.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class PasswordTest {
    private Password password = new Password();

    @Test public void 
    validates_length_letter_and_number() {
        assertThat(password.check("")).contains(
                "Password needs to be 7 chars long",
                "Password needs to contain atleast one digit",
                "Password must contain a letter");
    }
    
    @Test public void 
    passwords_are_valid_when_they_have_letter_number_and_are_atleast_7_chars_long() throws Exception {
        assertThat(password.check("helpme7")).isEmpty();
    }
    
    @Test public void 
    admins_validates_length_letter_and_number() throws Exception {
        assertThat(password.checkAdmin("")).contains(
                "Password needs to be 10 chars long",
                "Password needs to contain atleast one digit",
                "Password must contain a letter",
                "Password needs to contain atleast one special character");
    }

    @Test public void 
    admin_passwords_passes_when_they_have_everything() throws Exception {
    	assertThat(password.checkAdmin("10helpme..s")).isEmpty();
    }

}
