package com.company;

public abstract class GameChar {
    private int ID;
    private String charName;
    private int damage;
    private int health;
    private int money;

    public GameChar(int ID, String charName, int damage, int health, int money) {
        this.ID = ID;
        this.charName = charName;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
