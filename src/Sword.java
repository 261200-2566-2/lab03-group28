public class Sword {
    private int level = 1;
    private double sword_dmg;
    public int returnlv(){
        return level;
    }
    public double returndmg(){
        return sword_dmg;
    }
    public void sword_levelup(){
        this.level++;
        this.sword_dmg = sword_dmg*(1+0.1*level);
    }
    Sword(int level, double d){
        this.level = level;
        this.sword_dmg = d*(1+0.1*level);
    }
}
