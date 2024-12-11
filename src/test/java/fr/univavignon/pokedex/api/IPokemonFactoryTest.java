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
        Pokemon pokemonTest = new Pokemon(-1, "PokemonTest", 500, 30, 1, 613, 64, 4000, 4, 56);
        PokemonMetadata pokemonTestMetadata = new PokemonMetadata(-1, "PokemonTest", 500, 30, 1);
        Mockito.when(iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4, pokemonTestMetadata)).thenReturn(pokemonTest);

        Pokemon createdPokemon = iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4, pokemonTestMetadata);

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
