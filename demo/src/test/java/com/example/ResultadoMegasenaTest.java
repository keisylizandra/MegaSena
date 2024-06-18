package com.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.example.ResultadoMegasena;
import junit.framework.TestCase;

public class ResultadoMegasenaTest extends TestCase {
    private final static int NUMERO_DE_DEZENAS = 6;

  @Test
  public void testObtemUltimoResultado() {
      String[] ultimoResultado = ResultadoMegasena.obtemUltimoResultado();
      assertNotNull(ultimoResultado);
      assertTrue(ultimoResultado.length == NUMERO_DE_DEZENAS);}
}