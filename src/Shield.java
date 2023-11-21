public class Shield {
    private int level = 1;
    private double shield_def;
    public int returnlv(){
        return level;
    }
    public double returndef(){
        return shield_def;
    }
    public void shield_levelup(){
        this.level++;
        this.shield_def = shield_def*(1+0.05*level);
    }
    Shield(int level, double s){
        this.level = level;
        this.shield_def = s*(1+0.05*level);
    }

}
