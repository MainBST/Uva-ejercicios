package uvaV1;

import java.util.Scanner;
public class E100 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,j;
        while(sc.hasNext()){
            i = sc.nextInt();
            j = sc.nextInt();
            System.out.println(i+" "+j+" "+ciclo_mayor(i,j));
        }
    }
    static int ciclo_mayor(int menor, int mayor){
        int con,valor;
        if(mayor<menor){
            con = menor;
            menor = mayor;
            mayor = con;
        }
        con = 0;
        for(int i = menor;i<=mayor;i++){
            valor = ciclos(i);
            if(con<valor){
                con = valor;
            }
        }
        return con;
    }
    static int ciclos (int n){
        int con = 1;
        while(n>1){
            con++;
            if(n%2 != 0){
                n = 3*n + 1;
            }else{
                n = n / 2;
            }
        }
        return con;
    }
}
