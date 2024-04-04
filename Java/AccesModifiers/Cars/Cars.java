public class Cars  {
    int modelYear;
    String modelName;
    int prize;

    //constructor method:
    public Cars(int year, String name, int initialprize) {
      modelYear = year;
      modelName = name;
      prize = initialprize;
  
    }

  public int prizeIncrement(int increment) {
       prize = prize + increment;
       return prize;

  }
  
    public static void main(String[] args) {
      Cars myCar = new Cars(1969, "Mustang" , 2000);
      System.out.println(myCar.modelYear + " " + myCar.modelName + " " + myCar.prize);
      myCar.prizeIncrement(500);
      System.out.println(myCar.modelYear + " " + myCar.modelName + " " + myCar.prize);
      myCar.prizeIncrement(800);
      System.out.println(myCar.modelYear + " " + myCar.modelName + " " + myCar.prize);
    }
  }

