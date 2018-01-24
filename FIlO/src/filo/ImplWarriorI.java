/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filo;

/**
 *
 * @author Mikhail
 */
import java.util.Scanner;
import java.util.regex.MatchResult;
public class ImplWarriorI implements WarriorI {
    private int health;
    private String name;
    private WeaponI weapon;
    private int currentHealth;
    
    public ImplWarriorI(){
        health = 100;
        currentHealth = 100;
        name = "Darcy";
    }

    @Override
    public WeaponI getWeapon() {
        return weapon;
    }

    @Override
    public void setWeapon(WeaponI w) {
        weapon = w;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDefeated() {
        return (currentHealth <= 0);
    //        return true;
    //    return false;
    }

    @Override
    public boolean isHealthy() {
        return (currentHealth == health);
    //        return true;
    //    return false;
    }

    @Override
    public int takeDamage(WeaponI w) {
        currentHealth -= w.getDamage();
        return w.getDamage();
    }

    @Override
    public int getMaxHealth() {
        return health;
    }

    @Override
    public int getHealth() {
        return currentHealth;
    }
    
    public String toString(){
        return String.format("Warrior %s, health=%d, max health=%d", name, currentHealth, health);
    }

    @Override
    public void initFromString(String input) {
        Scanner scan = new Scanner(input);
        String pattern = "\\w+\\s*(\\w+),\\s*\\w+=(\\d+),\\s*\\w+\\s+\\w+=(\\d+)";
        MatchResult m;
        if(scan.findInLine(pattern) != null){
            m = scan.match();
            name = m.group(1);
            currentHealth = Integer.parseInt(m.group(2));
            health = Integer.parseInt(m.group(3));
        }
             
    }

    @Override
    public void heal() {
        currentHealth = health;
    }
    
}
