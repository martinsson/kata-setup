package inheritance;

import composition.BestValueMenu;

public class GourmetsMenu extends BestValueMenu {
    @Override
    public String dessert() {
        return "crème caramel";
    }
}
