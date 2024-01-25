package ch.giuntini.powermodeswitch;

import javax.swing.SwingUtilities;
import java.awt.Desktop;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Menu extends PopupMenu {
    private final MenuItem item4;
    private final String[][] arr;

    public Menu(TrayIco ico) {
        try {
            PowerPlanReader p = new PowerPlanReader();
            arr = p.readFile();
            for (String[] strings : arr) {
                MenuItem item = new MenuItem(strings[1]);
                item.addActionListener(e -> {
                    try {
                        Process process = Runtime.getRuntime().exec("powercfg -setactive " + strings[0]);
                        process.onExit().thenRun(this::updateActive);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                });
                add(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        item4 = new MenuItem("");
        MenuItem item5 = new MenuItem("Open config file...");
        item5.addActionListener(e -> {
            try {
                Desktop.getDesktop().edit(new File("powercfg.txt"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        MenuItem item6 = new MenuItem("exit");
        item6.addActionListener(e -> ico.close());
        addSeparator();
        add(item4);
        addSeparator();
        add(item5);
        addSeparator();
        add(item6);

        updateActive();

        //reduce memory usage
        Runtime.getRuntime().gc();
    }

    public void updateActive() {
        try {
            Process p = Runtime.getRuntime().exec("powercfg -getactivescheme");
            BufferedReader br = p.inputReader();
            String res = br.readLine();
            br.close();
            String text = "";
            for (String[] strings : arr) {
                if (res.contains(strings[0])) {
                    text = "Active: " + strings[1];
                    break;
                }
            }
            if (text.isBlank()) {
                text = "Active: none";
            }
            String finalText = text;
            SwingUtilities.invokeLater(() -> item4.setLabel(finalText));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
