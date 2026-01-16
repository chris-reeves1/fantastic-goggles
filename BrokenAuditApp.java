package abstractsInterfaces;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class BrokenAuditApp {

    static String OutputFile = "stage0_output.txt";   
    static String TEAMname = "AuthTeam";             

    public static void doStuff() throws IOException {
        System.out.println("hello welcome to the audit thing");

        String[] users = {"user-100", "user-200", "user-300"}; 

        Object[][] attempts = {
                {"user-100", true},
                {"user-200", false},
                {"user-100", false},
                {"user-999", true}
        };
        System.out.println("Working directory output path: " + Path.of(OutputFile).toAbsolutePath());
        String header = "EVENTS FOR SYSTEM";
        System.out.println(header + " " + TEAMname);
        System.out.println(header + " " + TEAMname); 

        LocalDateTime ts = LocalDateTime.now(); 

        FileWriter f = new FileWriter(OutputFile); 

        for (Object[] a : attempts) {
            String u = (String) a[0];
            boolean ok = (boolean) a[1];

            String outcome = ok ? "OK" : "NOT_OK";

            String line = "time=" + ts + " user=" + u + " result=" + outcome;

            if (ok == true) {
                System.out.println("SUCCESS happened for " + u);
            } else {
                System.out.println("fail happened for " + u);
            }

            f.write(line); 
        }

        System.out.println("done. output file maybe created: " + OutputFile);
        f.close();
    }

    public static void main(String[] args) throws IOException {
        doStuff(); 
    }
}
