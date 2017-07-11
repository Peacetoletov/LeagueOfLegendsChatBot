package me.peacetoletov;

/**
 * Created by lukas on 7.7.2017.
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class TypeInLeague {
    private HashMap<String, Integer> charMap = new HashMap<String, Integer>();

    TypeInLeague(){
        //Create a character map
        charMap.put("K", KeyEvent.VK_K);
        charMap.put("E", KeyEvent.VK_E);
        charMap.put("S", KeyEvent.VK_S);
        charMap.put("I", KeyEvent.VK_I);
        charMap.put("C", KeyEvent.VK_C);
        charMap.put("G", KeyEvent.VK_G);
        charMap.put("4", KeyEvent.VK_NUMPAD4);
        charMap.put("2", KeyEvent.VK_NUMPAD2);
        charMap.put("0", KeyEvent.VK_NUMPAD0);
        charMap.put(".", KeyEvent.VK_PERIOD);
    }

    public void kek(){
        try {
            Robot robot = new Robot();

            String[] kekChars = new String[5];
            kekChars[0] = "K......K...EEEE...K......K";
            kekChars[1] = "K...K......E..........K...K...";
            kekChars[2] = "KK.........EEEE...KK......";
            kekChars[3] = "K...K......E..........K...K...";
            kekChars[4] = "K......K...EEEE...K......K";

            typeWord(kekChars, robot);
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void sick(){
        try {
            Robot robot = new Robot();

            String[] sickChars = new String[5];
            sickChars[0] = "SSSS...I...CCC...K......K";
            sickChars[1] = "S.........I...C..........K...K...";
            sickChars[2] = "SSSS...I...C..........KK......";
            sickChars[3] = "......S...I...C..........K...K...";
            sickChars[4] = "SSSS...I...CCC...K......K";

            typeWord(sickChars, robot);
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void gg(){
        try {
            Robot robot = new Robot();

            String[] ggChars = new String[5];
            ggChars[0] = "...GGGG.........GGGG...";
            ggChars[1] = "G...................G................";
            ggChars[2] = "G......GG......G......GG...";
            ggChars[3] = "G............G....G............G";
            ggChars[4] = "...GGGG.........GGGG...";

            typeWord(ggChars, robot);
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void fourtwenty(){
        try {
            Robot robot = new Robot();

            String[] fourtwentyChars = new String[5];
            fourtwentyChars[0] = ".........4........2222........000..";
            fourtwentyChars[1] = "......4.4......2.........2...0......0";
            fourtwentyChars[2] = "...4....4...............2.....0......0";
            fourtwentyChars[3] = "444444.........2.........0......0";
            fourtwentyChars[4] = ".........4.........2222......000..";

            typeWord(fourtwentyChars, robot);
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void typeWord(String[] wordChars, Robot robot){
        pressCapsLock(robot);
        //Loop through each array
        for(int i = 0; i < wordChars.length; i++){
            //Loop through each character of the string
            for(int j = 0; j < wordChars[i].length(); j++){
                char character = wordChars[i].charAt(j);
                String letter = Character.toString(character);      //Convert the char into a string
                int key = charMap.get(letter);

                if (j == 0){
                    startNewRow(robot);
                }

                robot.keyPress(key);
                robot.delay(1);
                robot.keyRelease(key);

                if (j == wordChars[i].length() - 1){
                    pressEnter(robot, 50);
                }
            }
        }
        pressCapsLock(robot);
    }

    private void startNewRow(Robot robot){
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.delay(50);
        pressEnter(robot, 50);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    private void pressEnter(Robot robot, int delay){
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(delay);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private void pressCapsLock(Robot robot){
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
        robot.delay(5);
        robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
    }
}
