package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

    private IPokemonFactory iPokemonFactory_mocked;
    private Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    private Pokemon Charmender = new Pokemon(3, "Charmender", 126, 126, 90, 7813, 64, 4000, 4, 56);
    private Pokemon Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    
    @Before
    public void setUp(){
        iPokemonFactory_mocked = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon(){
        Pokemon pokemonTest = new Pokemon(-1, "PokemonTest", 0, 0, 0, 613, 64, 4000, 4, 56);
        Mockito.when(iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4)).thenReturn(pokemonTest);
        assertEquals(-1, iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4).getIndex());
        assertEquals(613, iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4).getCp());
        assertEquals(64, iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4).getHp());
        assertEquals(4000, iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4).getDust());
        assertEquals(4, iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4).getCandy());
        assertEquals(56, iPokemonFactory_mocked.createPokemon(-1, 613, 64, 4000, 4).getIv());

        List<Pokemon> pokemonList = new ArrayList<Pokemon>();
        pokemonList.add(Bulbizarre);
        pokemonList.add(Charmender);
        pokemonList.add(Aquali);

        List<Pokemon> pokemonList_Name = new ArrayList<Pokemon>();
        pokemonList_Name.add(Aquali);
        pokemonList_Name.add(Bulbizarre);
        pokemonList_Name.add(Charmender);

        List<Pokemon> pokemonList_Index = pokemonList;

        List<Pokemon> pokemonList_CP = new ArrayList<Pokemon>();
        pokemonList_CP.add(Charmender);
        pokemonList_CP.add(Aquali);
        pokemonList_CP.add(Bulbizarre);

        Collections.sort(pokemonList, PokemonComparators.NAME);
        assertEquals(pokemonList_Name, pokemonList);
        Collections.sort(pokemonList, PokemonComparators.INDEX);
        assertEquals(pokemonList_Index, pokemonList);
        Collections.sort(pokemonList, PokemonComparators.CP);
        assertEquals(pokemonList_Name, pokemonList);
    }
}
