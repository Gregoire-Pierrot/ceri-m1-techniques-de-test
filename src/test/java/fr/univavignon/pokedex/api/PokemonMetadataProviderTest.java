package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokemonMetadataProviderTest {
    private final PokemonMetadataProvider pokemonMetadataProvider = PokemonMetadataProvider.getInstance();

    @Test
    public void getPokemonMetadataTest(){
        assertThrows(PokedexException.class, () ->{ pokemonMetadataProvider.getPokemonMetadata(-1); });
        assertThrows(PokedexException.class, () ->{ pokemonMetadataProvider.getPokemonMetadata(1); });

        try {
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(0);
            assertEquals(0, pokemonMetadata.getIndex());
            assertEquals("Bulbizarre", pokemonMetadata.getName());
            assertEquals(126, pokemonMetadata.getAttack());
            assertEquals(126, pokemonMetadata.getDefense());
            assertEquals(90, pokemonMetadata.getStamina());
        } catch (PokedexException e) {
            assertThrows(IllegalArgumentException.class, () -> {});
        }

        try {
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(3);
            assertEquals(3, pokemonMetadata.getIndex());
            assertEquals("Charmender", pokemonMetadata.getName());
            assertEquals(126, pokemonMetadata.getAttack());
            assertEquals(126, pokemonMetadata.getDefense());
            assertEquals(90, pokemonMetadata.getStamina());
        } catch (PokedexException e) {
            assertThrows(IllegalArgumentException.class, () -> {});
        }

        try {
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(133);
            assertEquals(133, pokemonMetadata.getIndex());
            assertEquals("Aquali", pokemonMetadata.getName());
            assertEquals(186, pokemonMetadata.getAttack());
            assertEquals(168, pokemonMetadata.getDefense());
            assertEquals(260, pokemonMetadata.getStamina());
        } catch (PokedexException e) {
            assertThrows(IllegalArgumentException.class, () -> {});
        }

    }
    
}
