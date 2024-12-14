package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokemonTrainerFactoryTest {
    private final PokemonTrainerFactory pokemonTrainerFactory = PokemonTrainerFactory.getInstance();

    @Test
    public void createTrainerTest(){
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("TestTrainer", Team.MYSTIC, PokedexFactory.getInstance());

        assertEquals("TestTrainer", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertEquals(Pokedex.class, pokemonTrainer.getPokedex().getClass());
    }

    @Test
    public void getInstanceTest(){
        assertEquals(pokemonTrainerFactory, PokemonTrainerFactory.getInstance());
    }
    
}
