package com.babel.loteria.repositorio;

import com.babel.loteria.model.Bombo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoteriaDB implements ILoteriaDB{
    private List<Bombo> bombos;
    private List<String> numerosGanadores;

    public LoteriaDB () {
        bombos = crearBombos();
        numerosGanadores = new ArrayList<>();
    }

    private List<Bombo> crearBombos () {
        List<Bombo> bombos =  new ArrayList<>();
        bombos.add(new Bombo());
        bombos.add(new Bombo());
        bombos.add(new Bombo());
        bombos.add(new Bombo());
        bombos.add(new Bombo());

        return bombos;
    }

    @Override
    public List<String> getNumerosGanadores() {
        return numerosGanadores;
    }
    @Override
    public List<Bombo> getBombos() {
        return bombos;
    }
    @Override
    public boolean addNumeroGanador(String numero) {
        return numerosGanadores.add(numero);
    }
}
