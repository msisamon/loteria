package com.babel.loteria.repositorio;

import com.babel.loteria.model.Bombo;

import java.util.List;

public interface ILoteriaDB {
    List<String> getNumerosGanadores();

    List<Bombo> getBombos();

    boolean addNumeroGanador(String numero);
}
