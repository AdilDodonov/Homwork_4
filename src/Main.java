import java.util.Random;

public class Main {

    public static int bossHilth = 200000;
    public static int bossDamage = 50;
    public static String bossDefenceType;

    public static int[] heroHilth = {60, 300, 400, 500, 400, 200, 250, 350};
    public static int[] heroDamage = {20, 15, 30, 20, 40, 20, 25, 35};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medik", "berserk", "Thor", "Lucky", "Golem"};

    public static int roundNumber;

    public static void main(String[] args) {

        printStatic();


        while (!isGameFinished()){
            raund();
        }


    }

    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length); // 0,1,2
        bossDefenceType = heroesAttackType[randomIndex];
        System.out.println("Boss choose " + bossDefenceType);
    }


    public static void raund() {
        roundNumber++;
        chooseBossDefence();
        bossHilth();
        herousHit();
        berserkShoot();
        stan();
        printStatic();
        medicHilth();
        evasionl();
        golem();
    }

    public static void medicHilth() {
        for (int i = 0; i < heroHilth.length; i++) {
            if (i == 3) {
                continue;
            }
            if (heroHilth[i] > 0 && heroHilth[i] < 200 && heroHilth[i] > 0) {
                heroHilth[i] += 40;
            }
            System.out.println(" Medic Hil; " + heroesAttackType[i]);
            break;

        }

    }

    public static void golem() {
        for (int i = 0; i < heroHilth.length; i++) {
            if (heroHilth[7] > 0 && heroHilth[i] > 0 && heroHilth[7] != heroHilth[i]) {
                heroHilth[i] += bossDamage / 5;
                heroHilth[7] -= bossDamage / 5;
            }

        }
        System.out.println(" Golem; ");
    }

    public static void evasionl() {
        Random random = new Random();
        int randomEvasion = random.nextInt(4) + 1;
        switch (randomEvasion) {
            case 1:
                heroHilth[6] = heroHilth[6] + bossDamage;
                System.out.println(" Lacky ");
            case 2:
            case 3:
            case 4:
        }
    }

    public static void stan() {
        Random random = new Random();
        boolean stan = random.nextBoolean();
        if (stan) {
            bossDamage = 0;
            System.out.println(" Tor oglshen bossa; ");
        } else {
            bossDamage = 50;
        }
    }

    public static void berserkShoot() {
        Random random = new Random();
        int randomDomage = random.nextInt(15) + 1;
        int randomc = random.nextInt(3) + 1;
        switch (randomc) {
            case 1:
                heroDamage[4] = (heroDamage[4] + bossDamage) - randomDomage;
                System.out.println("Берсерк урон крит");
                System.out.println("Потери при увелечение урона+ " + randomDomage);
            case 2:
                bossDamage = 50;
            case 3:
                bossDamage = 50;
                break;

        }

    }

    public static void bossHilth() {
        for (int i = 0; i < heroHilth.length; i++) {
            if (heroHilth[i] > 0 && bossHilth > 0) {
                if (heroHilth[i] - bossDamage < 0) {
                    heroHilth[i] = 0;
                } else {
                    heroHilth[i] = heroHilth[i] - bossDamage;
                }
            }

        }
    }

    public static void herousHit() {
        for (int i = 0; i < heroDamage.length; i++) {
            if (heroHilth[i] > 0 && bossHilth > 0) {
                if (bossDefenceType == heroesAttackType[i]) {
                    Random random = new Random();
                    int coeff = random.nextInt(12);
                    if (bossHilth - heroDamage[i] * coeff < 0) {
                        bossHilth = 0;
                    } else {
                        bossHilth = bossHilth - heroDamage[i] * coeff;
                    }
                    System.out.println("Critical domag; " + heroDamage[i] * coeff);
                } else {
                    if (bossHilth - heroDamage[i] < 0) {
                        bossHilth = 0;
                    } else {
                        bossHilth = bossHilth - heroDamage[i];
                    }
                }
            }

        }
    }

    public static boolean isGameFinished() {
        if (bossHilth <= 0) {
            System.out.println(" Heros; wom!!! ");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroHilth.length; i++) {
            if (heroHilth[i] > 0) {
                allHeroesDead = false;
                break;
            }
            if (allHeroesDead) {
                System.out.println(" Boss wum!!!; ");
            }
        }
        return allHeroesDead;
    }

    public static void printStatic() {
        System.out.println( "============ " + roundNumber + " ROUND ============");
        System.out.println(" Boss Helth; " + bossHilth + "(" + " Boss Damage; " + bossDamage + ")");
        for (int i = 0; i < heroHilth.length; i++) {
            System.out.println(heroesAttackType[i] +
                    " health: " + heroHilth[i] + " (" + heroHilth[i] + ")");
        }
    }
}
