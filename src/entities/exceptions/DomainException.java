package entities.exceptions;

public class DomainException extends Exception {

	private static final long serialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);//Vai repasssar a mensagem para o contrutor da super classe
	}
	
}
