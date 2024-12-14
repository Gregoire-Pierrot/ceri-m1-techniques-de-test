package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokedexFactoryTest {
    private final PokedexFactory pokedexFactory = PokedexFactory.getInstance();
    
    @Test
    public void createPokedexTest(){
        PokemonMetadataProvider metadataProvider = PokemonMetadataProvider.getInstance();
        PokemonFactory pokemonFactory = PokemonFactory.getInstance();
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertEquals(metadataProvider, pokedex.getMetadataProvider());
        assertEquals(pokemonFactory, pokedex.getPokemonFactory());
    }

}
