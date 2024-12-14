package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokemonMetadataTest {
    private PokemonMetadata pokemonMetadata1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    private PokemonMetadata pokemonMetadata2 = new PokemonMetadata(3, "Charmender", 126, 126, 90);
    private PokemonMetadata pokemonMetadata3 = new PokemonMetadata(133, "Aquali", 186, 168, 260);

    
    @Test
    public void getIndexTest(){
        assertEquals(0, pokemonMetadata1.getIndex());
        assertEquals(3, pokemonMetadata2.getIndex());
        assertEquals(133, pokemonMetadata3.getIndex());
    }

    @Test
    public void getNameTest(){
        assertEquals("Bulbizarre", pokemonMetadata1.getName());
        assertEquals("Charmender", pokemonMetadata2.getName());
        assertEquals("Aquali", pokemonMetadata3.getName());
    }

    @Test
    public void getAttackTest(){
        assertEquals(126, pokemonMetadata1.getAttack());
        assertEquals(126, pokemonMetadata2.getAttack());
        assertEquals(186, pokemonMetadata3.getAttack());
    }

    @Test
    public void getDefenseTest(){
        assertEquals(126, pokemonMetadata1.getDefense());
        assertEquals(126, pokemonMetadata2.getDefense());
        assertEquals(168, pokemonMetadata3.getDefense());
    }

    @Test
    public void getStaminaTest(){
        assertEquals(90, pokemonMetadata1.getStamina());
        assertEquals(90, pokemonMetadata2.getStamina());
        assertEquals(260, pokemonMetadata3.getStamina());
    }

}
