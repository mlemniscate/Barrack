package ir.maktab;
/*
* This class our barrack that we can call controlBarrack for start program and controlling barrack
* */
public class Barrack {
    private Officer[] officers;
    private Soldier[] soldiers;
    private String[] guns;
    private String[] activities = {
            "Show Soldiers",
            "Show Officers",
            "Show Guns",
            "Take Marksmanship Unit Exam",
            "Exit"
    };

    public Barrack(Officer[] officers, Soldier[] soldiers, String[] guns) {
        this.officers = officers;
        this.soldiers = soldiers;
        this.guns = guns;
    }

    // This method for start our program and start to controlling barrack.
    public void controlBarrack() {
        do{
            printMenu(activities);
        } while (doChoosenItem(getChoosenItem()) == 1);
    }

    // Do something that chosen from menu
    private int doChoosenItem(int item) {
        switch (item) {
            case 1:
                printSoldiers();
                break;
            case 2:
                printOfficers();
                break;
            case 3:
                printGuns();
                break;
            case 4:
                takeMarksmanshipUnitExam();
                break;
            case 5:
                return 0;
        }
        return 1;
    }

    // This method for print soldiers
    private void printSoldiers() {
        System.out.println("________________________________________");
        for (int i = 0; i < soldiers.length; i++) {
            String rank = soldiers[i].getRank() == 1 ? "Lieutenant" :
                    soldiers[i].getRank() == 2 ? "Sergent" : "Corporal";
            System.out.printf("%d. %s %s id: %d - rank: %s - shooting ability: %f%n",
                    (i+1),
                    soldiers[i].getFirstName(),
                    soldiers[i].getLastName(),
                    soldiers[i].getId(),
                    rank,
                    soldiers[i].getShootingAbility());
        }
        System.out.println("________________________________________");
    }

    // This method for print officers
    private void printGuns() {
        System.out.println("________________________________________");
        for (int i = 0; i < officers.length; i++) {
            System.out.printf("%d. %s%n",
                    (i+1),
                    guns[i]);
        }
        System.out.println("________________________________________");
    }

    // This method for print officers
    private void printOfficers() {
        System.out.println("________________________________________");
        for (int i = 0; i < officers.length; i++) {
            String rank = officers[i].getRank() == 1 ? "Colonel" :
                    officers[i].getRank() == 2 ? "Major" : "Lieutenant";
            System.out.printf("%d. %s %s id: %d - rank: %s%n",
                    (i+1),
                    officers[i].getFirstName(),
                    officers[i].getLastName(),
                    officers[i].getId(),
                    rank);
        }
        System.out.println("________________________________________");
    }

    // use this method for take a marksmanship exam from soldiers that you want with officer you choose
    private void takeMarksmanshipUnitExam() {
        Officer officer = chooseOfficer();
        new SoldiersMarksmanshipUnit(officer, soldiers, guns[0])
                .start();
    }

    // This method for choose an officer and return that Officer
    private Officer chooseOfficer() {
        printOfficers();
        return officers[
                (new Input("Enter your officer number: ",
                        officers.length, 1, null)
                        .getIntInputFromConsole()) - 1
                ];
    }

    // This method for choosing an item from menu items
    private int getChoosenItem() {
        return new Input("Enter your item number from menu: ",
                5, 1, null).getIntInputFromConsole();
    }

    // This method for show a menu and return the result of that
    private void printMenu(String[] menu) {
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %s%n",
                    (i+1),
                    menu[i]);
        }
        System.out.println("________________________________________");
    }
}
