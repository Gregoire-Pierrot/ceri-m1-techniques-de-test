package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokemonComparatorsTest {
    private Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    private Pokemon Charmender = new Pokemon(3, "Charmender", 126, 126, 90, 7813, 64, 4000, 4, 56);
    private Pokemon Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    @Test
    public void nameCompraratorTest(){
        List<Pokemon> pokemons = Arrays.asList(Bulbizarre, Charmender, Aquali);
        pokemons.sort(PokemonComparators.NAME);

        assertEquals(Aquali, pokemons.get(0));
        assertEquals(Bulbizarre, pokemons.get(1));
        assertEquals(Charmender, pokemons.get(2));
    }

    @Test
    public void indexComparatorTest(){
        List<Pokemon> pokemons = Arrays.asList(Aquali, Bulbizarre, Charmender);
        pokemons.sort(PokemonComparators.INDEX);

        assertEquals(Bulbizarre, pokemons.get(0));
        assertEquals(Charmender, pokemons.get(1));
        assertEquals(Aquali, pokemons.get(2));
    }

    @Test
    public void cpComparatorTest(){
        List<Pokemon> pokemons = Arrays.asList(Bulbizarre, Charmender, Aquali);
        pokemons.sort(PokemonComparators.CP);

        assertEquals(Bulbizarre, pokemons.get(0));
        assertEquals(Aquali, pokemons.get(1));
        assertEquals(Charmender, pokemons.get(2));
    }

}
