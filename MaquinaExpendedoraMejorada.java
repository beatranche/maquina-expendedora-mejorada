public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Numero de billetes vendidos
    private int numeroBilletesVendidos;
    // Opci�n de m�quina con premio
    private boolean maquinaPremio;
    // N�mero m�ximo de billetes que puede vender
    private int numeroMaximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean maquinaConPremio,int maximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        maquinaPremio = maquinaConPremio;
        numeroMaximoBilletes = maximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroMaximoBilletes > numeroBilletesVendidos){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
        else{
            System.out.println("Se han vendido todos los billetes");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (numeroMaximoBilletes > numeroBilletesVendidos){
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
        
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                numeroBilletesVendidos ++;
                if (maquinaPremio == true){
                    double descuento = 0;
                    descuento = (0.10 * precioBillete);
                    System.out.println("Tiene un descuento de " + descuento + " en compras");
                    
                }
            }
            else {
            System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
            }
        }
        else{
            System.out.println("Se han vendido todos los billetes");
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    /**
     * Vacia el dinero de la m�quina
     */
    public int vaciarDineroDeLaMaquina(){
        int vaciarDinero = 0;
        if (balanceClienteActual <= 0){
            vaciarDinero = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        }
        else{
            System.out.println("Operacion en curso");
            vaciarDinero = -1;
        }
        return vaciarDinero;
    }
    
    /**
     * Devuelve n�mero de billetes vendidos
     */
    public int getNumeroBilletesVendidos(){
        return numeroBilletesVendidos;
    }
    
    /**
     * Imprime numero de billetes vendidos
     */
    public void imprimeNumeroBilletesVendidos(){
        System.out.println("El n�mero de billetes vendidos es " + numeroBilletesVendidos);
    }  
    
}

