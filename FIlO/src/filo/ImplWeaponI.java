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
import java.util.Random;
public class ImplWeaponI implements WeaponI {
    
    private int damage;
    private String wName;
    
    public ImplWeaponI() {
        damage = 15;
        wName = "dogEllie";
    }

    @Override
    public int getDamage() {
        Random rand = new Random(getMaxDamage());
        return rand.nextInt(getMaxDamage()+1);
    }

    @Override
    public int getMaxDamage() {
        return damage;
    }
    
    public String toString(){
        return String.format("Weapon %s, damage=%d", wName, damage);
    }

    @Override
    public void initFromString(String input) {
        Scanner scan = new Scanner(input);
        String pattern = "\\w+\\s*(\\w+),\\s*\\w+=(\\d+)";
        while(scan.hasNextLine()) {
            if(scan.findInLine(pattern) != null);
            MatchResult search = scan.match();
            search = scan.match();
            wName = search.group(1);
            damage = Integer.parseInt(search.group(2));
        }
    }

    @Override
    public String getName() {
        return wName;
    }
    
}
