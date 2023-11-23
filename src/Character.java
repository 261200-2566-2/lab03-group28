import java.text.DecimalFormat;
import java.util.zip.CheckedInputStream;

public class Character {
    private int level = 1;
    private double Base_speed ,max_HP ,HP ,max_Mana ,max_speed;
    private double beforesword_bsp, beforeshield_bsp;
    private String name;
    private boolean dead = false;
    private Sword sword;
    private Shield shield;
    Character (int lv,int base_runspeed, String name){
        this.name = name;
        level = lv;
        Base_speed = base_runspeed;
        max_HP = 100 + 10 * level;
        HP = max_HP;
        max_Mana = 50 + 2 * level;
        max_speed = Base_speed+(Base_speed * (0.1 + 0.03 * level));
    }

    public void attack(Character c){
        if(c.HP > 0){
            if(this.sword == null){
                System.out.println("You can't attack.You don't have sword.");
            }else{
                if(c.shield != null){
                    if(c.shield.returndef() >= this.sword.returndmg()){
                        System.out.println("Can't attack. Your sword is too weak.");
                    }else{
                        System.out.println(this.name + " attack " + c.name);
                        c.HP = c.HP - (this.sword.returndmg()-c.shield.returndef());
                        if(c.HP <= 0){
                            c.dead = true;
                        }
                    }
                }else{
                    c.HP = c.HP - this.sword.returndmg();
                    if(c.HP <= 0){
                        c.dead = true;
                    }
                }
            }
        }else{
            System.out.println("Your target is dead.");
        }

    }

    public void equip_sword(Sword sword){
        if(this.sword == null){
            this.sword = sword;
            beforesword_bsp = Base_speed;
            Base_speed = Base_speed-(2+0.04*this.sword.returnlv());
            max_speed = Base_speed+(Base_speed * (0.1 + 0.03 * level));
        }else{
            System.out.println("You already equiped sword.");
        }
    }
    public void unequip_sword(){
        if(this.sword != null){
            Base_speed = beforesword_bsp;
            this.sword = null;
            max_speed = Base_speed+(Base_speed * (0.1 + 0.03 * level));
        }else{
            System.out.println("You don't equip sword yet.");
        }
    }
    public void equip_shield(Shield shield){
        if(this.shield == null){
            this.shield = shield;
            beforeshield_bsp = Base_speed;
            Base_speed = Base_speed-(2+0.08*this.shield.returnlv());
            max_speed = Base_speed+(Base_speed * (0.1 + 0.03 * level));
        }else{
            System.out.println("You already equiped shield.");
        }
    }
    public void unequip_shield(){
        if(this.sword != null){
            Base_speed = beforeshield_bsp;
            this.shield = null;
            max_speed = Base_speed+(Base_speed * (0.1 + 0.03 * level));
        }else{
            System.out.println("You don't equip sword yet.");
        }
    }
    public void levelup(){
        this.level++;
        Base_speed = Base_speed + (0.5*level);
        max_HP = 100 + 10 * level;
        max_Mana = 50 + 2 * level;
        max_speed = Base_speed+(Base_speed * (0.1 + 0.03 * level));
        System.out.println(this.name + " is levelup.");
    }

    public void sword_levelup(Sword s){
        if(this.sword != null){
            s.sword_levelup();
            Base_speed = Base_speed-(2+0.04*this.sword.returnlv());
            max_speed = Base_speed+(Base_speed * (0.1 + 0.03 * level));
        }else {
            System.out.println("You don't have sword.");
        }
    }

    public void shield_levelup(Shield shield){
        if(this.shield != null){
            shield.shield_levelup();
            Base_speed = Base_speed-(2+0.08*this.shield.returnlv());
            max_speed = Base_speed+(Base_speed * (0.1 + 0.03 * level));
        }else{
            System.out.println("You don't have shield.");
        }

    }

    public void show_status(){
        System.out.println("------------------------------------------------------");
        if(this.dead == false){
            String maxspeed = new DecimalFormat("##.##").format(this.max_speed);
            String basespeed = new DecimalFormat("##.##").format(this.Base_speed);
            System.out.println("NAME: "+this.name+"\nLevel: " + this.level + "\nMAX HP: " + this.max_HP + "\nHP: " + this.HP + "\nMax mana: " + this.max_Mana
                    + "\nBase run speed: " + basespeed + "\nMax run speed: " + maxspeed);
            if(this.sword != null){
                String dmg = new DecimalFormat("##.##").format(this.sword.returndmg());
                System.out.println("Sword level: " + this.sword.returnlv() + "  DMG: " + dmg);
            }
            if(this.shield != null){
                String def = new DecimalFormat("##.##").format(this.shield.returndef());
                System.out.println("Shield level: " + this.shield.returnlv() + "  DEF: " + def);
            }
        }else{
            System.out.println(this.name + " is dead.");
        }

        System.out.println("------------------------------------------------------");
    }



}
