package entregas;

class Fraccion{

    private int numerador;
    private int denominador;

    public Fraccion(){
        this.numerador = 0;
        this.denominador = 1;
    }


    public Fraccion(int numerador, int denominador){

        if(denominador == 0){
            denominador = 1;
        }

        if (denominador < 0){
            numerador = numerador*-1;
            denominador = -denominador*-1;
        }


    }



}