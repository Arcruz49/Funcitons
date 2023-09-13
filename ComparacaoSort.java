public class ComparacaoSort {

    public static void selecao(int[] v) {
        int contFor = 0;
        int contIf = 0;
        for (int i = 0; i < v.length-1; i++) { 
            int menor = i;
            for (int j = i + 1; j < v.length; j++) { 
                contFor++;
                if (v[j] < v[menor]) {
                    menor = j;
                }
            }
            if(i != menor){
                int aux = v[i];
                v[i] = v[menor];
                v[menor] = aux;
                contIf++;
            }
        } 
        System.out.printf("Número de repetições nos for: %d\n",contFor);
        System.out.printf("Número de comparações no if: %d\n",contIf);

    }

    public static void ImprimeVetor(int[] vet){
        for (int i = 0; i < vet.length; i ++) {
            String valor = vet[i] == vet[vet.length - 1] ? Integer.toString(vet[i])+"\n" : vet[i]+",";
            System.out.printf(valor);
        }
    }

    public static void selectionSort(int[] arr){  
        int contFor = 0;
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
                contFor++;
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
        System.out.printf("Número de repetições nos for: %d\n",contFor);

    }  

    public static void ImprimeTesteCaso1(int[] vet){
        System.out.print("Original: ");
        ImprimeVetor(vet);
        selecao(vet);
        System.out.print("Ordenado: ");
        ImprimeVetor(vet);
    }

    public static void ImprimeTesteCaso2(int[] vet){
        System.out.print("Original: ");
        ImprimeVetor(vet);
        selectionSort(vet);
        System.out.print("Ordenado: ");
        ImprimeVetor(vet);
    }
    public static void main(String[] args) throws Exception {

        int[] vetMelhorCaso1 = {1,2,3,4,5};
        int[] vetPiorCaso1 = {5,4,3,2,1};

        System.out.println("\n\nSELECTION DO PROFESSOR: ");
        System.out.println("-------------Melhor caso-----------");
        ImprimeTesteCaso1(vetMelhorCaso1);
        System.out.println("-------------Pior caso-------------");
        ImprimeTesteCaso1(vetPiorCaso1);

        int[] vetMelhorCaso2 = {1,2,3,4,5};
        int[] vetPiorCaso2 = {5,4,3,2,1};

        System.out.println("\n\nSELECTION NORMAL: ");
        System.out.println("-------------Melhor caso-----------");
        ImprimeTesteCaso2(vetMelhorCaso2);
        System.out.println("-------------Pior caso-------------");
        ImprimeTesteCaso2(vetPiorCaso2);

    }
}
