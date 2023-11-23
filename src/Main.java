
public class Main {
    public static void main(String[] args) {
        Character a1 = new Character(5, 10, "HERO1");
        Character a2 = new Character(2,20,"ENEMY");
        Sword excaliber = new Sword(5, 50); Sword wood_s =  new Sword(5,100);
        Shield egis = new Shield(2, 25); Shield wood_sh = new Shield(2,50);

        a1.equip_sword(excaliber);  a2.equip_sword(wood_s);
        a1.equip_shield(egis);    a2.equip_shield(wood_sh);
        a1.show_status(); a2.show_status();

        a1.sword_levelup(excaliber);
        a1.show_status();

        a1.shield_levelup(egis);
        a1.show_status();

        a2.attack(a1);
        a1.show_status();

        a1.unequip_shield();
        a1.unequip_sword();
        a1.show_status();

        a1.levelup();
        a1.show_status();

    }
}