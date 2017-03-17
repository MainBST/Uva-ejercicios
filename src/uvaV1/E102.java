package uvaV1;

import java.util.Scanner;
import java.util.StringTokenizer;
public class E102 {
	public static String cadena;
	public static StringTokenizer st;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		String solucion;
		long minimo, aux;
		while(sc.hasNext()){
			cadena = sc.nextLine();
			minimo = GCB();
			solucion = "GCB";
			aux = GBC();
			if(minimo>=aux){
				minimo = aux;
				solucion = "GBC";
			}
			aux = CGB();
			if(minimo>=aux){
				minimo = aux;
				solucion = "CGB";
			}
			aux = CBG();
			if(minimo>=aux){
				minimo = aux;
				solucion = "CBG";
			}
			aux = BGC();
			if(minimo>=aux){
				minimo = aux;
				solucion = "BGC";
			}
			aux = BCG();
			if(minimo>=aux){
				minimo = aux;
				solucion = "BCG";
			}
			System.out.println(solucion+" "+minimo);
		}

	}
	static long BCG(){
		st = new StringTokenizer(cadena);
    	long con = 1, comp, suma = 0;
		while(st.hasMoreTokens()){
    		comp = Integer.parseInt(st.nextToken());   		
    		if(!(con==1 || con==6 || con==8)){
    			suma = suma + comp;
    		}
    		con++;
    	}
		return suma;
	}
	static long BGC(){
		st = new StringTokenizer(cadena);
		long con = 1, comp, suma = 0;
		while(st.hasMoreTokens()){
    		comp = Integer.parseInt(st.nextToken());
    		if(!(con==1 || con==5 || con==9)){
    			suma = suma + comp;
    		}
    		con++;
    	}
		return suma;
	}
	static long CGB(){
		st = new StringTokenizer(cadena);
		long con = 1, comp, suma = 0;
		while(st.hasMoreTokens()){
    		comp = Integer.parseInt(st.nextToken());
    		if(!(con==3 || con==5 || con==7)){
    			suma = suma + comp;
    		}
    		con++;
    	}
		return suma;
	}
	static long CBG(){
		st = new StringTokenizer(cadena);
		long con = 1, comp, suma = 0;
		while(st.hasMoreTokens()){
    		comp = Integer.parseInt(st.nextToken());
    		if(!(con==3 || con==4 || con==8)){
    			suma = suma + comp;
    		}
    		con++;
    	}
		return suma;
	}
	static long GBC(){
		st = new StringTokenizer(cadena);
		long con = 1, comp, suma = 0;
		while(st.hasMoreTokens()){
    		comp = Integer.parseInt(st.nextToken());
    		if(!(con==2 || con==4 || con==9)){
    			suma = suma + comp;
    		}
    		con++;
    	}
		return suma;
	}
	static long GCB(){
		st = new StringTokenizer(cadena);
		long con = 1, comp, suma = 0;
		while(st.hasMoreTokens()){
    		comp = Integer.parseInt(st.nextToken());
    		if(!(con==2 || con==6 || con==7)){
    			suma = suma + comp;
    		}
    		con++;
    	}
		return suma;
	}
	
}
