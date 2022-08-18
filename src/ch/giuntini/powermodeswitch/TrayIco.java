package ch.giuntini.powermodeswitch;

import javax.swing.ImageIcon;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.util.Objects;

public class TrayIco {

    private final TrayIcon trayIcon;

    public TrayIco() throws AWTException {
        ImageIcon ico = new ImageIcon(Objects.requireNonNull(TrayIco.class.getResource("images/ico.png")));
        trayIcon = new TrayIcon(ico.getImage(), "Power Mode Switch", new Menu(this));
        trayIcon.setImageAutoSize(true);
        if (SystemTray.isSupported()) {
            SystemTray.getSystemTray().add(trayIcon);
        }
    }

    public void close() {
        SystemTray.getSystemTray().remove(trayIcon);
    }
}
