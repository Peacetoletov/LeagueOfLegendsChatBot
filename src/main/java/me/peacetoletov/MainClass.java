package me.peacetoletov;

/**
 * Created by lukas on 5.7.2017.
 */
import java.util.Map.Entry;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class MainClass {
    private static boolean run = true;
    public static void main(String[] args) {
        // might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // use false here to switch to hook instead of raw input

        System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown. Connected keyboards:");
        for(Entry<Long,String> keyboard:GlobalKeyboardHook.listKeyboards().entrySet())
            System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());

        final TypeInLeague type = new TypeInLeague();

        keyboardHook.addKeyListener(new GlobalKeyAdapter() {
            @Override public void keyPressed(GlobalKeyEvent event) {
                System.out.println(event);
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE)
                    run = false;


                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_NUMPAD9) {
                    type.kek();
                }
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_NUMPAD8) {
                    type.sick();
                }
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_NUMPAD7) {
                    type.gg();
                }
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_NUMPAD6) {
                    type.fourtwenty();
                }



            }
            @Override public void keyReleased(GlobalKeyEvent event) {
                System.out.println(event);
            }
        });

        try {
            while(run) Thread.sleep(128);
        } catch(InterruptedException e) { /* nothing to do here */ }
        finally { keyboardHook.shutdownHook(); }
    }
}