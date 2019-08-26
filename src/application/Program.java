package application;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws HeadlessException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int number = Integer.parseInt(JOptionPane.showInputDialog("Enter room number: "));
		Date checkIn = sdf.parse(JOptionPane.showInputDialog("Enter date check-In (dd/MM/yyyy)"));
		Date checkOut = sdf.parse(JOptionPane.showInputDialog("Enter date check-Out (dd/MM/yyyy)"));

		if (!checkOut.after(checkIn)) {
			// Se check-out não for depois de check-in
			System.out.println("Error in reservation: Check-out date must be after check-in date");
			// Vai gerar um erro se a data de check-out for antes da data de check-in

		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println("Update Reservation ");

			checkIn = sdf.parse(JOptionPane.showInputDialog("Enter UpDate check-In (dd/MM/yyyy)"));
			checkOut = sdf.parse(JOptionPane.showInputDialog("Enter UpDate check-Out (dd/MM/yyyy)"));
			
			

			String error = reservation.UpdateDates(checkIn, checkOut);
			//Vai retornar a string
			
			if (error!= null) {
				System.out.println("Error in reservation: "+error);
				//Se der erro vai ser quem vai retornar o erro
			}else {
				System.out.println("Update");
				System.out.println(reservation);
			}
			

		}
	}

}
