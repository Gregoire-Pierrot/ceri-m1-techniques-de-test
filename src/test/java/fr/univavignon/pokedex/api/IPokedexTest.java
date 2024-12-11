package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IPokedexTest {

    private IPokedex iPokedex_mocked;
    private Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    private Pokemon Charmender = new Pokemon(3, "Charmender", 126, 126, 90, 7813, 64, 4000, 4, 56);
    private Pokemon Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    @Before
    public void setUp(){
        iPokedex_mocked = Mockito.mock(IPokedex.class);
    }

    @Test
    public void testSize(){
        Mockito.when(iPokedex_mocked.size()).thenReturn(151);
        assertEquals(151, iPokedex_mocked.size());
    }

    @Test
    public void testAddPokemon(){
        Mockito.when(iPokedex_mocked.addPokemon(Bulbizarre)).thenReturn(0);
        Mockito.when(iPokedex_mocked.addPokemon(Aquali)).thenReturn(133);
        assertEquals(0, iPokedex_mocked.addPokemon(Bulbizarre));
        assertEquals(133, iPokedex_mocked.addPokemon(Aquali));
    }

    @Test
    public void testGetPokemon() throws PokedexException{
        Mockito.when(iPokedex_mocked.getPokemon(1)).thenThrow(new PokedexException("Pokedex Execption"));
        assertThrows(PokedexException.class, () -> iPokedex_mocked.getPokemon(1));

        Mockito.when(iPokedex_mocked.getPokemon(0)).thenReturn(Bulbizarre);
        Mockito.when(iPokedex_mocked.getPokemon(133)).thenReturn(Aquali);
        assertEquals(Bulbizarre, iPokedex_mocked.getPokemon(0));
        assertEquals(Aquali, iPokedex_mocked.getPokemon(133));
    }

    @Test
    public void testGetPokemons(){
        List<Pokemon> emptyList = new ArrayList<Pokemon>();
        Mockito.when(iPokedex_mocked.getPokemons()).thenReturn(emptyList);
        assertEquals(emptyList, iPokedex_mocked.getPokemons());

        List<Pokemon> list = new ArrayList<Pokemon>();
        list.add(Bulbizarre);
        list.add(Aquali);
        Mockito.when(iPokedex_mocked.getPokemons()).thenReturn(list);
        assertEquals(list, iPokedex_mocked.getPokemons());
    }

    @Test
    public void testGetPokemonsWithComparator(){
        List<Pokemon> nameList = new ArrayList<Pokemon>();
        nameList.add(Aquali);
        nameList.add(Bulbizarre);
        nameList.add(Charmender);

        List<Pokemon> indexList = new ArrayList<Pokemon>();
        indexList.add(Bulbizarre);
        indexList.add(Charmender);
        indexList.add(Aquali);

        List<Pokemon> cpList = new ArrayList<Pokemon>();
        cpList.add(Charmender);
        cpList.add(Aquali);
        cpList.add(Bulbizarre);

        Mockito.when(iPokedex_mocked.getPokemons(PokemonComparators.NAME)).thenReturn(nameList);
        Mockito.when(iPokedex_mocked.getPokemons(PokemonComparators.INDEX)).thenReturn(indexList);
        Mockito.when(iPokedex_mocked.getPokemons(PokemonComparators.CP)).thenReturn(cpList);
        assertEquals(nameList, iPokedex_mocked.getPokemons(PokemonComparators.NAME));
        assertEquals(indexList, iPokedex_mocked.getPokemons(PokemonComparators.INDEX));
        assertEquals(cpList, iPokedex_mocked.getPokemons(PokemonComparators.CP));
    }
}
