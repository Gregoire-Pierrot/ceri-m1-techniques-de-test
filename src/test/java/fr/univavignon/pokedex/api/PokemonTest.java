package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokemonTest {
    private final Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    private final Pokemon Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 5, 100);

    @Test
    public void getCpTest(){
        assertEquals(613, Bulbizarre.getCp());
        assertEquals(2729, Aquali.getCp());
    }

    @Test
    public void getHpTest(){
        assertEquals(64, Bulbizarre.getHp());
        assertEquals(202, Aquali.getHp());
    }

    @Test
    public void getDustTest(){
        assertEquals(4000, Bulbizarre.getDust());
        assertEquals(5000, Aquali.getDust());
    }

    @Test
    public void getCandyTest(){
        assertEquals(4, Bulbizarre.getCandy());
        assertEquals(5, Aquali.getCandy());
    }

    @Test
    public void getIvTest(){
        assertEquals(56, Bulbizarre.getIv(), 0.01);
        assertEquals(100, Aquali.getIv(), 0.01);
    }

}
