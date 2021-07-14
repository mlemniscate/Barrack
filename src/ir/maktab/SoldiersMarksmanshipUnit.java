package ir.maktab;
/*
* SoldierMarksmanshipUnit is one of the Barrack units that an officer bring some soldiers to this unit and take a shooting exam.
* */
public class SoldiersMarksmanshipUnit {
    private Officer officer;
    private Soldier[] soldiers;
    private SoldierResult[] results;
    private String gun;
    private int numOfExams = 0;

    public SoldiersMarksmanshipUnit(Officer officer, Soldier[] soldiers, String gun) {
        this.officer = officer;
        this.soldiers = soldiers;
        this.gun = gun;
        results = new SoldierResult[soldiers.length];
    }

    // This method for start the exam
    public void start() {
        do {
            numOfExams++;
            giveEquipments(4);
            startShooting();
            checkSoldiersResults();
            printResults();
        } while (calculatePercentOfCorporals() >= 0.6);
        takeEquipments();
    }

    // This method for set guns and bullets to soldiers
    private void giveEquipments(int numOfBullets) {
        for (Soldier soldier : soldiers) {
            soldier.setGun(gun);
            soldier.setNumOfBullets(numOfBullets);
        }
    }

    // With this method we take all equipments from soldiers
    private void takeEquipments() {
        for (int i = 0; i < soldiers.length; i++) {
            soldiers[i].setGun("");
            soldiers[i].setNumOfBullets(0);
        }
    }

    // This method start taking exam from soldiers by officer
    private void startShooting() {
        for (int i = 0; i < soldiers.length; i++) {
            results[i] = officer.takeMarksmanshipExam(soldiers[i]);
        }
    }

    // This method for checking results of soldiers shooting and give them a new rank by officer
    private void checkSoldiersResults() {
        for (SoldierResult result : results) {
            officer.changeSoldierRank(result);
        }
    }

    // For calculate percents of Corporals in soldiers
    private double calculatePercentOfCorporals() {
        int sumOfCorporals = 0;
        for (SoldierResult result : results) {
            if (result.getSoldier().getRank() == 3) sumOfCorporals++;
        }
        return (double)sumOfCorporals / results.length;
    }

    // This method for printing results of soldiers in exam
    private void printResults() {
        System.out.printf("Shooting test %d by %s gun with officer %s %s id:%d%n" +
                        "_______________________________________%n",
                numOfExams, gun,
                officer.getFirstName(), officer.getLastName(), officer.getId());
        for (int i = 0; i < results.length; i++) {
            System.out.printf("%d. %s %s id: %d%n",
                    (i+1),
                    results[i].getSoldier().getFirstName(),
                    results[i].getSoldier().getLastName(),
                    results[i].getSoldier().getId());
            for (int j = 0; j < results[i].getScores().length; j++) {
                System.out.printf("Bullet %d: %d%n", (j + 1), results[i].getScores()[j]);
            }
            System.out.println("Final Score: " + results[i].getFinalScore());
            String rank = results[i].getInitialRank() == 1 ? "Lieutenant" :
                    results[i].getInitialRank() == 2 ? "Sergent" : "Corporal";
            System.out.println("Initial Rank: " + rank);
            rank = results[i].getFinalRank() == 1 ? "Lieutenant" :
                    results[i].getFinalRank() == 2 ? "Sergent" : "Corporal";
            System.out.println("Final Rank: " + rank);
            System.out.println("________________________________________");
        }
        System.out.printf("Shooting test %d result: %.2f%% of soldiers are Corporals.%n",
                numOfExams, calculatePercentOfCorporals() * 100);
        System.out.println("_____________________________________________________________________");
    }
}