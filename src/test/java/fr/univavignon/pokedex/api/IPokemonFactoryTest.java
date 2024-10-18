package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

    private IPokemonFactory iPokemonFactory_mocked;
    
    @Before
    public void setUp(){
        iPokemonFactory_mocked = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon(){
        Pokemon pokemonTest = new Pokemon(-1, "PokemonTest", 0, 0, 0, 613, 64, 4000, 4, 56);
        Mockito.when(iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4)).thenReturn(pokemonTest);
        assertEquals(pokemonTest.getIndex(), -1);
        assertEquals(pokemonTest.getCp(), 613);
        assertEquals(pokemonTest.getHp(), 64);
        assertEquals(pokemonTest.getDust(), 4000);
        assertEquals(pokemonTest.getCandy(), 4);
    }
}
