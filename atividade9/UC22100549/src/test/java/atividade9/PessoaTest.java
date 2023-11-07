package atividade9;

import org.junit.Test;
import static org.junit.Assert.assertEquals; // Importe o método assertEquals

public class PessoaTest {

    @Test
    public void testDizerOla() {
        Pessoa pessoa = new Pessoa();
        String mensagem = pessoa.dizerOla();
        assertEquals("Olá, Mundo!", mensagem);
    }
}
