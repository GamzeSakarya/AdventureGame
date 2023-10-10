package com.company;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");

    }

    @Override
    public boolean onLocation() {
        System.out.println("Henüz oyunu kazanmak için yeterli donanıma sahip değilsin.");
        System.out.println(" ");
        System.out.println("Güvenli evdesiniz.");
        this.getPlayer().setHealth(this.getPlayer().getOrgHealth());
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println("Canınız Yenilendi.");

        return true;
    }
}
