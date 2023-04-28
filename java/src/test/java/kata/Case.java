package kata;

import java.util.function.Predicate;

class Case {

    public final int number;
    public final String result;

    public Case(int number, String result) {

        this.number = number;
        this.result = result;
    }

    public static Predicate<Case> appliesTo(int input) {
        return c -> input % c.number == 0;
    }

    public String getResult() {
        return result;
    }
}
