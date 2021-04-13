import java.util.ArrayList;
public class Basics{
	boolean oneTo255(){
		for(int i = 1; i <= 255; i++){
			System.out.println(i);
		}
		return true;
	}

	boolean oddsTo255(){
		for(int i = 1; i < 256; i++){
			if(i%2 != 0){
				System.out.println(i);
			}
		}
		return true;
	}

	boolean printSum(){
		int sum = 0;
		for(int i=1; i < 256; i++){
			sum = sum + i;
			String msg = String.format("New number: %d sum: %d", i, sum);
			System.out.println(msg);
		}
		return true;
	}

	boolean iterateArray(Integer[] x){
		for(int i=0; i < x.length; i++){
			System.out.println(x[i]);
		}
		return true;
	}

	int findMax(Integer[] x){
		int max = x[0];
		for(int i=0; i < x.length; i++){
			if(x[i] > max){
				max = x[i];
			}
		}
    System.out.println(max);
		return max;
	}

	int getAverage(Integer[] x){
		int length = x.length;
		int sum = 0;
		for(int i=0; i < x.length; i++){
			sum += x[i];
		}
    System.out.println(sum / length);
		return (sum / length);
	}

	ArrayList<Integer> oddsArray(){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i < 256; i++){
			if(i % 2 != 0){
				arr.add(i);
			}
		}
    System.out.println(arr);
		return arr;
	}

	int greaterThanY(Integer[] x, int y){
		int count = 0;
		for(int i=0; i < x.length; i++){
			if(x[i] > y){
				count += 1;
			}
		}
    System.out.println(count);
		return count;
	}

	Integer[] squareArray(Integer[] x){
		for(int i=0; i < x.length; i++){
			x[i] = x[i] * x[i];
      System.out.println(x[i]);
		}
		return x;
	}

	Integer[] eliminateNegatives(Integer[] x){
		for(int i=0; i < x.length; i++){
			if(x[i] < 0){
				x[i] = 0;
			}
      System.out.println(x[i]);
		}
		return x;
	}

	Integer[] minMaxAvg(Integer[] x){
		int max = x[0];
		int min = x[0];
		int sum = 0;
		for(int i=0; i < x.length; i++){
			sum += x[i];
			if(x[i] > max){
				max = x[i];
			}
			if(x[i] < min){
				min = x[i];
			}
		}
		Integer[] result = {min, max, (sum / x.length)};
		return result;
	}

	Integer[] shiftValues(Integer[] x){
		for(int i=0; i < x.length - 1; i++){
			x[i] = x[i+1];
		}
		x[x.length - 1] = 0;
		return x;
	}
}