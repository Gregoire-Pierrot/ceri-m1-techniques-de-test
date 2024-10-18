package fr.univavignon.pokedex.api;

import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

    private static IPokedex iPokedex;
    private static IPokemonMetadataProvider iPokemonMetadataProvider;
    private static IPokemonFactory iPokedexFactory;

    private IPokedexFactory iPokedexFactory_mocked;

    @Before
    public void setUp(){
        iPokedexFactory_mocked = Mockito.mock(IPokedexFactory.class);
    }

    @Test
    public void testCreatePokedex(){
        Mockito.when(iPokedexFactory_mocked.createPokedex(iPokemonMetadataProvider, iPokedexFactory)).thenReturn(iPokedex);
        assertEquals(iPokedex, iPokedexFactory_mocked.createPokedex(iPokemonMetadataProvider, iPokedexFactory));
    }

}
