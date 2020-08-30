package uva.volumen1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class E101 {
    public static StringTokenizer st;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,n = sc.nextInt();
        String o1,o2;
        String s[] = new String[n];
        s = llenar(s, n);
        while(!(o1=sc.next()).equals("quit")){
            a = sc.nextInt();
            o2 = sc.next();
            b = sc.nextInt();
            if(!((a==b) || (buscar(s, n, a)==buscar(s, n, b)))){
                if(o1.equals("move")){
                    if(o2.equals("onto")) s = moveOnto(s, n, a, b);
                    else s = moveOver(s, n, a, b);
                }else{
                    if(o2.equals("onto")) s = pileOnto(s, n, a, b);
                    else s = pileOver(s, n, a, b);
                }
            }
        }
        imprimir(s, n);
    }
    static String[] llenar(String[] s, int n){
        for (int i = 0; i < n; i++) {
            s[i] = " "+i;
        }
        return s;
    }
    static void imprimir(String[] s, int n){
        for (int i = 0; i < n; i++) {
            System.out.println(i+":"+s[i]);
        }
    }
    static int buscar(String[] s, int n, int p){
        int comp;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(s[i]);
            while(st.hasMoreTokens()){
                comp = Integer.parseInt(st.nextToken());
                if(p==comp){
                    p = i;
                    return i;
                }
            }
        }
        return -1;
    }
    static String[] reorganizar(String[] s,int pc, int p){
        boolean con = false;
        int comp;
        String copia = "";
        st = new StringTokenizer(s[pc]);
        while(st.hasMoreTokens()){
            comp = Integer.parseInt(st.nextToken());
            if(con){
                s[comp] = " "+comp+""+s[comp];
            }else{
                if(comp==p){
                    copia = copia+" "+comp;
                    con = true;
                }else{
                    copia = copia+" "+comp;
                }
            }
        }
        s[pc] = copia;
        return s;
    }
    static String[] remover(String[] s, int pc, int p){
        String nuevo = "";
        int comp;
        st = new StringTokenizer(s[pc]);
        while(st.hasMoreTokens()){
            comp = Integer.parseInt(st.nextToken());
            if(comp==p){
                break;
            }else{
                nuevo = nuevo+" "+comp;
            }
        }
        s[pc] = nuevo;
        return s;
    }
    static String[] moveOnto(String[] s, int n, int a, int b){
        int pa = buscar(s,n,a), pb = buscar(s,n,b);
        s = reorganizar(s, pa, a);
        s = reorganizar(s, pb, b);
        s[pb] = s[pb]+" "+a;
        s = remover(s, pa, a);
        return s;
    }
    static String[] moveOver(String[] s, int n, int a, int b){
        int pa = buscar(s,n,a), pb = buscar(s,n,b);
        s = reorganizar(s, pa, a);
        s[pb] = s[pb]+" "+a;
        s = remover(s, pa, a);
        return s;
    }
    static String[] pileOnto(String[] s, int n, int a, int b){
        int pb = buscar(s,n,b);
        s = reorganizar(s, pb, b);
        s = pileOver(s, n, a, b);
        return s;
    }
    static String[] pileOver(String[] s, int n, int a, int b){
        int pa = buscar(s,n,a), pb = buscar(s,n,b), comp;
        String nuevo = "", viejo = "";
        boolean con = false;
        st = new StringTokenizer(s[pa]);
        while(st.hasMoreTokens()){
            comp = Integer.parseInt(st.nextToken());
            if(con){
                nuevo = nuevo+" "+comp;
            }else{
                if(comp==a){
                    con = true;
                    nuevo = nuevo+" "+comp;
                }else{
                    viejo = viejo+" "+comp;
                }

            }
        }
        s[pa] = viejo;
        s[pb] = s[pb]+nuevo;
        return s;
    }
}
