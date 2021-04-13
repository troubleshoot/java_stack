public class FizzBuzz {
  public String fizzBuzz(int number){
    String output = "";
    if((number % 3 == 0)&&(number % 5 == 0))
      output += "FizzBuzz";
    else if(number % 3 == 0)
      output += "Fizz";
    else if(number % 5 == 0)
      output += "Buzz";
    else
      output += number;
    return output;
  }
}