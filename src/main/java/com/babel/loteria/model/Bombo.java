package com.babel.loteria.model;

import java.util.HashMap;
import java.util.Map;

public class Bombo {
    private Map<Integer, Double> numerosGenerados;

    public Bombo () {
        numerosGenerados = new HashMap<>();
        numerosGenerados.put(0, 10.0);
        numerosGenerados.put(1, 10.0);
        numerosGenerados.put(2, 10.0);
        numerosGenerados.put(3, 10.0);
        numerosGenerados.put(4, 10.0);
        numerosGenerados.put(5, 10.0);
        numerosGenerados.put(6, 10.0);
        numerosGenerados.put(7, 10.0);
        numerosGenerados.put(8, 10.0);
        numerosGenerados.put(9, 10.0);
    }
}
