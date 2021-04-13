import java.util.ArrayList;
import java.util.Random;

public class Puzzle {
	public static ArrayList sumArr() {
			int sum   = 0;
			int[] arr = {3, 5, 1, 2, 7, 9, 8, 13, 25, 32};
			ArrayList<Integer> greaterThan10 = new ArrayList();
			for (int i = 0; i < arr.length; i++){
				if (arr[i] > 10){
					greaterThan10.add(arr[i]);
				}
				sum += arr[i];
			}
			System.out.println("Sum: "+sum);
			return greaterThan10;
	}

	public static ArrayList nameArr() {
			String[] namearr = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
			Random rand = new Random();
			int random = rand.nextInt();
			String temp;
			ArrayList<String> greaterThan5 = new ArrayList();
			for(int i = 0; i < namearr.length; i++) {
				random = rand.nextInt(namearr.length);
				temp = namearr[i];
				namearr[i] = namearr[random];
				namearr[random] = temp;
			}
			for(int i = 0; i < namearr.length; i++) {
				if(namearr[i].length() > 5) {
					greaterThan5.add(namearr[i]);
					System.out.println(namearr[i]);
				}
			}
			return greaterThan5;
	}

	public static void alphabetWork() {
			char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			Random rand = new Random();
			int randnum;
			char temp;
			for(int i = 0; i < alphabet.length; i++) {
				randnum = rand.nextInt(alphabet.length);
				temp = alphabet[i];
				alphabet[i] = alphabet[randnum];
				alphabet[randnum] = temp;
			}
			if(alphabet[0] == 'a' || alphabet[0] == 'e' || alphabet[0] == 'i' || alphabet[0] == 'o' || alphabet[0] == 'u')
				System.out.println("First letter is a vowel!");
			else
				System.out.println("First letter: "+alphabet[0]);
			System.out.println("Last letter: "+alphabet[alphabet.length-1]);
	}

	public static int[] randArr(){
			Random rand = new Random();
			int[] arr = new int[10];
			for(int i = 0; i < 10; i++){
				arr[i] = rand.nextInt(45)+55;
				System.out.println(arr[i]);
			}
			return arr;
	}

	public static int[] sortedRandArr(){
		Random rand = new Random();
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++){
			arr[i] = rand.nextInt(45)+55;
		}
		int temp;
		for(int i=0;i<arr.length;i++){
			for(int x=0;x<arr.length;x++){
				try{
					if(arr[x] > arr[x+1]){
						temp = arr[x];
						arr[x] = arr[x+1];
						arr[x+1] = temp;
						x--;
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					arr[i] = arr[i];
				}
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		return arr;
	}

	public static String randStr(){
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Random rand = new Random();
		String str = "";
		int random;
		for(int i = 5; i >= 0; i--){
			random = rand.nextInt(26)+0;
			str += alphabet[random];
		}
		System.out.println(str);
		return str;
	}

	public static String[] randStrArr(){
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Random rand = new Random();
		String str = "";
		int random;
		String[] stringArr = new String[10];
		for(int x = 0; x < stringArr.length; x++){
			str = "";
			for(int i = 5; i >= 0; i--){
				random = rand.nextInt(26)+0;
				str += alphabet[random];
			}
			stringArr[x] = str;
			System.out.println(stringArr[x]);
		}
		return stringArr;
	}
}