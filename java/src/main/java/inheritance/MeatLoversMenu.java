package inheritance;

import composition.BestValueMenu;

public class MeatLoversMenu extends BestValueMenu {

    @Override
    public String mainCourse() {
        return "filet mignon";
    }
}
