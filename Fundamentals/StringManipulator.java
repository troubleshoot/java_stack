public class StringManipulator {
  public String trimAndConcat(String first, String second){
    first = first.trim();
    second = second.trim();
    first = first.concat(second);
    return first;
  }

  public Integer getIndexOrNull(String text, String letter){
    int index = text.indexOf(letter);
    if(index == -1)
      return null;
    return index;
  }

  public String concatSubstring(String first, int one, int two, String second){
    String substr = first.substring(one,two);
    substr = substr.concat(second);
    return substr;
  }
}