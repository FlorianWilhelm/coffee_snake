package coffee_snake;

import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// https://www.adamheinrich.com/blog/2012/12/how-to-load-native-jni-library-from-jar/
import cz.adamh.utils.NativeUtils;


import jep.Jep;
import jep.JepException;
import jep.JepConfig;


public class Main {
    static {
        try {
            // Use this to set right path later, doesn't work yet
            // System.setProperty("java.library.path", "/path/to/library");
            NativeUtils.loadLibraryFromJar("/libjep.so");
            NativeUtils.loadLibraryFromJar("/jep.cpython-35m-x86_64-linux-gnu.so");
        } catch (IOException e) {
            e.printStackTrace(); // This is probably not the best way to handle exception :-)
        }
    }


    private String getPyFile() {

        // ClassLoader classLoader = getClass().getClassLoader();
        // File file = new File(classLoader.getResource("python/model.py").getFile());

        InputStream in = getClass().getResourceAsStream("python/model.py");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        StringBuilder result = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        }
        catch (IOException e){
            e.printStackTrace(new PrintStream(System.out));
        }

        return result.toString();

    }

    public static void main(String[] args) {
        Main obj = new Main();
        //String py_code = obj.getPyFile();

        JepConfig config = new JepConfig();
        config.addSharedModules("numpy");
        config.addSharedModules("scipy");
        config.addSharedModules("pandas");
        try(Jep jep = new Jep(config)) {
            jep.eval("import numpy as np");
            jep.eval("import pandas as pd");
            jep.eval("from scipy import stats");
            jep.eval("stats.norm(10.,2.).rvs()");
            jep.eval("x = np.ones(10)");
            jep.eval("x *= 2.4");
            jep.eval("df = pd.DataFrame([1,2,3])");
            jep.eval("print(df)");
            jep.eval("print(np.sum(x))");
            jep.eval("from java.lang import System");
            jep.eval("s = 'Hello World'");
            jep.eval("System.out.println(s)");
            jep.eval("print(s)");
            jep.eval("print(s[1:-1])");
        }
        catch (JepException e) {
            e.printStackTrace(new PrintStream(System.out));
        }
    }
}

