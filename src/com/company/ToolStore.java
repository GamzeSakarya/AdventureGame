package com.company;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza ");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz.");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silah satın al.");
            System.out.println("2 - Zırh satın al.");
            System.out.println("3 - Mağazadan çıkış yap.");
            System.out.print("Yapmak istediğiniz işlemi seçin: ");
            int selectItem = input.nextInt();
            input.nextLine();
            while (selectItem < 1 || selectItem > 3 ){
                System.out.println("Lütfen geçerli bir işlem seçin.");
                selectItem = input.nextInt();
            }
            switch (selectItem){
                case 1 :
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Görüşmek Üzere.");
                    showMenu = false;
                    break;
            }

        }
        return true;

    }

    public void printWeapon(){
        System.out.println("------Silahlar------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getID() + "- " + w.getName() + " hasar: " + w.getDamage() + " tutar: " + w.getPrice());

        }
        System.out.println("0- Çıkış yap.");

    }
    public void buyWeapon(){
        System.out.print("Satın almak istediğiniz silahı seçin: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length ){
            System.out.println("Lütfen geçerli bir işlem seçin.");
            selectWeaponID = input.nextInt();

        }
        if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponID(selectWeaponID);
            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > getPlayer().getMoney()){
                    System.out.println("Yeterli paranız yok.");
                }
                else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                    int balance = getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("--------------------");
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }
        }

    }
    public void printArmor(){
        System.out.println("------Zırhlar------");
        for (Armor a :Armor.armors()) {
            System.out.println(a.getID() + "- " + a.getName() + " zırh: " + a.getDefense() + " tutar: " + a.getPrice());
        }
        System.out.println("0- Çıkış yap.");

    }
    public void buyArmor(){
        System.out.print("Satın almak istediğiniz zırhı seçin: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length ) {
            System.out.println("Lütfen geçerli bir işlem seçin.");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorID(selectArmorID);
            if (selectedArmor != null){

                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız yok.");
                } else {
                    System.out.println(selectedArmor.getName() + " zırh satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("--------------------");
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }



    }
}
