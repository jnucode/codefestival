package kr.ac.jejunu.sslab.codefesitval;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodefesitvalApplicationTests {

    @Test
    public void contextLoads() throws ScriptException, NoSuchMethodException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
        Invocable invocable = (Invocable) engine;

        String result = (String) invocable.invokeFunction("Hello", "Brian");
    }

}
