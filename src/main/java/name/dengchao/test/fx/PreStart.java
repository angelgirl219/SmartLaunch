package name.dengchao.test.fx;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import name.dengchao.test.fx.tray.Tray;
import name.dengchao.test.fx.hotkey.os.GlobalKeyListener;
import name.dengchao.test.fx.hotkey.os.VoidDispatchService;
import name.dengchao.test.fx.utils.Utils;

// TODO should be a hook, allow developer register operation here.
public class PreStart {

    public static void check() {
        registerKey();
        Tray.createTray();
        checkDir(Utils.getPluginConfigPath(), "Plugin config");
        checkDir(Utils.getLogPath(), "Log");
    }

    private static void checkDir(String dirPath, String name) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println(name + " dir not exists, create it.");
            dir.mkdirs();
        }
    }

    public static void registerKey() {
        // shutdown the logger in GlobalScreen
        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        GlobalScreen.setEventDispatcher(new VoidDispatchService());
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
    }
}
