package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//Static para não instanciar um SimpleDateFormat para cada obj Reservation
	
	private Integer number;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {

	}

	public Reservation(Integer number, Date checkIn, Date checkOut) {

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
	
	public void UpdateDates(Date checkIn, Date checkOut) {
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	@Override
	public String toString() {
		
		return "Room: "+number
				+"\nCheck-In: "+sdf.format(checkIn)+" Check-Out: "+sdf.format(checkOut)
				+"\nDuration: "+duration();
		
	}
	
}
