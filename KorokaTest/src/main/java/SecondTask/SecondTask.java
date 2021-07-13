package SecondTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SecondTask {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        int amount = 0;

        try{
            amount = Integer.parseInt(inp.readLine());
        }
        catch (NumberFormatException ex){}

        if(amount < 2) System.exit(0);
        Integer[] arrNumbers = new Integer[amount];

        String[] numbers = inp.readLine().split(" ");

        for(int i = 0; i < amount; i++){
            try{
                arrNumbers[i] = Integer.parseInt(numbers[i]);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
                System.exit(-1);
            }
        }

        int smallest = Math.abs(arrNumbers[0] - arrNumbers[1]);
        for(int i = 0; i < arrNumbers.length; i++){
            for(int j = i + 1; j < arrNumbers.length; j++){
                int temp = Math.abs(arrNumbers[i] - arrNumbers[j]);
                if(smallest > temp) smallest = temp;
            }
        }

        System.out.println(smallest);
    }
}
