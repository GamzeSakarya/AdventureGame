package com.company;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    private int orgHealth;
    public Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("------------------------");
        for (GameChar c : charList) {
            System.out.println("ID: " + c.getID() +
                    "\t Karakter: " + c.getCharName() +
                    "\t\t Hasar: "  + c.getDamage()  +
                    "\t\t Sağlık: " + c.getHealth() +
                    "\t\t Para: " + c.getMoney());
        }
        System.out.println("------------------------");
        System.out.print("Seçmek istediğiniz karaterin ID numarasını seçin: ");
        int select = input.nextInt();
        switch (select){
            case 1 :
                initPlayer(new Samurai());
                break;
            case 2 :
                initPlayer(new Archer());
                break;
            case 3 :
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());

        }
         /* System.out.println("Karakter: " + this.getCharName() +
                ", Hasar: " + this.getDamage() +
                ", Sağlık: " + this.getHealth() +
                ", Para: " + this.getMoney());

          */

    }
    public void printInfo(){
        String foodInf = this.inventory.isFood() ? "Var" : "Yok";
        String fireWoodInf = this.inventory.isFirewood() ? "Var" : "Yok";
        String waterInf = this.inventory.isWater() ? "Var" : "Yok";
        System.out.println("Karakter: " + this.getCharName() +
                ", Silah: " + this.getInventory().getWeapon().getName() +
                ", Hasar: " + this.getTotalDamage() +
                ", Zırh: " + this.getInventory().getArmor().getName() +
                ", Hasar Engelleme: " + this.getInventory().getArmor().getDefense() +
                ", Sağlık: " + this.getHealth() +
                ", Para: " + this.getMoney() +
                "\nYemek: " + foodInf +
                ", Odun: " + fireWoodInf +
                ", Su: " + waterInf);


    }

    public void initPlayer(GameChar gameCharac){
        this.setCharName(gameCharac.getCharName());
        this.setDamage(gameCharac.getDamage());
        this.setHealth(gameCharac.getHealth());
        this.setOrgHealth(gameCharac.getHealth());
        this.setMoney(gameCharac.getMoney());
    }

    public int getTotalDamage(){
        return damage + getInventory().getWeapon().getDamage();
    }
    public int getDamage(){
        return damage;
    }
    public int getOrgHealth() {
        return orgHealth;
    }

    public void setOrgHealth(int orgHealth) {
        this.orgHealth = orgHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
