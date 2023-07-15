
package Aplicacion;

public class Test {
    public static void main(String[] args) {
        String num = "5";
        double numero = Double.parseDouble(num);
        System.out.println("numero = " + numero);
        if(numero > 1){
            System.out.println("MAYOR = ");
        }else{
            System.out.println("MENOR = ");
        }
    }
}
