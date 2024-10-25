/*
*   Power information class
*/

import java.io.*;
import java.lang.*;
import java.util.*;

public static class powerInfo {
    public static float GetPowerConsumption() {
        List<String> list = new ArrayList<String>();
        list.add("sudo cat /sys/class/powercap/*/energy_uj");
 
        // create the process
        try {
            ProcessBuilder build = new ProcessBuilder(list);
            Process process = build.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder builder = new StringBuilder();

            builder.append(reader.readLine());

            String result = builder.toString();
            return Float.parseFloat(result);
        } catch(Exception e) {
            return -1f;
        }
    }
}