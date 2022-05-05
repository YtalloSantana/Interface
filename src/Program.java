import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		System.out.println("enter rental data");
		System.out.println("Car model");
		String carModel = sc.nextLine();
		System.out.println("Pickup (dd/MM/yyyy HH:ss)");
		Date start = sdf.parse(sc.nextLine());
		System.out.println("R  eturn (dd/MM/yyyy HH:ss)");
		Date finish = sdf.parse(sc.nextLine());

		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

		System.out.println("Enter price per hour ");
		double pricePerHour = sc.nextDouble();

		System.out.println("Enter price per day ");
		double pricePerDay = sc.nextDouble();

		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
           
		
rentalService.processInvoice(cr);	
		
	sc.close();
     System.out.println("invoice ");
     System.out.println("Basic Payment" + String.format("%.2f ", cr.getInvoice().getBasicPayment()));
     System.out.println("Tax" + String.format("%.2f ", cr.getInvoice().getTax()));
     System.out.println("Total Payment" + String.format("%.2f ", cr.getInvoice().getTotalPayment()));
	}

	
}
