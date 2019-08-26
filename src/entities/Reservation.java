package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import entities.exceptions.DomainException;

public class Reservation {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// Static para não instanciar um SimpleDateFormat para cada obj Reservation

	private Integer number;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {

	}

	public Reservation(Integer number, Date checkIn, Date checkOut) throws DomainException{

		if (!checkOut.after(checkIn)) {
			// Se check-out não for depois de check-in
			throw new DomainException(" Check-out date must be after check-in date");
			// Vai gerar um erro se a data de check-out for antes da data de check-in

		}

		this.number = number;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {

		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);

	}

	public void UpdateDates(Date checkIn, Date checkOut) throws DomainException {

		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			// Se a data for antes da da datal de agora ele vai retornar erro
			throw new DomainException("Reservation dates for updates must be future dates ");

		}
		if (!checkOut.after(checkIn)) {
			// Se check-out não for depois de check-in
			throw new DomainException(" Check-out date must be after check-in date");
			// Vai gerar um erro se a data de check-out for antes da data de check-in

		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {

		return "Room: " + number + "\nCheck-In: " + sdf.format(checkIn) + " Check-Out: " + sdf.format(checkOut)
				+ "\nDuration: " + duration();

	}

}
