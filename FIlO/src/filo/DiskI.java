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
import java.io.File;
import java.io.IOException;

public interface DiskI {

  /**
   * Open a file and read in the data needed to
   * instantiate a warrior, namely the warrior's
   * name and maxBodyPoints.
   */
  public WarriorI loadWarrior(File f) throws IOException;

  /**
   * Create a file, and write the warrior's name and
   * maxBodyPoints into the file. To write a file,
   * you need to instantiate a FileWriter (from
   * package java.io).
   *
   * <pre>
   * FileWriter fw = new FileWriter(f);
   * ...
   * fw.close();
   * </pre>
   *
   * The FileWriter class doesn't have the println()
   * or printf() you're familiar with. If you'd like
   * to have to create a PrintWriter.
   *
   * <pre>
   * FileWriter fw = new FileWriter(f);
   * PrintWriter pw = new PrintWriter(fw);
   * ...
   * pw.println("text");
   * ...
   * pw.close();
   * </pre>
   * 
   * Notice that when we use the PrintWriter class
   * we call the close method on it rather than the
   * FileWriter class.
   */
  public File saveWarrior(WarriorI w) throws IOException;
}