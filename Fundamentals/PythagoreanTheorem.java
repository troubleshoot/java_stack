public class PythagoreanTheorem {
  public double calculateHypotenuse(int legA, int legB){
    double hypotenuse = Math.sqrt((legA * legA)+(legB * legB));
    return hypotenuse;
  }
}