package name.dengchao.test.fx.plugin;

import java.io.InputStream;

public interface Plugin {

    String getName();

    DisplayType getDisplayType();

    void setParameters(String... parameters);

    InputStream execute();
}