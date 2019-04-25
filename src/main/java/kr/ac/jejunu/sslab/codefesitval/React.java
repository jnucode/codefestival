package kr.ac.jejunu.sslab.codefesitval;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class React {

    private ThreadLocal<ScriptEngine> engineHolder = ThreadLocal.withInitial(() -> {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashornScriptEngine = scriptEngineManager.getEngineByName("nashorn");
        try {
            nashornScriptEngine.eval(read("js/nashorn-polyfill.js"));
            nashornScriptEngine.eval(read("static/server-bundle.js"));
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
        return nashornScriptEngine;
    });

    private Reader read(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }
}
