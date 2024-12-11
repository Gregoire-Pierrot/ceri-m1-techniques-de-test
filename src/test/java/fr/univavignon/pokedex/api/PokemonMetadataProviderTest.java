package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokemonMetadataProviderTest {
    private PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
    PokemonMetadata Bulbizarre_metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    PokemonMetadata Charmender_metadata = new PokemonMetadata(3, "Charmender", 126, 126, 90);
    PokemonMetadata Aquali_metadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);


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
