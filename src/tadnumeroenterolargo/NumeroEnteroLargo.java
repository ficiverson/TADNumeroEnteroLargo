/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadnumeroenterolargo;

/**
 *
 * @author Eloy
 */
public class NumeroEnteroLargo {

    String NumeroEnteroLargo;
    int[] arrayNum;
    int largo;

    public NumeroEnteroLargo(String NumeroEnteroLargo) {
        this.NumeroEnteroLargo = NumeroEnteroLargo;
        largo = this.NumeroEnteroLargo.length();
        arrayNum = new int[largo];

        for (int i = 0; i < arrayNum.length; i++) {
            String cadaNumero = NumeroEnteroLargo.substring(i, i + 1);
            arrayNum[i] = Integer.parseInt(cadaNumero);
        }
    }

    public NumeroEnteroLargo() {
        this.NumeroEnteroLargo = "0";
        largo = this.NumeroEnteroLargo.length();
        arrayNum = new int[largo];

        for (int i = 0; i < arrayNum.length; i++) {
            String cadaNumero = NumeroEnteroLargo.substring(i, i + 1);
            arrayNum[i] = Integer.parseInt(cadaNumero);
        }
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < this.largo; i++) {
            aux += arrayNum[i];
        }
        return aux;
    }

    public int getLargo() {
        return largo;
    }

    public void cambiarValor(String nuevoNumeroEnteroLargo) {
        this.NumeroEnteroLargo = nuevoNumeroEnteroLargo;
        largo = this.NumeroEnteroLargo.length();
        arrayNum = new int[largo];

        for (int i = 0; i < arrayNum.length; i++) {
            String cadaNumero = NumeroEnteroLargo.substring(i, i + 1);
            arrayNum[i] = Integer.parseInt(cadaNumero);

        }
    }

    public NumeroEnteroLargo suma(NumeroEnteroLargo otro) {
        NumeroEnteroLargo resultado = new NumeroEnteroLargo();
        //calculamos el largo del nuevo NumeroEnteroLargo resultado de la suma
        int largo1 = this.getLargo();
        int largo2 = otro.getLargo();
        int largoSuma;

        if (largo1 > largo2) {
            largoSuma = largo1 + 1;
        } else {
            largoSuma = largo2 + 1;
        }

        resultado.largo = largoSuma;
        resultado.arrayNum = new int[largoSuma];

        //sumamos los valores numero a número según la posición en el array
        int suma = 0;
        int llevo = 0;
        int i = largo1 - 1;
        int j = largo2 - 1;
        int k = largoSuma - 1;

        while (i >= 0 && j >= 0) {
            suma = this.arrayNum[i] + otro.arrayNum[j] + llevo;
            i--;
            j--;
            resultado.arrayNum[k] = suma % 10;
            suma = suma / 10;
            llevo = suma % 10;
            k--;
        }

        while (i >= 0) {            //si numero1 es mayor que numero2
            suma = this.arrayNum[i] + llevo;
            resultado.arrayNum[k] = suma % 10;
            suma = suma / 10;
            llevo = suma % 10;
            i--;
            k--;

        }
        while (j >= 0) {            //si numero2 es mayor que numero1
            suma = otro.arrayNum[j] + llevo;
            resultado.arrayNum[k] = suma % 10;
            suma = suma / 10;
            llevo = suma % 10;
            j--;
            k--;

        }

        resultado.arrayNum[k] = llevo;

        return resultado;

    }

    public NumeroEnteroLargo resta(NumeroEnteroLargo otro) throws Exception {
        NumeroEnteroLargo resultado = new NumeroEnteroLargo();
        //calculamos longitud del nuevo NumeroEnteroLargo resultado de la resta
        int largo1 = this.getLargo();
        int largo2 = otro.getLargo();
        int largoResta = largo1;

        if (largo1 < largo2) { //CAMBIAR A SI ES MAYOR EL NUMERO AL CREAR EL METODO
            throw new NumeroNegativoException("No es posible restar, resultado numero negativo");
        }

        resultado.largo = largoResta;
        resultado.arrayNum = new int[largoResta];

        //restamos los valores numero a número según la posición en el array
        int resta = 0;
        int llevoUna = 0;
        int i = largo1 - 1;
        int j = largo2 - 1;
        int k = largoResta - 1;

        while (i >= 0 && j >= 0) {
            if (this.arrayNum[i] + llevoUna >= otro.arrayNum[j]) {
                resta = this.arrayNum[i] + llevoUna - otro.arrayNum[j];
                i--;
                j--;
                resultado.arrayNum[k] = resta;
                k--;
            } else {
                resta = this.arrayNum[i] + llevoUna + 10 - otro.arrayNum[j];
                llevoUna = 1;
                i--;
                j--;
                resultado.arrayNum[k] = resta;
                k--;
            }
        }

        while (i >= 0) {            //si numero1 es mayor que numero2
            resta = this.arrayNum[i] + llevoUna;
            llevoUna = 0;
            resultado.arrayNum[k] = resta;
            i--;
            k--;

        }

        return resultado;

    }

////Restar dos objetos NumerosEnteroLargo. El resultado es un nuevo NumeroEnteroLargo.
//    public NumeroEnteroLargo resta(NumeroEnteroLargo otroNumeroEnteroLargo) {
//        NumeroEnteroLargo restaNumeroEnteroLargo = new NumeroEnteroLargo();
//        //creo un NumeroEnteroLargo del largo del mayor de los 2
//        if (this.largo >= otroNumeroEnteroLargo.largo) {
//            restaNumeroEnteroLargo.arrayNum = new int[this.largo];
//        } else {
//            restaNumeroEnteroLargo.arrayNum = new int[otroNumeroEnteroLargo.largo];
//        }
//        //resto cada posición de los arrays de los 2 NumerosLargos
//        int llevoUna = 0;
//        for (int i = 0; i < restaNumeroEnteroLargo.largo; i++) {
//            if (this.arrayNum[i] + llevoUna > otroNumeroEnteroLargo.arrayNum[i]) {
//                restaNumeroEnteroLargo.arrayNum[i] = this.arrayNum[i] + 10 - otroNumeroEnteroLargo.arrayNum[i];
//                llevoUna = 1;
//            } else {
//                restaNumeroEnteroLargo.arrayNum[i] = this.arrayNum[i] - otroNumeroEnteroLargo.arrayNum[i];
//                llevoUna = 0;
//            }
//
//        }
//        return restaNumeroEnteroLargo;
//    }
}
