package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokedexFactoryTest {
    private final PokedexFactory pokedexFactory = PokedexFactory.getInstance();
    
    @Test
    public void createPokedexTest(){
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = PokemonFactory.getInstance();
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);

        assertEquals(pokemonMetadataProvider, pokedex.getMetadataProvider());
        assertEquals(pokemonFactory, pokedex.getPokemonFactory());
    }

}
