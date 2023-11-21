
public class Main {
    public static void main(String[] args) {
        Character a1 = new Character(5, 10);
        a1.show_status();
        Sword excaliber = new Sword(5, 50);
        Shield egis = new Shield(2, 25);

        a1.equip_sword(excaliber);
        a1.equip_shield(egis);
        a1.show_status();

        a1.sword_levelup(excaliber);
        a1.show_status();

        a1.shield_levelup(egis);
        a1.show_status();

        a1.unequip_shield();
        a1.unequip_sword();
        a1.show_status();

        a1.levelup();
        a1.show_status();
    }
}