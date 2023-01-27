package kata;

public class RomanTranslator {
    public static String translate(int nb) {
        if (nb < 1){
            throw new IllegalArgumentException();
        }
        if (nb == 4) {
            return "IV";
        }

        if(nb == 9){
            return "IX";
        }

        if (nb >= 5) {
            return "V" +  "I".repeat(nb-5);
        }

        return "I".repeat(nb);

    }
}
