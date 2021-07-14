package ir.maktab;

public class Main {

    public static void main(String[] args) {
        Soldier[] soldiers = {
                new Soldier("Milad", "Abdi", 981001031, 3),
                new Soldier("Armin", "Bargi", 981001032, 3),
                new Soldier("Amin", "Tavakkoli", 981001033, 3),
                new Soldier("Alireza", "Dadkhah", 981001034, 3),
                new Soldier("MohammadAli", "Momen", 981001035, 3),
                new Soldier("Mohsen", "Asgari", 981001036, 3),
                new Soldier("Purya", "Hemmati", 981001037, 3),
                new Soldier("Mehdi", "Tavakkoli", 981001038, 3),
                new Soldier("Alireza", "Mohammadzadeh", 981001039, 3),
                new Soldier("Surush", "Faramarzi", 981001040, 3),
                new Soldier("Aziz", "Tarbiyat", 981001041, 3),
                new Soldier("Hosein", "Fazeli", 981001042, 3),
                new Soldier("Mohammad", "Alinejad", 981001043, 3),
                new Soldier("Keyvan", "Ganbari", 981001044, 3),
                new Soldier("Jamal", "Keyhani", 981001045, 3)};


        Officer[] officers = {new Officer("Ali", "Noori", 801001020, 1, 10),
                new Officer("Ahmad", "Nezami", 821001021, 2, 8),
                new Officer("Mehdi", "AlMohammad", 841001022, 3, 6)};
        String[] guns = {"HK-G3", "RPG-7", "AK-47"};
        Barrack barrack = new Barrack(officers, soldiers, guns);
        barrack.controlBarrack();
    }
}