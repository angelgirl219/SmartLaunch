package name.dengchao.test.fx.utils;


import org.apache.commons.lang.SystemUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    public static String getHomePath() {
        String userHome = SystemUtils.getUserHome().getAbsolutePath();
        if (SystemUtils.IS_OS_WINDOWS) {
            return userHome.concat(Constants.HOME_WINDOWS);
        } else if (SystemUtils.IS_OS_MAC) {
            return userHome.concat(Constants.HOME_MAC);
        } else if (SystemUtils.IS_OS_LINUX) {
            return userHome.concat(Constants.HOME_LINUX);
        } else {
            throw new RuntimeException("WTH OS are you using, do your mind support?");
        }
    }

    public static String getPluginPath() {
        return getHomePath().concat("/plugins");
    }

    public static String getPluginConfigPath() {
        return getPluginPath().concat("/config");
    }

    public static String getLogPath() {
        return getHomePath().concat("/log");
    }

    public static String getUserStartMenuPath() {
        return SystemUtils.getUserHome() + "/AppData/Roaming/Microsoft/Windows/Start Menu/Programs";
    }

    public static String getSystemStartMenuPath() {
        return "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs";
    }

    public static boolean isLink(String fileName) {
        return fileName.endsWith(".lnk");
    }

    public static boolean isAppFile(String fileName) {
        String lowercaseFileName = fileName.toLowerCase();
        if (lowercaseFileName.contains("update") ||
                lowercaseFileName.contains("install") ||
                lowercaseFileName.contains("about") ||
                lowercaseFileName.contains("feedback") ||
                lowercaseFileName.contains("url") ||
                lowercaseFileName.contains("卸载") ||
                lowercaseFileName.contains("更新") ||
                lowercaseFileName.contains("配置") ||
                lowercaseFileName.contains("帮助") ||
                lowercaseFileName.contains("设置") ||
                lowercaseFileName.contains("上载") ||
                lowercaseFileName.contains("关于") ||
                lowercaseFileName.contains("反馈") ||
                lowercaseFileName.contains("向导") ||
                lowercaseFileName.contains("升级")) {
            return false;
        }
        return true;
    }

    public static String removeSurplusSpace(String input) {
        while (input.contains("  ")) {
            input = input.replaceAll("  ", " ");
        }
        return input;
    }

    public static boolean isChinese(String string) {
        int n = 0;
        for (int i = 0; i < string.length(); i++) {
            n = (int) string.charAt(i);
            if (!(19968 <= n && n < 40869)) {
                return false;
            }
        }
        return true;
    }
}
