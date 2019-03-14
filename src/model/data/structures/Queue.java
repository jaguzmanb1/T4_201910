package model.data.structures;


public class Queue<T extends Comparable<T>>  implements IQueue<T> 
{
	
	/**
	 * Nodo con referencia al primer elemento añadido a la cola
	 */
	private Node<T> primero;
	/**
	 * Nodo con referencia al ultimo elemento añadido de la cola
	 */
	private Node<T> ultimo;
	/**
	 * Entero con el tamaño de la cola
	 */
	private int tamano;
	/**
	 * Constructor de la clase
	 */
    public Queue() 
	{
		// TODO Auto-generated constructor stub
    	primero=null;
    	ultimo=null;
    	tamano=0;
	}
	
	@Override
	public IteratorCola<T> iterator() 
	{
		// TODO Auto-generated method stub
		return new IteratorCola<>(primero);
	}

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return primero==null;
	}

	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return tamano;
	}

	@Override
	public void enqueue(T t)
	{
		// TODO Auto-generated method stub
		Node<T> antiguoUltimo=ultimo; 
	    ultimo = new Node<T>(t,null);                 
		if (isEmpty()) primero = ultimo;      
		else    antiguoUltimo.setSiguiente(ultimo); 
		tamano++; 
	}

	@Override
	public T dequeue() 
	{
	
	   T elemento=primero.getElemento();
	   primero=primero.getSiguiente();
	   if(isEmpty())ultimo=null;
	   tamano--;
	   return elemento;
	}

}
