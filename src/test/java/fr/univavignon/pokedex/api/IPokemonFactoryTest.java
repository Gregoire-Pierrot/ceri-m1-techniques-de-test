package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

    private IPokemonFactory iPokemonFactory_mocked;
    private Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    private Pokemon Charmender = new Pokemon(3, "Charmender", 126, 126, 90, 7813, 64, 4000, 4, 56);
    private Pokemon Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    
    @Before
    public void setUp(){
        iPokemonFactory_mocked = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon(){
        Pokemon pokemonTest = new Pokemon(-1, "PokemonTest", 0, 0, 0, 613, 64, 4000, 4, 56);
        Mockito.when(iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4)).thenReturn(pokemonTest);

        Pokemon createdPokemon = iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4);

        assertEquals(-1, createdPokemon.getIndex());
        assertEquals(613, createdPokemon.getCp());
        assertEquals(64, createdPokemon.getHp());
        assertEquals(4000, createdPokemon.getDust());
        assertEquals(4, createdPokemon.getCandy());
        assertEquals(56.0, createdPokemon.getIv(), 0.0001);

        assertEquals(0, PokemonComparators.NAME.compare(pokemonTest, createdPokemon));
        assertEquals(0, PokemonComparators.INDEX.compare(pokemonTest, createdPokemon));
        assertEquals(0, PokemonComparators.CP.compare(pokemonTest, createdPokemon));
    }
}
