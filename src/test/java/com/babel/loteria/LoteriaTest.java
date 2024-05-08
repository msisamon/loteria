package com.babel.loteria;

import com.babel.loteria.servicio.ILoteriaService;
import com.babel.loteria.servicio.LoteriaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class LoteriaTest {
    @InjectMocks
    LoteriaService servicioPadre;
    @Mock
    ILoteriaService servicioLoteria;
    @Test
    public void whenIntroduzcoNumeroThenReturnListaGanadoresSizeNumero() {
        // Given
        Integer numResutlados = 6;

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("00001");
        expectedResult.add("00002");
        expectedResult.add("00003");
        expectedResult.add("00004");
        expectedResult.add("00005");
        expectedResult.add("00006");

        // When

        List<String> mockitoGanadores = new ArrayList<>();
        expectedResult.add("00000");
        expectedResult.add("00000");
        expectedResult.add("00000");
        expectedResult.add("00000");
        expectedResult.add("00000");
        expectedResult.add("00000");
        expectedResult.add("00001");
        expectedResult.add("00002");
        expectedResult.add("00003");
        expectedResult.add("00004");
        expectedResult.add("00005");
        expectedResult.add("00006");

        Mockito.when(servicioLoteria.getListaGanadores().thenReturn(mockitoGanadores));

        List<Integer> listaRes = servicioLoteria.obtenerListadoGanadores(numResultados);

        // Then
        Assertions.assertEquals(expectedResult, listaRes);
    }
}
