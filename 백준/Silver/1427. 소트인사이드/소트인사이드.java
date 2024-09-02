import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputValue = br.readLine().split("");
        Arrays.sort(inputValue, Collections.reverseOrder());

        String externalValue = "";
        for (String c : inputValue) {
            externalValue += c;
        }
        bw.write(externalValue);
        

        br.close();
        bw.flush();
        bw.close();
    }
}