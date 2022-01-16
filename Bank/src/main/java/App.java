


public class App {
    public static void main(String[] args) {

        Menu menu = new Menu();

        while(true){
            switch(menu.publicMenu()){
                case 1:
                    menu.enterMenu();
                    break;

                case 2:
                    System.out.println("Have a nice day!");
                    break;

                case 0:
                    System.out.println("you enter a wrong number!");
            }
        }
    }






}
