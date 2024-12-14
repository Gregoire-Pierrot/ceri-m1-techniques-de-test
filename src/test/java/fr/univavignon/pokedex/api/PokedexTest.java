package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class PokedexTest {
    private final PokemonMetadataProvider metadataProvider = PokemonMetadataProvider.getInstance();
    private final Pokedex pokedex = new Pokedex(metadataProvider, PokemonFactory.getInstance());
    private final Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    private final Pokemon Charmender = new Pokemon(3, "Charmender", 126, 126, 90, 7813, 64, 4000, 4, 56);
    private final Pokemon Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    
    @Test
    public void getPokemonMetadataTest(){
        assertThrows(PokedexException.class, () -> { pokedex.getPokemonMetadata(-1); });

        try {
            assertEquals(metadataProvider.getPokemonMetadata(0), pokedex.getPokemonMetadata(0));
        } catch (PokedexException e) {
            assertThrows(IllegalArgumentException.class, () -> {});
        }
    }

    @Test
    public void createPokemonTest(){
        PokemonMetadata Bulbizarre_metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        Pokemon pokemon = pokedex.createPokemon(613, 64, 4000, 4, Bulbizarre_metadata);

        assertEquals(Bulbizarre_metadata.getIndex(), pokemon.getIndex());
        assertEquals(Bulbizarre_metadata.getName(), pokemon.getName());
        assertTrue(Bulbizarre_metadata.getAttack() <= pokemon.getAttack() && pokemon.getAttack() <= Bulbizarre_metadata.getAttack() + 15);
        assertTrue(Bulbizarre_metadata.getDefense() <= pokemon.getDefense() && pokemon.getDefense() <= Bulbizarre_metadata.getDefense() + 15);
        assertTrue(Bulbizarre_metadata.getStamina() <= pokemon.getStamina() && pokemon.getStamina() <= Bulbizarre_metadata.getStamina() + 15);
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
    }

    @Test
    public void sizeTest(){
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(Aquali);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void addPokemonTest(){
        assertEquals(0, pokedex.size());
        assertEquals(0, pokedex.addPokemon(Bulbizarre));
        assertEquals(1, pokedex.size());
        assertEquals(1, pokedex.addPokemon(Bulbizarre));
        assertEquals(2, pokedex.size());
        assertEquals(2, pokedex.addPokemon(Aquali));
        assertEquals(3, pokedex.size());
    }

    @Test
    public void getPokemonTest(){
        assertThrows(PokedexException.class, () -> { pokedex.getPokemon(0); });
        int add_bulbizarre1 = pokedex.addPokemon(Bulbizarre);
        int add_bulbizarre2 = pokedex.addPokemon(Bulbizarre);
        int add_aquali = pokedex.addPokemon(Aquali);
        try {
            assertEquals(Bulbizarre, pokedex.getPokemon(add_bulbizarre1));
            assertEquals(Bulbizarre, pokedex.getPokemon(add_bulbizarre2));
            assertEquals(Aquali, pokedex.getPokemon(add_aquali));
        } catch (PokedexException e) {
            assertThrows(IllegalArgumentException.class, () -> {});
        }

        assertThrows(PokedexException.class, () -> { pokedex.getPokemon(pokedex.size()); });
        assertThrows(PokedexException.class, () -> { pokedex.getPokemon(-1); });
    }

    @Test
    public void getPokemonsTest(){
        List<Pokemon> returned_list = pokedex.getPokemons();
        assertEquals(0, returned_list.size());

        pokedex.addPokemon(Aquali);
        pokedex.addPokemon(Bulbizarre);
        returned_list = pokedex.getPokemons();

        assertEquals(2, returned_list.size());
        assertEquals(Aquali, returned_list.get(0));
        assertEquals(Bulbizarre, returned_list.get(1));
    }

    @Test
    public void getPokemonsWithComparator(){
        assertEquals(0, pokedex.size());

        pokedex.addPokemon(Bulbizarre);
        pokedex.addPokemon(Charmender);
        pokedex.addPokemon(Aquali);

        List<Pokemon> sorted_list = pokedex.getPokemons(PokemonComparators.NAME);
        assertEquals(Aquali, sorted_list.get(0));
        assertEquals(Bulbizarre, sorted_list.get(1));
        assertEquals(Charmender, sorted_list.get(2));

        sorted_list = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(Bulbizarre, sorted_list.get(0));
        assertEquals(Charmender, sorted_list.get(1));
        assertEquals(Aquali, sorted_list.get(2));

        sorted_list = pokedex.getPokemons(PokemonComparators.CP);
        assertEquals(Bulbizarre, sorted_list.get(0));
        assertEquals(Aquali, sorted_list.get(1));
        assertEquals(Charmender, sorted_list.get(2));
    }

    @Test
    public void getMetadataProviderTest(){
        assertEquals(metadataProvider, pokedex.getMetadataProvider());
    }

    @Test
    public void getPokemonFactoryTest(){
        assertEquals(PokemonFactory.getInstance(), pokedex.getPokemonFactory());
    }

}
