package net.rystuff.mcmoddeobf;

import argo.jdom.JdomParser;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import net.rystuff.mcmoddeobf.gui.Console;
import net.rystuff.mcmoddeobf.gui.GuiMain;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MCModDeobf extends JFrame {

    public static JsonRootNode config;
    public static MCModDeobf instance;
    // Sets the GuiMain class to a variable
    public GuiMain guimain;
    public Console console;

    public MCModDeobf() {
        instance = this;
        new Console();
        if (new File(Util.baseDir + File.separator + "config.json").exists()) {
            // new File(Util.baseDir + File.separator + "config.json").delete();
        }
        Util.download("https://raw.githubusercontent.com/Rydog101/MCModDeobf/master/config.json", Util.baseDir + File.separator + "config.json");
        try {
            config = new JdomParser().parse(new FileReader(new File(Util.baseDir + File.separator + "config.json")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidSyntaxException e) {
            e.printStackTrace();
        }
        // Creates a new JFrame
        instance = this;
        guimain = new GuiMain(this);
        setTitle("MC Mod Deobf");
        setSize(550, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(guimain);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MCModDeobf();
    }
}
