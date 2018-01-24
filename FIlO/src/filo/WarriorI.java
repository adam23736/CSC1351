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
public interface WarriorI {

  /**
   * Return the weapon that the warrior
   * currently has equipped.
   */
  public WeaponI getWeapon();

  /**
   * Place the weapon object in the
   * warrior's hand.
   */
  public void setWeapon(WeaponI w);

  /**
   * Return the warrior's name, e.g.
   * Conan, Red Sonja, etc.
   */
  public String getName();

  /**
   * Returns true if the warrior
   * has taken more damage than
   * the warrior's maxHealth.
   */
  public boolean isDefeated();

  /**
   * Returns true if the warrior
   * has taken no damage.
   */
  public boolean isHealthy();

  /**
   * Invokes the getDamage() method
   * on the weapon and subtracts it
   * from the warrior's current health points.
   * If the warrior's health points fall
   * to zero or lower, the warrior is
   * defeated. This method returns
   * the amount of damage dealt.
   */
  public int takeDamage(WeaponI w);

  /**
   * The maximum amount of damage the
   * warrior could take if the warrior
   * were healthy before being defeated.
   */
  public int getMaxHealth();

  /**
   * The current amount of damage the
   * warrior could take if the warrior
   * were healthy before being defeated.
   */
  public int getHealth();

  /**
   * The format should look like this:
   *
   * "Warrior {name}, health={number}, max health={number}."
   */
  public String toString();

  /**
   * This method should take a string in the same format
   * as the toString method above, and parses the name, id, and
   * damage numbers using the findInLine() method on Scanner,
   * and sets the values.
   * Note that spaces may vary in length. The
   * following is valid.
   * Warrior conan,health=10, max  health=13
   *
   * <em>Note</em>: it's probably a good idea to add \\s*
   * to the end of your pattern in order to deal with line
   * ending problems.
   */
  public void initFromString(String input);

  /**
   * Restore a warrior to full health.
   */
  public void heal();
}