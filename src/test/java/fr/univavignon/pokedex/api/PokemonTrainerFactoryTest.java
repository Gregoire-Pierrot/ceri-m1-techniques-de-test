package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokemonTrainerFactoryTest {

    @Test
    public void createTrainerTest(){
        PokemonTrainerFactory pokemonTrainerFactory = PokemonTrainerFactory.getInstance();
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("TestTrainer", Team.MYSTIC, PokedexFactory.getInstance());

        assertEquals("TestTrainer", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertEquals(Pokedex.class, pokemonTrainer.getPokedex().getClass());
    }
    
}
