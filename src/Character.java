import java.text.DecimalFormat;

public class Character {
    private int level = 1;
    private double Base_speed ,max_HP ,HP ,max_Mana ,max_speed;
    private Sword sword;
    private Shield shield;
    Character (int lv,int base_runspeed){
        level = lv;
        Base_speed = base_runspeed;
        update();
    }

    public void equip_sword(Sword sword){
        if(this.sword == null){
            this.sword = sword;
            Base_speed = Base_speed-(2+0.04*this.sword.returnlv());
            update();
        }else{
            System.out.println("You already equiped sword.");
        }
    }
    public void unequip_sword(){
        if(this.sword != null){
            Base_speed = Base_speed+(2+0.04*this.sword.returnlv());
            this.sword = null;
            update();
        }else{
            System.out.println("You don't equip sword yet.");
        }
    }
    public void equip_shield(Shield shield){
        if(this.shield == null){
            this.shield = shield;
            Base_speed = Base_speed-(2+0.08*this.shield.returnlv());
            update();
        }else{
            System.out.println("You already equiped shield.");
        }
    }
    public void unequip_shield(){
        if(this.sword != null){
            Base_speed = Base_speed+(2+0.08*this.shield.returnlv());
            this.shield = null;
            update();
        }else{
            System.out.println("You don't equip sword yet.");
        }
    }
    public void levelup(){
        this.level++;
        Base_speed = Base_speed + (0.5*level);
        update();
    }

    public void sword_levelup(Sword s){
        if(this.sword != null){
            s.sword_levelup();
            Base_speed = Base_speed-(2+0.04*this.sword.returnlv());
            update();
        }else {
            System.out.println("You don't have sword.");
        }
    }

    public void shield_levelup(Shield shield){
        if(this.shield != null){
            shield.shield_levelup();
            Base_speed = Base_speed-(2+0.08*this.shield.returnlv());
            update();
        }else{
            System.out.println("You don't have shield.");
        }

    }

    public void show_status(){
        System.out.println("------------------------------------------------------");
        String maxspeed = new DecimalFormat("##.##").format(this.max_speed);
        String basespeed = new DecimalFormat("##.##").format(this.Base_speed);
        System.out.println("Level: " + this.level + "\nHP: " + this.HP + "\nMax mana: " + this.max_Mana
        + "\nBase run speed: " + basespeed + "\nMax run speed: " + maxspeed);
        if(this.sword != null){
            String dmg = new DecimalFormat("##.##").format(this.sword.returndmg());
            System.out.println("Sword level: " + this.sword.returnlv() + "  DMG: " + dmg);
        }
        if(this.shield != null){
            String def = new DecimalFormat("##.##").format(this.shield.returndef());
            System.out.println("Shield level: " + this.shield.returnlv() + "  DEF: " + def);
        }
        System.out.println("------------------------------------------------------");
    }


    private void update() {
        max_HP = 100 + 10 * level;
        HP = max_HP;
        max_Mana = 50 + 2 * level;
        max_speed = Base_speed+(Base_speed * (0.1 + 0.03 * level));
    }


}
