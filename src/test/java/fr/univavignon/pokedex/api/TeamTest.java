package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class TeamTest {
    
    @Test
    public void testTeamValues() {
        Team[] teams = Team.values();
        assertEquals(3, teams.length);
        assertEquals(Team.MYSTIC, teams[0]);
        assertEquals(Team.INSTINCT, teams[1]);
        assertEquals(Team.VALOR, teams[2]);
    }

    @Test
    public void testTeamValueOf() {
        assertEquals(Team.MYSTIC, Team.valueOf("MYSTIC"));
        assertEquals(Team.INSTINCT, Team.valueOf("INSTINCT"));
        assertEquals(Team.VALOR, Team.valueOf("VALOR"));
    }

    @Test
    public void testInvalidTeamValueOf() {
        assertThrows(IllegalArgumentException.class, () -> { Team.valueOf("UNKNOW"); });
    }

    @Test
    public void testTeamToString() {
        assertEquals("MYSTIC", Team.MYSTIC.toString());
        assertEquals("INSTINCT", Team.INSTINCT.toString());
        assertEquals("VALOR", Team.VALOR.toString());
    }

}
