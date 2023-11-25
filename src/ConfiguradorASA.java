import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class ConfiguradorASA {
    public static void configurarAcciones(Map<ASA.TableKey, String> accion) {
        accion.put(new ASA.TableKey(0, TipoToken.SELECT), "s2");
        accion.put(new ASA.TableKey(1, TipoToken.EOF), "acc");
        accion.put(new ASA.TableKey(2, TipoToken.DISTINCT), "s13");
        accion.put(new ASA.TableKey(2, TipoToken.ASTERISCO), "s15");
        accion.put(new ASA.TableKey(2, TipoToken.IDENTIFICADOR), "s18");
        accion.put(new ASA.TableKey(3, TipoToken.FROM), "s4");
        accion.put(new ASA.TableKey(4, TipoToken.IDENTIFICADOR), "s7");
        accion.put(new ASA.TableKey(5, TipoToken.EOF), "r1");
        accion.put(new ASA.TableKey(6, TipoToken.COMA), "s11");
        accion.put(new ASA.TableKey(6, TipoToken.EOF), "r14");
        accion.put(new ASA.TableKey(7, TipoToken.IDENTIFICADOR), "s9");
        accion.put(new ASA.TableKey(7, TipoToken.COMA), "r17");
        accion.put(new ASA.TableKey(7, TipoToken.EOF), "r17");
        accion.put(new ASA.TableKey(8, TipoToken.COMA), "r15");
        accion.put(new ASA.TableKey(8, TipoToken.EOF), "r15");
        accion.put(new ASA.TableKey(9, TipoToken.COMA), "r16");
        accion.put(new ASA.TableKey(9, TipoToken.EOF), "r16");
        accion.put(new ASA.TableKey(10, TipoToken.EOF), "r12");
        accion.put(new ASA.TableKey(11, TipoToken.IDENTIFICADOR), "s7");
        accion.put(new ASA.TableKey(12, TipoToken.EOF), "r13");
        accion.put(new ASA.TableKey(13, TipoToken.ASTERISCO), "s15");
        accion.put(new ASA.TableKey(13, TipoToken.IDENTIFICADOR), "s18");
        accion.put(new ASA.TableKey(14, TipoToken.FROM), "r3");
        accion.put(new ASA.TableKey(15, TipoToken.FROM), "r4");
        accion.put(new ASA.TableKey(16, TipoToken.FROM), "r5");
        accion.put(new ASA.TableKey(17, TipoToken.FROM), "r8");
        accion.put(new ASA.TableKey(17, TipoToken.COMA), "s21");
        accion.put(new ASA.TableKey(18, TipoToken.PUNTO), "s24");
        accion.put(new ASA.TableKey(18, TipoToken.FROM), "r11");
        accion.put(new ASA.TableKey(18, TipoToken.COMA), "r11");
        accion.put(new ASA.TableKey(19, TipoToken.FROM), "r2");
        accion.put(new ASA.TableKey(20, TipoToken.FROM), "r6");
        accion.put(new ASA.TableKey(21, TipoToken.IDENTIFICADOR), "s18");
        accion.put(new ASA.TableKey(22, TipoToken.FROM), "r7");
        accion.put(new ASA.TableKey(23, TipoToken.FROM), "r9");
        accion.put(new ASA.TableKey(23, TipoToken.COMA), "r9");
        accion.put(new ASA.TableKey(24, TipoToken.IDENTIFICADOR), "s25");
        accion.put(new ASA.TableKey(25, TipoToken.FROM), "r10");
        accion.put(new ASA.TableKey(25, TipoToken.COMA), "r10");
    }

    public static void configurarIrA(Map<ASA.TableKey2, Integer> ir_a) {
        ir_a.put(new ASA.TableKey2(0, "Q"), 1);
        ir_a.put(new ASA.TableKey2(2, "D"), 3);
        ir_a.put(new ASA.TableKey2(2, "P"), 14);
        ir_a.put(new ASA.TableKey2(2, "A"), 16);
        ir_a.put(new ASA.TableKey2(2, "A2"), 17);
        ir_a.put(new ASA.TableKey2(4, "T"), 5);
        ir_a.put(new ASA.TableKey2(4, "T2"), 6);
        ir_a.put(new ASA.TableKey2(6, "T1"), 10);
        ir_a.put(new ASA.TableKey2(7, "T3"), 8);
        ir_a.put(new ASA.TableKey2(11, "T"), 12);
        ir_a.put(new ASA.TableKey2(11, "T2"), 6);
        ir_a.put(new ASA.TableKey2(13, "P"), 19);
        ir_a.put(new ASA.TableKey2(13, "A"), 16);
        ir_a.put(new ASA.TableKey2(13, "A2"), 17);
        ir_a.put(new ASA.TableKey2(17, "A1"), 20);
        ir_a.put(new ASA.TableKey2(18, "A3"), 23);
        ir_a.put(new ASA.TableKey2(21, "A"), 22);
        ir_a.put(new ASA.TableKey2(21, "A2"), 17);
    }

    public static void configurarProducciones(Map<Integer, String> numeroAProduccion, Map<Integer, Integer> longitudProduccionPorNumero) {
        longitudProduccionPorNumero.put(1, 4);
        longitudProduccionPorNumero.put(2, 2);
        longitudProduccionPorNumero.put(3, 1);
        longitudProduccionPorNumero.put(4, 1);
        longitudProduccionPorNumero.put(5, 1);
        longitudProduccionPorNumero.put(6, 2);
        longitudProduccionPorNumero.put(7, 2);
        longitudProduccionPorNumero.put(8, 0);
        longitudProduccionPorNumero.put(9, 2);
        longitudProduccionPorNumero.put(10, 2);
        longitudProduccionPorNumero.put(11, 0);
        longitudProduccionPorNumero.put(12, 2);
        longitudProduccionPorNumero.put(13, 2);
        longitudProduccionPorNumero.put(14, 0);
        longitudProduccionPorNumero.put(15, 2);
        longitudProduccionPorNumero.put(16, 1);
        longitudProduccionPorNumero.put(17, 0);
    }
}
