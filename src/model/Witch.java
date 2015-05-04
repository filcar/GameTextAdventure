/*       04 MAY 2015 19.00             */
package model;

import static controler.Lexer.tokenType;
import java.util.HashMap;
import java.util.Random;
import typeOfItem.INonTakeable;
import typeOfItem.IDrinkable;

/**
 * @author geodom61
 */
public class Witch implements IPlayer, IItem, IDrinkable, INonTakeable {
    private String name;
    Random rand = new Random();
    private int health=(rand.nextInt(50))+70;
    private HashMap<String, IItem> mapItem = new HashMap<String, IItem>();
    
    public Witch() {
    }
    
    public Witch(String name) {
        this.name = name;
        tokenType.addList(this);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<String, IItem> getMapItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addItem(IItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void removeItem(IItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public IItem getCurrentItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setCurrentItem(IItem currentItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Integer drinking(Integer damage) {
       health = health - damage;
       if (health < 1) 
           System.out.println("You killed the " + this.getName());
       else if(health > 1 && health < 100)
           System.out.println("The " + this.getName() + " is still alive but they have " + this.getHealth() + "% health");    
       return health;
    }
    
    
    
    
}
