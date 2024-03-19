public class Main {

	public static void main(String[] args) {
		
		// inheritance = 	the process where one class acquires,
		//					the attributes and methods of another.
		
		Car car = new Car(true);
		System.out.println("*******************************");
                System.out.println(car.doors);
                System.out.println("*******************************");
		
                car.setDoors(false);
                System.out.println("*******************************");
                System.out.println(car.doors);
                System.out.println("*******************************");
                
                
                car.stop();
		
		Bicycle bike = new Bicycle();
		
		car.go();
		bike.stop();
		
		System.out.println(car.doors);
                System.out.println("El numero de puertas del carro es de:" + car.door);
                System.out.println("El numero de ruedas del carro es de:" + car.wheels);
		System.out.println("El numero de pedales de la biciclta es de:" + bike.pedals);
		System.out.println("El numero de ruedas de la biciclta es de:" + bike.wheels);
				
	}
}