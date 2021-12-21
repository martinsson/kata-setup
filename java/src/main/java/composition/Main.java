package composition;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu(new Brownie(), new QuicheLorraine());
        printMenu(menu);
        Menu meatLoversMenu = new Menu(new Brownie(), new FiletMignon());
        printMenu(meatLoversMenu);
        Menu gourmetMenu = new Menu(new CremeCaramel(), new QuicheLorraine());
        printMenu(gourmetMenu);

        // new feature!!!
        Menu noGlutenMenu = new Menu(new CremeCaramel(), new FiletMignon());
        printMenu(noGlutenMenu);
    }

    private static void printMenu(Menu menu) {
        System.out.println("serving menu: " + menu.getClass().getSimpleName());
        System.out.println(menu.starter());
        System.out.println(menu.mainCourse());
        System.out.println(menu.dessert());
        System.out.println();
    }
}
