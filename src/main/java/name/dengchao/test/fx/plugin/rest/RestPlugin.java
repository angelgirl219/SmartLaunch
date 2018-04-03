package name.dengchao.test.fx.plugin.rest;

import name.dengchao.test.fx.plugin.Plugin;
import org.apache.http.client.fluent.Request;

import java.io.InputStream;

public abstract class RestPlugin implements Plugin {

    @Override
    public InputStream execute() {
        return null;
    }
}
