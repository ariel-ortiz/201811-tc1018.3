package mx.itesm.cem.examen2;

import java.util.EnumSet;
import static mx.itesm.cem.examen2.Tributo.*;

public class EjemploEnumSet {

    enum Estacion {
        PRIMAVERA, VERANO, OTOÑO, INVIERNO
    }

    enum Sexo {
        FEMENINO, MASCULINO
    }

    public static void main(String[] args) {
        Tributo t = Tributo.RUE;
        System.out.println(t);
        System.out.println(t.ordinal());
        for (Estacion e : Estacion.values()) {
            System.out.println(e + " " + e.ordinal());
        }
        EnumSet<Tributo> s = EnumSet.of(KATNISS, RUE);
        System.out.println(s);
        s.remove(RUE);
        System.out.println(s);
        s.add(CLOVE);
        System.out.println(s);
    }
}
