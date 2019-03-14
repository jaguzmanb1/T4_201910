package model.util ; 

import model.vo.VOMovingViolation ; 

public class Sort 
{
	/**
	 * Arreglo auxiliar usado en el mergesort
	 */
	private static Comparable[] auxiliar ; 

	/**
	 * Ordenar datos aplicando el algoritmo ShellSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarShellSort( Comparable[ ] datos ) 
	{
		// TODO implementar el algoritmo ShellSort
		int tam = datos.length ; 
		int h = 1 ; 
		while(h < tam / 3)	
			h = (3 * h) +1 ; 
		while(h >= 1)
		{
			for(int i = h ;  i < tam ;  i++)
			{
				for(int j = i ;  j >= h && less(datos[j], datos[j - h]) ;  j -= h)
				{
					exchange(datos, j, j - h) ; 
				}
			}
			h = h/3 ;  
		}
	}

	/**
	 * Ordenar datos aplicando el algoritmo MergeSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarMergeSort( Comparable[ ] datos ) 
	{
		// TODO implementar el algoritmo MergeSort
		Msort(datos, 0, datos.length) ;  
	}

	/**
	 * Ordenar datos aplicando el algoritmo QuickSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarQuickSort( Comparable[ ] datos ) 
	{
		// TODO implementar el algoritmo QuickSort
		shuffle(datos) ; 
		Qsort(datos, 0, datos.length - 1) ; 
	}
	
	
	/**
	 * Comparar 2 objetos usando la comparacion "natural" de su clase
	 * @param v primer objeto de comparacion
	 * @param w segundo objeto de comparacion
	 * @return true si v es menor que w usando el metodo compareTo. false en caso contrario.
	 */
	private static boolean less(Comparable v, Comparable w)
	{
		// TODO implementar
		return v.compareTo(w) < 0 ; 
	}

	/**
	 * Intercambiar los datos de las posicion i y j
	 * @param datos contenedor de datos
	 * @param i posicion del 1er elemento a intercambiar
	 * @param j posicion del 2o elemento a intercambiar
	 */
	private static void exchange( Comparable[] datos, int i, int j)
	{
		// TODO implementar
		Comparable tmp = datos[i] ;  
		datos[i] = datos[j] ;  
		datos[j] = tmp ; 
	}

	///////////////////////////METODOS DE MERGESORT///////////////////////
	/**
	 * Une dos arreglos organizando los elementos en un tercer arreglo pasado por parametro
	 * @param arreglo a organizar
	 * @param low index inicial.
	 * @param mid index que marca la mitad del arreglo a oredenar
	 * @param high index que marca el final del arreglo a ordenar.
	 */
	public static void merge(Comparable[] arreglo,int low,int mid,int high)
	{
		// Unir los arreglos de[low..mid] con [mid+1..high].   
		int i = low ;  
		int j = mid+1 ;   

		// Copiar desde[low..high] a auxiliar[low..high].
		for (int y = low ;  y  <=  high ;  y ++)        
			auxiliar[y] = arreglo[y] ;   

		// Unir los dos arreglos en el arreglo original, IMPORTANTE::: recordar la precedencia de i++(cuadra i y despues le suma 1) 

		for (int k = low ;  k  <=  high ;  k ++)
		{
			if      (i > mid)              arreglo[k] = auxiliar[j ++] ;       
			else if (j > high )            arreglo[k] = auxiliar[i ++] ;      
			else if (less(auxiliar[j], auxiliar[i])) arreglo[k] = auxiliar[j ++] ;      
			else                           arreglo[k] = auxiliar[i ++] ; 
		}       
	}
	/**
	 * Da una primera instruccion para empezar a organizar el arreglo
	 * @param arr arreglo a organizar
	 * @param low index menor 
	 * @param highindex mayor
	 */
	public static void Msort(Comparable[] arr, int low, int high)
	{
		auxiliar = new Comparable[arr.length] ;     // Crea el espacio del arreglo auxiliar una sola vez,     
		sortR(arr, 0, arr.length - 1) ;  //Lo organiza recursivamente
	}
	/**
	 * Organiza por medio de recursion el arreglo, partiendolo en dos mitades y uniendolas por el metodo merge.
	 * @param arr arreglo de organizar
	 * @param low index menor
	 * @param high index mayor
	 */
	private static void sortR(Comparable[]arr,int low, int high)
	{
		if(high <= low) return ; 
		int mid = low + (high - low) / 2 ;  //Calcula la mitad del arreglo      
		sortR(arr, low, mid) ;        // Organiza la mitad izquierda.      
		sortR(arr, mid + 1, high) ;      //  Organiza la mitad derecha.    
		merge(arr, low, mid, high) ;   //Une las dos mitades
	}
	
	////////////////METODOS DEL QUICKSORT///////////////
	/**
	 * Organiza recursivamente un arreglo dividiendolo por izq y por derecha
	 * @param a
	 * @param low
	 * @param high
	 */
	private static void Qsort(Comparable[] a, int low, int high)
	{
		if(high  <=  low) return ; 
		int j = partition(a, low, high) ; 
		Qsort(a, low, j - 1) ; 
		Qsort(a, j + 1, high) ; 		
	}
	/**
	 * Parte un arreglo en varios sub arreglos y realiza cambios para ordenarlos
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(Comparable[] a, int low, int high)
	{
		int i = low, j = high + 1 ; 
		Comparable v = a[low] ; 
		while(true){
			while(less(a[++ i], v)) if(i == high) break ; 
			while(less(v, a[-- j])) if(j == low) break ; 
			if(i >= j) break ; 
			exchange(a,i,j) ; 
		}
		exchange(a,low,j) ; 
		return j ; 
	}
	/**
	 * Baraja un arreglo aleatoriamente
	 * @param datos
	 */
	private static void shuffle(Comparable[] datos)
	{
		int index=datos.length - 1 ; 
		Comparable<VOMovingViolation> temp ; 
		for (int j = index ; j > 1 ; j--) 
		{
			int aleatorio = (int) (Math.random() * j) ;
			temp=datos[j] ;    
			datos[j]=datos[aleatorio] ; 
			datos[aleatorio]=temp ;   
		}
	}

}
