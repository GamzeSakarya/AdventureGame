package com.company;

public class Obstacle {
    private int ID;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int orgHealth;

    public Obstacle(int ID, String name, int damage, int health, int award) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.orgHealth =health;
        this.award=award;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOrgHealth() {
        return orgHealth;
    }

    public void setOrgHealth(int orgHealth) {
        this.orgHealth = orgHealth;
    }
}