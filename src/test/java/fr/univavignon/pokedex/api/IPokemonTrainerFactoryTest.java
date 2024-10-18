package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory iPokemonTrainerFactory_mocked;

    IPokedex iPokedex;
    IPokedexFactory iPokedexFactory;
    PokemonTrainer pokemonTrainer = new PokemonTrainer("TrainerTest", Team.MYSTIC, iPokedex);

    @Before
    public void setUp(){
        iPokemonTrainerFactory_mocked = Mockito.mock(IPokemonTrainerFactory.class);
    }

    @Test
    public void testCreateTrainer(){
        Mockito.when(iPokemonTrainerFactory_mocked.createTrainer("TrainerTest", Team.MYSTIC, iPokedexFactory)).thenReturn(pokemonTrainer);
        assertEquals(pokemonTrainer.getName(), iPokemonTrainerFactory_mocked.createTrainer("TrainerTest", Team.MYSTIC, iPokedexFactory).getName());
        assertEquals(pokemonTrainer.getTeam(), iPokemonTrainerFactory_mocked.createTrainer("TrainerTest", Team.MYSTIC, iPokedexFactory).getTeam());
        assertEquals(pokemonTrainer.getPokedex(), iPokemonTrainerFactory_mocked.createTrainer("TrainerTest", Team.MYSTIC, iPokedexFactory).getPokedex());
    }
    
}
