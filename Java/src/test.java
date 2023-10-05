import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hexInput = br.readLine();
        
		int decimal = Integer.parseInt(hexInput,16);
        System.out.println("Hex -> Decimal : " + decimal);
		
        char[] c = {'C', 'B'};
		System.out.println(String.valueOf(c));
	}
}