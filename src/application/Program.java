package application;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import entities.Reservation;
import entities.exceptions.DomainException;

public class Program {

	public static void main(String[] args){

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			int number = Integer.parseInt(JOptionPane.showInputDialog("Enter room number: "));
			Date checkIn = sdf.parse(JOptionPane.showInputDialog("Enter date check-In (dd/MM/yyyy)"));
			Date checkOut = sdf.parse(JOptionPane.showInputDialog("Enter date check-Out (dd/MM/yyyy)"));
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
	
			System.out.println("Update Reservation ");
	
			checkIn = sdf.parse(JOptionPane.showInputDialog("Enter UpDate check-In (dd/MM/yyyy)"));
			checkOut = sdf.parse(JOptionPane.showInputDialog("Enter UpDate check-Out (dd/MM/yyyy)"));
	
			reservation.UpdateDates(checkIn, checkOut);
			// Vai retornar a string
	
			System.out.println("Update");
			System.out.println(reservation);
		}
		catch(ParseException e) {
			
			System.out.println("Invalid date format");
			
		}
		catch (DomainException e) {
			
			System.out.println("Error in resevation"+e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected Error");
		}

	}

}
