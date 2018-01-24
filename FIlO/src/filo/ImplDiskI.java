/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

/**
 *
 * @author Mikhail
 */
public class ImplDiskI implements DiskI{

    @Override
    public WarriorI loadWarrior(File f) throws IOException {
        WarriorI war = new ImplWarriorI();
        Scanner scan = new Scanner(f);
        war.initFromString(scan.nextLine());
        return war;
    }

    @Override
    public File saveWarrior(WarriorI w) throws IOException {
        File f = new File(w.getName() + ".txt");
        FileWriter fw = new FileWriter(f);
        String temp = w.toString();
        fw.write(temp);
        fw.close();
        return f;
    }
    
}
