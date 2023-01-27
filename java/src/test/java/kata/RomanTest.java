package kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanTest {

    @Test
    void onetranslatetoI() {
        Assertions.assertEquals("I", RomanTranslator.translate(1));
    }


    @Test
    void twotranslatetoII() {
        Assertions.assertEquals("II", RomanTranslator.translate(2));
    }

    @Test
    void translate_three_III() {
        Assertions.assertEquals("III", RomanTranslator.translate(3));
    }


    @Test
    void translate_four_donneIV() {
        Assertions.assertEquals("IV",RomanTranslator.translate(4));
    }
    @Test
    void translate_five_donneV() {
        Assertions.assertEquals("V",RomanTranslator.translate(5));
    }

    @Test
    void translate_six_donneVI() {
        Assertions.assertEquals("VI",RomanTranslator.translate(6));
    }

    @Test
    void translate_seven_donneVII() {
        Assertions.assertEquals("VII",RomanTranslator.translate(7));
    }

    @Test
    void translate_nine_donneIX() {
        Assertions.assertEquals("IX",RomanTranslator.translate(9));
    }
    @Test
    void translate_zero_lanceException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> RomanTranslator.translate(0));
    }


}
