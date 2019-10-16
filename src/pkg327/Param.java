/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg327;

/**
 *
 * @author Jonah
 */
public class Param {
    
    String name;
    String type;
    
    public Param(String name, String type){
        name = name;
        type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
    @Override
    public String toString() { 
        return String.format(this.getName() + ":" + this.getType() + " "); 
    } 
    
}
