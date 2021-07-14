package ir.maktab;

import java.util.Random;
/*
* A military is a man that serve in the army.
* */
public class Military {
    private String firstName;
    private String lastName;
    private int id;
    private int rank;
    private boolean isOfficer;
    private String gun;
    private int numOfBullets;
    private double shootingAbility;

    public Military(String firstName, String lastName, int id, int rank, boolean isOfficer, int shootingAbility) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.rank = rank;
        this.isOfficer = isOfficer;
        this.shootingAbility = shootingAbility;
    }

    public int shootInMarksmanshipUnit() {
        this.numOfBullets--;
        // (max - min + 1) + min
        return (int)(new Random().nextInt(11 - (int)shootingAbility) + shootingAbility);
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public void setNumOfBullets(int numOfBullets) {
        this.numOfBullets = numOfBullets;
    }

    public int getNumOfBullets() {
        return numOfBullets;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setShootingAbility(double shootingAbility) {
        this.shootingAbility = shootingAbility;
    }

    public double getShootingAbility() {
        return shootingAbility;
    }
}
