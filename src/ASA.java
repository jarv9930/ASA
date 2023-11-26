import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class ASA implements Parser {

    public static class TableKey {
        int state;
        TipoToken token;
        TableKey(int state, TipoToken token) {
            this.state = state;
            this.token = token;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TableKey tableKey = (TableKey) o;
            return state == tableKey.state && token == tableKey.token;
        }
        @Override
        public int hashCode() {//devuelve una representación entera del código hash del objeto.
            int result = Integer.hashCode(state);
            result = 31 * result + (token != null ? token.hashCode() : 0);
            return result;
        }
    }

    public static class TableKey2 {
        int state;
        String noTerminal;
        TableKey2(int state, String noTerminal) {
            this.state = state;
            this.noTerminal = noTerminal;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TableKey2 tableKey2 = (TableKey2) o;
            return state == tableKey2.state && noTerminal.equals(tableKey2.noTerminal);
        }
        @Override
        public int hashCode() {//devuelve una representación entera del código hash del objeto.
            int result = Integer.hashCode(state);
            result = 31 * result + (noTerminal != null ? noTerminal.hashCode() : 0);
            return result;
        }
    }

    private int i = 0;
    private Token preanalisis;
    private final List<Token> tokens;
    private final Stack<String> pilaSimbolo = new Stack<>();
    private final Stack<Integer> pilaEstados = new Stack<>();
    private final Map<TableKey, String> accion = new HashMap<>();
    private final Map<TableKey2, Integer> ir_a = new HashMap<>();
    private Map<Integer, String> numeroAProduccion = new HashMap<>();
    private Map<Integer, Integer> longitudProduccionPorNumero = new HashMap<>();

    public ASA(List<Token> tokens) {
        this.tokens = tokens;
        preanalisis = this.tokens.get(i);
        TablaASA.configurarProducciones(numeroAProduccion, longitudProduccionPorNumero);
        TablaASA.configurarAcciones(accion);
        TablaASA.configurarIrA(ir_a);
        //TABLA DE ACCIONES
        pilaEstados.push(0);
        numeroAProduccion.put(1, "Q");
        numeroAProduccion.put(2, "D");
        numeroAProduccion.put(3, "D");
        numeroAProduccion.put(4, "P");
        numeroAProduccion.put(5, "P");
        numeroAProduccion.put(6, "A");
        numeroAProduccion.put(7, "A1");
        numeroAProduccion.put(8, "A1");
        numeroAProduccion.put(9, "A2");
        numeroAProduccion.put(10, "A3");
        numeroAProduccion.put(11, "A3");
        numeroAProduccion.put(12, "T");
        numeroAProduccion.put(13, "T1");
        numeroAProduccion.put(14, "T1");
        numeroAProduccion.put(15, "T2");
        numeroAProduccion.put(16, "T3");
        numeroAProduccion.put(17, "T3");
    }

    @Override
    public boolean parse() {
        while (true) {
            int estadoActual = pilaEstados.peek();
            TableKey tk = new TableKey(estadoActual, preanalisis.tipo);
            String accionActual = accion.get(tk);
            if (accionActual == null) {
                System.out.println("Sintaxis de la cadena no aceptada, realizar chequeo de errores");
                return false;
            } else if ("acc".equals(accionActual)) {//[Q'->Q , $]==cadena valida
                System.out.println("La cadena ingrezada se analizo correctamente :).");
                return true;
            } else if (accionActual.startsWith("s")) {//[A->α°aB, b , a] pertenece a Ii && Ir_A(Ii , a)==Ij Desplazamiento()
                if (!desplazar(accionActual)) {
                    return false;
                }
            } else if (accionActual.startsWith("r")) {//[A->α° , a] pertenece a Ii && A != S Reduccion()
                if (!reducir(accionActual)) {
                    return false;
                }
            }
        }
    }
    private boolean desplazar(String action) {
        String nextStateStr = action.substring(1);
        try {
            int nextState = Integer.parseInt(nextStateStr);
            pilaEstados.push(nextState); // Empuja el número de estado en la pila de estados.
        } catch (NumberFormatException e) {
            System.out.println("Error de conversión numérica, la cadena no es valida");
            return false;
        }
        pilaSimbolo.push(preanalisis.lexema); // Empuja el lexema en la pila de símbolos.
        i++;
        preanalisis = i < tokens.size() ? tokens.get(i) : new Token(TipoToken.EOF, "", tokens.get(tokens.size() - 1).posicion + 1);
        return true;
    }

    private boolean reducir(String accion) {
        int numProduccion = Integer.parseInt(accion.substring(1));
        String noTerminal = numeroAProduccion.get(numProduccion);
        int longitudProduccion = longitudProduccionPorNumero.get(numProduccion);
        // Si la producción no es épsilon, retiramos elementos de la pila de símbolos y estados
        if (longitudProduccion > 0) {
            for (int j = 0; j < longitudProduccion; j++) {
                pilaSimbolo.pop();
                pilaEstados.pop();
            }
        }   
        int estadoInt = pilaEstados.peek();
        Integer irA = ir_a.get(new TableKey2(estadoInt, noTerminal));
        if (irA == null) {
            System.out.println("No se puede realizar el movimiento IR_A, la cadena no es valida");
            return false;
        }
        pilaEstados.push(irA);
        pilaSimbolo.push(noTerminal);
        
        return true;
    }


}