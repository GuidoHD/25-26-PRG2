package entregas.huidobroMarcos;

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
            denominador = denominador*-1;
        }

        int mcd = calcularMCD(numerador, denominador);
            this.numerador = numerador/mcd;
            this.denominador = denominador/mcd;
        

    }


    private int calcularMCD(int a, int b){
        while (b != 0) {
        int temporal = b;
        b = a % b;
        a = temporal;
    }
    return a;
    }


    public Fraccion sumar(Fraccion secundaria){
        int numerador = (this.numerador*secundaria.denominador)+(this.denominador*secundaria.numerador);
        int denominador = (this.denominador*secundaria.denominador);
        return new Fraccion(numerador, denominador);
    }


    public Fraccion restar(Fraccion secundaria){
        int numerador = (this.numerador*secundaria.denominador)-(this.denominador*secundaria.numerador);
        int denominador = (this.denominador*secundaria.denominador);
        return new Fraccion(numerador, denominador);
    }

    public Fraccion multiplicar(Fraccion secundaria){
        int numerador = this.numerador*secundaria.numerador;
        int denominador = this.denominador*secundaria.denominador;
        return new Fraccion(numerador,denominador);
    }

    public Fraccion dividir(Fraccion secundaria){
        int numerador = this.numerador*secundaria.denominador;
        int denominador = this.denominador*secundaria.numerador;
        return new Fraccion(numerador,denominador);
    }



    public Fraccion oponer(){
        return new Fraccion(-this.numerador,this.denominador);
    }

    public Fraccion invertir(){
        return new Fraccion(this.denominador,this.numerador);
    }


    public boolean esIgual(Fraccion secundaria){
        return this.numerador == secundaria.numerador && this.denominador == secundaria.denominador;
    }


    public String toString(){
        return numerador + "/" + denominador;
    }


}