import java.util.*;
import java.io.*;

public class Program1 {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			Scanner in = new Scanner(new FileInputStream(args[0]));
			int randNum = in.nextInt();
			Random comp = new Random();
			int randomLetter = comp.nextInt(randNum);
			String word = "";
			int index = 0;
			while( index < randomLetter ){
				word = in.next();
				index++;
			}
			
			StringBuffer sbuf1 = new StringBuffer(word);
			StringBuffer sbuf2 = new StringBuffer();
			while(sbuf1.length() != 0){
				int randomWord = comp.nextInt(sbuf1.length());
				sbuf2.append(sbuf1.charAt(randomWord));
				sbuf1.deleteCharAt(randomWord);
			}
			System.out.println(sbuf2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
