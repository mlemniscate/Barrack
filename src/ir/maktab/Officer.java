package ir.maktab;

public class Officer extends Military {
    public Officer(String firstName, String lastName, int id, int rank, int shootingAbility) {
        super(firstName, lastName, id, rank, true, shootingAbility);
    }

    // In this method officer write a SoldierResult based on soldiers shooting
    public SoldierResult takeMarksmanshipExam(Soldier soldier) {
        int[] scores = new int[soldier.getNumOfBullets()];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = soldier.shootInMarksmanshipUnit();
            if(scores[i] >= 5)
                soldier.setShootingAbility(soldier.getShootingAbility() + 0.01);
        }
        return new SoldierResult(this, soldier, scores);
    }

    // In this method officer give a new rank to soldiers based on SoldierResult
    public void changeSoldierRank(SoldierResult soldierResult) {
        int sumOfScores = 0;
        for (int i = 0; i < soldierResult.getScores().length; i++) {
            sumOfScores += soldierResult.getScores()[i];
        }
        int rank = soldierResult.getSoldier().getRank();
        soldierResult.setFinalScore(sumOfScores);
        soldierResult.setInitialRank(rank);
        // Check for soldiers final rank
        rank = sumOfScores < 28 && rank != 3 ? (rank+1) :
                sumOfScores >= 28 && rank != 1 ? (rank-1) : rank;
        soldierResult.setFinalRank(rank);
        soldierResult.getSoldier().setRank(rank);
    }
}
