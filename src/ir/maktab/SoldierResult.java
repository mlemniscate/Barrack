package ir.maktab;
/*
* SoldierResult class like a paper that we write results of a soldier in a shooting test
* */
public class SoldierResult {
    private Officer officer;
    private Soldier soldier;
    private int[] scores;
    private int finalScore;
    private int initialRank;
    private int finalRank;

    public SoldierResult(Officer officer, Soldier soldier, int[] scores) {
        this.officer = officer;
        this.soldier = soldier;
        this.scores = scores;
    }

    public Officer getOfficer() {
        return officer;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public int[] getScores() {
        return scores;
    }

    public int getInitialRank() {
        return initialRank;
    }

    public void setInitialRank(int initialRank) {
        this.initialRank = initialRank;
    }

    public int getFinalRank() {
        return finalRank;
    }

    public void setFinalRank(int finalRank) {
        this.finalRank = finalRank;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }
}
