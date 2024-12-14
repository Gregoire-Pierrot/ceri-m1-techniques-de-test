package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokemonFactoryTest {
    private final PokemonFactory pokemonFactory = PokemonFactory.getInstance();
    private final PokemonMetadata Bulbizarre_metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    private final PokemonMetadata Charmender_metadata = new PokemonMetadata(3, "Charmender", 126, 126, 90);
    private final PokemonMetadata Aquali_metadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);


    @Test
    public void createPokemonTest(){
        Pokemon pokemon1 = pokemonFactory.createPokemon(613, 64, 4000, 4, Bulbizarre_metadata);
        Pokemon pokemon2 = pokemonFactory.createPokemon(7813, 64, 4000, 4, Charmender_metadata);
        Pokemon pokemon3 = pokemonFactory.createPokemon(2729, 202, 5000, 5, Aquali_metadata);

        assertEquals(Bulbizarre_metadata.getIndex(), pokemon1.getIndex());
        assertEquals(Bulbizarre_metadata.getName(), pokemon1.getName());
        assertTrue(Bulbizarre_metadata.getAttack() <= pokemon1.getAttack() && pokemon1.getAttack() <= Bulbizarre_metadata.getAttack() + 15);
        assertTrue(Bulbizarre_metadata.getDefense() <= pokemon1.getDefense() && pokemon1.getDefense() <= Bulbizarre_metadata.getDefense() + 15);
        assertTrue(Bulbizarre_metadata.getStamina() <= pokemon1.getStamina() && pokemon1.getStamina() <= Bulbizarre_metadata.getStamina() + 15);
        assertEquals(613, pokemon1.getCp());
        assertEquals(64, pokemon1.getHp());
        assertEquals(4000, pokemon1.getDust());
        assertEquals(4, pokemon1.getCandy());
        assertTrue(0 <= pokemon1.getIv() && pokemon1.getIv() <= 45);

        assertEquals(3, pokemon2.getIndex());
        assertEquals(Charmender_metadata.getName(), pokemon2.getName());
        assertTrue(Charmender_metadata.getAttack() <= pokemon2.getAttack() && pokemon2.getAttack() <= Charmender_metadata.getAttack() + 15);
        assertTrue(Charmender_metadata.getDefense() <= pokemon2.getDefense() && pokemon2.getDefense() <= Charmender_metadata.getDefense() + 15);
        assertTrue(Charmender_metadata.getStamina() <= pokemon2.getStamina() && pokemon2.getStamina() <= Charmender_metadata.getStamina() + 15);
        assertEquals(7813, pokemon2.getCp());
        assertEquals(64, pokemon2.getHp());
        assertEquals(4000, pokemon2.getDust());
        assertEquals(4, pokemon2.getCandy());
        assertTrue(0 <= pokemon2.getIv() && pokemon2.getIv() <= 45);

        assertEquals(133, pokemon3.getIndex());
        assertEquals(Aquali_metadata.getName(), pokemon3.getName());
        assertTrue(Aquali_metadata.getAttack() <= pokemon3.getAttack() && pokemon3.getAttack() <= Aquali_metadata.getAttack() + 15);
        assertTrue(Aquali_metadata.getDefense() <= pokemon3.getDefense() && pokemon3.getDefense() <= Aquali_metadata.getDefense() + 15);
        assertTrue(Aquali_metadata.getStamina() <= pokemon3.getStamina() && pokemon3.getStamina() <= Aquali_metadata.getStamina() + 15);
        assertEquals(2729, pokemon3.getCp());
        assertEquals(202, pokemon3.getHp());
        assertEquals(5000, pokemon3.getDust());
        assertEquals(5, pokemon3.getCandy());
        assertTrue(0 <= pokemon3.getIv() && pokemon3.getIv() <= 45);
    }
    
}
