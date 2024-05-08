package com.babel.loteria.servicio;

import com.babel.loteria.exception.LoteriaException;
import com.babel.loteria.repositorio.ILoteriaDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteriaService {
    private final ILoteriaDB loteriaDB;

    public LoteriaService(ILoteriaDB loteriaDB) {
        this.loteriaDB = loteriaDB;
    }

    public List<String> getListaGanadores () {
        return loteriaDB.getNumerosGanadores();
    }

    public List<String> getListaGanadores (int numGanadores) {
        List<String> ganadores = getListaGanadores();
        if (numGanadores > ganadores.size()) {
            return ganadores;
        }
        return ganadores.subList(ganadores.size()-numGanadores, ganadores.size());
    }

    public boolean addGanador (String ganador) throws LoteriaException{
        //validaciones
        if (ganador == null) {
            throw new LoteriaException("El numero no puede ser null");
        }

        if (ganador.length() != 5) {
            throw new LoteriaException("El numero de dígitos no es el adecuado");
        }

        if (!ganador.matches("\\d+")) {
            throw new LoteriaException("Algún caracter no es un dígito");
        }

        return loteriaDB.addNumeroGanador(ganador);
    }





}
