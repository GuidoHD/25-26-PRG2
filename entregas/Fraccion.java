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

        int mcd = calcularMCD(numerador, denominador){
            this.numerador = numerador/mcd;
            this.denominador = denominador/mcd;
        }

    }


    public Fraccion sumar(Fraccion diferente)

    public Fraccion restar(Fraccion diferente)

    public Fraccion multiplicar(Fraccion diferente)

    public Fraccion dividir(Fraccion diferente)


    public Fraccion inversa()

    public Fraccion opuesta()


    public boolean esIgual()

    public String toString()


}