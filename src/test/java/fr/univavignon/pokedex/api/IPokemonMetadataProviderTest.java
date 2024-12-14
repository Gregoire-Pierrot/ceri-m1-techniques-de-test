package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider iPokemonMetadataProvider_mocked;

    private Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

    @Before
    public void setUp(){
        iPokemonMetadataProvider_mocked = Mockito.mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(Bulbizarre.getIndex(), Bulbizarre.getName(), Bulbizarre.getAttack(), Bulbizarre.getDefense(), Bulbizarre.getStamina());
        Mockito.when(iPokemonMetadataProvider_mocked.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
        assertEquals(Bulbizarre.getIndex(), iPokemonMetadataProvider_mocked.getPokemonMetadata(0).getIndex());
        assertEquals(Bulbizarre.getName(), iPokemonMetadataProvider_mocked.getPokemonMetadata(0).getName());
        assertEquals(Bulbizarre.getAttack(), iPokemonMetadataProvider_mocked.getPokemonMetadata(0).getAttack());
        assertEquals(Bulbizarre.getDefense(), iPokemonMetadataProvider_mocked.getPokemonMetadata(0).getDefense());
        assertEquals(Bulbizarre.getStamina(), iPokemonMetadataProvider_mocked.getPokemonMetadata(0).getStamina());
    }

}
