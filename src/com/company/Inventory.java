package com.company;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean Food, Firewood, Water;




    public Inventory(){
        this.weapon = new Weapon(-1, "Yumruk", 0, 0);
        this.armor = new Armor(-1, "Paçavra", 0, 0);
        this.Food =false;
        this.Firewood=false;
        this.Water=false;

    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


    public boolean isFood() {
        return Food;
    }

    public void setFood(boolean food) {

        Food = food;

    }

    public boolean isFirewood() {
        return Firewood;
    }

    public void setFirewood(boolean firewood) {
        Firewood = firewood;
    }

    public boolean isWater() {
        return Water;
    }

    public void setWater(boolean water) {
        Water = water;
    }
}

