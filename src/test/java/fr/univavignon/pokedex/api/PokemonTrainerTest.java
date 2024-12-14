package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokemonTrainerTest {

    private PokemonMetadataProvider pokemonMetadataProvider = PokemonMetadataProvider.getInstance();
    private PokemonFactory pokemonFactory = PokemonFactory.getInstance();
    private Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
    private PokemonTrainer pokemonTrainer = new PokemonTrainer("TrainerTest", Team.INSTINCT, pokedex);

    @Test
    public void getNameTest(){
        assertEquals("TrainerTest", pokemonTrainer.getName());
    }

    @Test
    public void getTeamTest(){
        assertEquals(Team.INSTINCT, pokemonTrainer.getTeam());
    }

    @Test
    public void getPokedexTest(){
        assertEquals(pokedex, pokemonTrainer.getPokedex());
    }
    
}
