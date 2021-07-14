package ir.maktab;

public class Soldier extends Military {
    public Soldier(String firstName, String lastName, int id, int rank) {
        super(firstName, lastName, id, rank, false, 0);
    }
}
