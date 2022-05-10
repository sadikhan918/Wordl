import java.util.*;

public class Wordl {
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void main(String[] args) {
		
		ArrayList<String> wordlist = new ArrayList<>(Arrays.asList("coupe", "train", "happy", "shine", "flash", "sunny", "loser"));
		int turn = 1;
	
		System.out.println("welcome to scuffed wordle!");
		Scanner kbd = new Scanner(System.in);
		Random ran = new Random();
		int rand = ran.nextInt(wordlist.size());
		System.out.println(rand);
		
		
		while(turn <= 6) {
			System.out.println("Enter a 5 letter word guess");
			String input = kbd.next();
			String response = wordChecker(input.toLowerCase(), rand, wordlist);
			if(response.equals(wordlist.get(rand))) {
				System.out.println("You Won! It took you " + turn + " tries.");
				System.exit(0);
			}
			turn++;
		}
		System.out.println("Maybe next time. The word was " + wordlist.get(rand));
		kbd.close();
	
	}
	
	public static String wordChecker(String input, int index, ArrayList<String> wordlist) {
		String print = "";
//		String out = "";
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == wordlist.get(index).charAt(i)) {
				print+= ANSI_GREEN + input.charAt(i) + ANSI_RESET;
//				out += input.charAt(i);
			}
			else if(wordlist.get(index).contains(input.charAt(i) + "")) {
				print+= ANSI_YELLOW + input.charAt(i) + ANSI_RESET;
//				out += input.charAt(i);
			}
			else {
				print+= input.charAt(i);
//				out += input.charAt(i);
			}
		}
		System.out.println(print);
		return input;
	}
}
