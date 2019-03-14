package model.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.util.Sort;
import model.vo.VOMovingViolation;

public class SortTest 
{

	// Muestra de datos a ordenar
	private Comparable[] datos;

	/**
	 * Monta el escenario para probar los metodos de ordenamiento con datos VOMovingViolation  de  entrada  desorganizados.
	 * @throws Exception
	 */
	@Before
	public void setUp1() throws Exception
	{
   
	}
	/**
	 * Monta el escenario para probar los metodos de ordenamiento con datos String  de  entrada desorganizados.
	 * @throws Exception
	 */
	@Before
	public void setUp2() throws Exception
	{
		datos=new Comparable [10];
		datos[0]="A";
		datos[1]="D";
		datos[2]="F";
		datos[3]="E";
		datos[4]="H";
		datos[5]="G";
		datos[6]="X";
		datos[7]="B";
		datos[8]="C";
		datos[9]="I";     
	}
	/**
	 * Monta el escenario para probar los metodos de ordenamiento con datos int  de  entrada desorganizados.
	 * @throws Exception
	 */
	@Before
	public void setUp3() throws Exception
	{
		datos=new Comparable [10];
		datos[0]=10;
		datos[1]=3;
		datos[2]=1000;
		datos[3]=1;
		datos[4]=9;
		datos[5]=0;
		datos[6]=500;
		datos[7]=501;
		datos[8]=490;
		datos[9]=40;     
	}

	/**
	 *Prueba el metodo ordenarMergeSort con diferentes tipos de datos.
	 */
	@Test
	public void testMerge() 
	{
		try 
		{
			//Con datos tipo VOMovingViolation
			setUp1();
			Sort.ordenarMergeSort(datos);

			boolean rta=isSorted(datos);

			assertTrue("El arreglo no tiene el orden adecuado",rta);
			
			//Con datos tipo String
			setUp2();
			Sort.ordenarMergeSort(datos);

			boolean rta2=isSorted(datos);

			assertTrue("El arreglo no tiene el orden adecuado",rta2);
			
			//Con datos tipo int
			setUp3();
			Sort.ordenarMergeSort(datos);

			boolean rta3=isSorted(datos);

			assertTrue("El arreglo no tiene el orden adecuado",rta3);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Prueba el metodo ordenarShell con diferentes tipos de datos.
	 */
	@Test
	public void testShell() 
	{
		try 
		{
			//Con datos tipo VOMovingViolation
			setUp1();
			Sort.ordenarShellSort(datos);

			boolean rta=isSorted(datos);

			assertTrue("El arreglo no tiene el orden adecuado",rta);
			
			//Con datos tipo String
			setUp2();
			Sort.ordenarShellSort(datos);

			boolean rta2=isSorted(datos);

			assertTrue("El arreglo no tiene el orden adecuado",rta2);
			
			//Con datos tipo int
			setUp3();
			Sort.ordenarShellSort(datos);

			boolean rta3=isSorted(datos);

			assertTrue("El arreglo no tiene el orden adecuado",rta3);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Prueba el metodo ordenarQuick con diferentes tipos de datos.
	 */
	@Test
	public void testQuick() 
	{
		try 
		{
			//Con datos tipo VOMovingViolation
			setUp1();
			Sort.ordenarQuickSort(datos);

			boolean rta=isSorted(datos);

			assertTrue("El arreglo no tiene el orden adecuado",rta);
			
			//Con datos tipo String
			setUp2();
			Sort.ordenarQuickSort(datos);

			boolean rta2=isSorted(datos);

			assertTrue("El arreglo no tiene el orden adecuado",rta2);
			
			//Con datos tipo int
			setUp3();
			Sort.ordenarQuickSort(datos);
			
			boolean rta3=isSorted(datos);

			assertTrue("El arreglo no tiene el orden adecuado",rta3);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Verifica que un arreglo este ordenado
	 * @param a
	 * @return true si el arreglo esta ordenado, false de lo contrario
	 */
	public  boolean isSorted(Comparable[] a)  
	{  // Test whether the array entries are in order.     
		for (int i = 1; i < a.length; i++)        
			if (a[i].compareTo( a[i-1])<0)  
				return false;     
		return true;   
	}
	/**
	 * Imprime el arreglo en consola  
	 * @param a
	 */
	private void show(Comparable[] a)  
	{       
		for (int i = 0; i < a.length; i++)        
			System.out.println(a[i] + " ");      
	}
}



