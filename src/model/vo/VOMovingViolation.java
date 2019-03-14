package model.vo;


/**
 * Representation of a MovingViolation object
 */
public class VOMovingViolation implements Comparable<VOMovingViolation> {

	// TODO Definir los atributos de una infraccion


	/**
	 * Metodo constructor
	 */
	private int id;
	private String location;
	private String ticketIssueDate;
	private int totalPaid;
	private String accidentIndicator;
	private String violationDescription;

	public VOMovingViolation(int pId, String pLocation, String pTicketIssueDate, int pTotalPaid, String pAccidentIndicator,String pViolationDescription){
		id=pId;
		location=pLocation;
		ticketIssueDate=pTicketIssueDate;
		totalPaid=pTotalPaid;
		accidentIndicator=pAccidentIndicator;
		violationDescription=pViolationDescription;
	}	

	/**
	 * @return id - Identificador unico de la infraccion
	 */
	public int objectId() {
		// TODO Auto-generated method stub
		return id;
	}	


	/**
	 * @return location - Direccion en formato de texto.
	 */
	public String getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	/**
	 * @return date - Fecha cuando se puso la infraccion .
	 */
	public String getTicketIssueDate() {
		// TODO Auto-generated method stub
		return ticketIssueDate;
	}

	/**
	 * @return totalPaid - Cuanto dinero efectivamente paga el que recibio la infraccion en USD.
	 */
	public int getTotalPaid() {
		// TODO Auto-generated method stub
		return totalPaid;
	}

	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {
		// TODO Auto-generated method stub
		return accidentIndicator;
	}

	/**
	 * @return description - Descripcion textual de la infraccion.
	 */
	public String  getViolationDescription() {
		// TODO Auto-generated method stub
		return violationDescription;
	}

	@Override
	public int compareTo(VOMovingViolation o) {
		//13 ticketIssueDate | 1 objectId

		int respuesta=1;
		if(getTicketIssueDate().compareTo(o.getTicketIssueDate())>0){
			respuesta=1;
		}
		else if(getTicketIssueDate().compareTo(o.getTicketIssueDate())<0){
			respuesta=-1;
		}
		else{
			if(objectId()>o.objectId()){
				respuesta=1;
			}
			else if(objectId()<o.objectId()){
				respuesta=-1;
			}
		}
		// TODO implementar la comparacion "natural" de la clase
		return respuesta;
	}

	public String toString()
	{
		// TODO Convertir objeto en String (representacion que se muestra en la consola)
		return id + " - " + location  +" - " + ticketIssueDate + " - " + totalPaid + " - "+violationDescription;
	} 
}