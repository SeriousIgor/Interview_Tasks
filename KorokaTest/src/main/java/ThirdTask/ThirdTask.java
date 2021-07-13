package ThirdTask;

import java.io.*;

public class ThirdTask {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        int M = 0;
        String A;
        String[] messages;

        try {
            M = Integer.parseInt(inp.readLine());
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        if((M <= 0) || (M > 100)) System.exit(0);

        A = inp.readLine().toLowerCase();
        if(A.length() > 100)
            A = A.substring(0,100);

        messages = new String[M];
        for (int i = 0; i < M; i++) {
            String tmp = inp.readLine().toLowerCase();
            if(tmp.length() > 100){
                tmp = tmp.substring(0,100);
            }
            messages[i] = tmp;
        }

        for (int i = 0; i < messages.length - 1; i++) {
            for (int j = i + 1; j < messages.length; j++) {
                if (count(messages[i], A) > count(messages[j], A)) {
                    String tmp = messages[j];
                    messages[j] = messages[i];
                    messages[i] = tmp;
                }
            }
        }

        for (String s : messages) {
            System.out.println(s);
        }
        }
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
}
