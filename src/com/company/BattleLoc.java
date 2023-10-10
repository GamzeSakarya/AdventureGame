package com.company;

import java.util.Random;
import java.util.Scanner;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        String lootSelect;
        System.out.println("Şu anda buradasınız: " + this.getName());
        System.out.println("Dikkatli ol burada " + obsNumber + " tane " + getObstacle().getName() + " yaşıyor.");
        System.out.print("<S>avaş veya <K>aç: ");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S")) {
            System.out.println("Mücadeleye hazırlan!");
            if (combat(obsNumber)) {
                System.out.println("Bölgedeki bütün düşmanları yendiniz.");
                switch (this.award) {
                    case "Food":
                        this.getPlayer().getInventory().setFood(true);
                        System.out.println("Tebrikler yemek ödülünü kazandınız.");
                        System.out.println(" ");
                        break;
                    case "Firewood":
                        this.getPlayer().getInventory().setFirewood(true);
                        System.out.println("Tebrikler odun ödülünü kazandınız.");
                        System.out.println(" ");
                        break;
                    case "Water":
                        this.getPlayer().getInventory().setWater(true);
                        System.out.println("Tebrikler su ödülünü kazandınız.");
                        System.out.println(" ");
                        break;
                    case "Loot":
                        Random numb = new Random();
                        int chanceOfSelection = numb.nextInt(100);
                        int changeOfLoot = numb.nextInt(100);
                        if (chanceOfSelection < 15) {
                            if (changeOfLoot < 20) {
                                System.out.println("Tüfek KAZANDIN");
                                Weapon selectedWeapon = Weapon.getWeaponID(3);
                                System.out.println("Tüfeği almak için 1 e almak istemiyorsan 2 ye bas");
                                lootSelect = input.nextLine();
                                if (lootSelect.equals("1")){
                                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                                }else {
                                    System.out.println("Silahın değişmedi.");
                                }

                            } else if (changeOfLoot < 50) {
                                System.out.println("Kılıç KAZANDIN");
                                Weapon selectedWeapon = Weapon.getWeaponID(2);
                                System.out.println("Kılıcı almak için 1 e almak istemiyorsan 2 ye bas");
                                lootSelect= input.nextLine();
                                if (lootSelect.equals("1")){
                                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                                }else {
                                    System.out.println("Silahın değişmedi.");
                                }
                            } else {
                                System.out.println("Tabanca KAZANDIN");
                                Weapon selectedWeapon = Weapon.getWeaponID(1);
                                System.out.println("Tabancayı almak için 1 e almak istemiyorsan 2 ye bas");
                                lootSelect = input.nextLine();
                                if (lootSelect.equals("1")){
                                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                                }else {
                                    System.out.println("Silahın değişmedi.");
                                }
                            }
                        } else if (chanceOfSelection < 30) {
                            if (changeOfLoot < 20) {
                                System.out.println("Ağır zırh kazandın");
                                Armor selectedArmor = Armor.getArmorID(3);
                                System.out.println("Ağır zırhı almak için 1 e almak istemiyorsan 2 ye bas");
                                lootSelect = input.nextLine();
                                if (lootSelect.equals("1")){
                                    this.getPlayer().getInventory().setArmor(selectedArmor);
                                    playerStats();
                                }else {
                                    System.out.println("Zırhın değişmedi.");
                                }


                            } else if (changeOfLoot < 50) {
                                System.out.println("Orta zırh kazandın");
                                Armor selectedArmor = Armor.getArmorID(2);
                                System.out.println("Orta zırhı almak için 1 e almak istemiyorsan 2 ye bas");
                                lootSelect = input.nextLine();
                                if (lootSelect.equals("1")){
                                    this.getPlayer().getInventory().setArmor(selectedArmor);
                                    playerStats();
                                }else {
                                    System.out.println("Zırhın değişmedi.");
                                }
                            } else {
                                System.out.println("Hafif zırh kazandın");
                                Armor selectedArmor = Armor.getArmorID(1);
                                System.out.println("Hafif zırhı almak için 1 e almak istemiyorsan 2 ye bas");
                                lootSelect = input.nextLine();
                                if (lootSelect.equals("1")){
                                    this.getPlayer().getInventory().setArmor(selectedArmor);
                                    playerStats();
                                }else {
                                    System.out.println("Zırhın değişmedi.");
                                }
                            }

                        } else if (chanceOfSelection < 55) {
                            if (changeOfLoot < 20) {
                                System.out.println("10 Para kazandın");
                                getPlayer().setMoney(getPlayer().getMoney() + 10);

                            } else if (changeOfLoot < 50) {
                                System.out.println("5 Para kazandın");
                                getPlayer().setMoney(getPlayer().getMoney() + 5);

                            } else {
                                System.out.println("1 Para kazandın");
                                getPlayer().setMoney(getPlayer().getMoney() + 1);


                            }
                        } else {System.out.println("Yılanlardan ödül düşmedi.");
                            System.out.println(" ");
                        }

                }

                return true;
            }

        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz.");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrgHealth());
            playerStats();
            obstacleStats(i);
            System.out.println(" ");
            boolean firstHit = Math.random() < 0.5;

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {

                if (firstHit) {
                    System.out.println(this.getObstacle().getName() + " size vurdu.");
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefense();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();

                }
                firstHit = false;
                System.out.println("<V>ur veya <K>aç");
                String selectBattle = input.nextLine().toUpperCase();

                if (selectBattle.equals("V")) {
                    System.out.println("Siz vurdunuz.");
                    this.getObstacle().setHealth((this.getObstacle().getHealth() - this.getPlayer().getTotalDamage()));
                    afterHit();

                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println(this.getObstacle().getName() + " size vurdu.");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefense();

                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }

                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (this.getObstacle().getHealth() <= 0) {
                if (!(this.getObstacle() instanceof Snake)) { // Yılan değilse
                    System.out.println("Düşmanı yendiniz.");
                    System.out.println(this.getObstacle().getAward() + " para kazandınız. ");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                    System.out.println("Güncel paranız " + this.getPlayer().getMoney());
                    System.out.println(" ");
                } else {

                }
            } else {
                return false;
            }
        }

        return true;
    }


    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu değerleri");
        System.out.println("--------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar Engelleme: " + this.getPlayer().getInventory().getArmor().getDefense());
        System.out.println("Para: " + this.getPlayer().getMoney());
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " değerleri");
        System.out.println("--------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getAward());

    }


    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}