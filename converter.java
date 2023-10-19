import java.util.Scanner;

public class Converter {

    public static void tela(){
        System.out.println("--------------Conversor de Sistema Numérico--------------");
        System.out.println("1) Converter decimal para binário\n2) Converter binário para decimal\n3) Converter decimal para hexadecimal\n4) Converter decimal para octal"+
                            "\n5) Sair\n---------------------------------------------------------");
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static int recebeInt(Scanner teclado){
        int n = -1;
        while(n < 0){
            n = teclado.nextInt();
        }
    return n;
    } 

    public static String recebeBin(Scanner teclado){
        String bin = "2";
        boolean binValido = false;
        while(!binValido){
            bin = teclado.nextLine();
            // veririfca se só possui 1 e 0
            if(bin.matches("^[01]+$")) binValido = true;
        }
        return bin;
    }

    public static String converteDecimalParaBinario(int n){
        String bin ="";
        while((double)n / 2.0 > 0){
            bin += Integer.toString(n%2);
            n /= 2;
        }
        return new StringBuilder(bin).reverse().toString();
    }

    public static int convertBinarioParaDecimal(String bin){
        int n = 0;
        bin = new StringBuilder(bin).reverse().toString();
        for(int i = 0; i < bin.length(); i ++){
            if(Character.getNumericValue(bin.charAt(i)) == 1)
            n += Math.pow(2, i);
        }
        return n;
    }
    public static String converteDecimalParaOctal(int n){
        String oct ="";
        while((double)n / 8.0 > 0){
            oct += Integer.toString(n%8);
            n /= 8;
        }
        return new StringBuilder(oct).reverse().toString();
    }

    public static String converteDecimalParaHex(int n){
        if(n == 0) return "0";
        String hex = "";
        while(n > 0){
            if((n % 16) < 10) hex += (char) ('0'+ n % 16);
            else hex += (char)('A' + (n % 16) - 10);
            n /= 16;
        }
        return hex;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int command = 0;
        while(command != 5){
            String bin = "";
            int n = 0;
            tela();
            command = teclado.nextInt();
            clearScreen();
            switch(command){
                case 1: 
                    n = teclado.nextInt();
                    bin = converteDecimalParaBinario(n);
                    System.out.println(bin);
                    break;
                case 2:
                    bin = teclado.nextLine();
                    n = convertBinarioParaDecimal(bin);
                    System.out.println(n);
                    break;
                case 3:
                    n = teclado.nextInt();
                    bin = converteDecimalParaHex(n);
                    System.out.println(bin);
                    break;
                case 4:
                     n = teclado.nextInt();
                    bin = converteDecimalParaOctal(n);
                    System.out.println(bin);
                    break;
            }
        }
        teclado.close();
    }
}
