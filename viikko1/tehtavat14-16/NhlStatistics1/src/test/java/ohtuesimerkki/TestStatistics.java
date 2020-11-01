/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author timot
 */
public class TestStatistics {
    
     Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka k‰ytt‰‰ "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchingExistingPlayer() {
        Player p = stats.search("Semenko");
        assertEquals("Semenko", p.getName());
    }
    
    @Test
    public void searchingNonExistingPlayer() {
        Player p = stats.search("Samanko");
        assertNull(p);
    }
    
    @Test
    public void searchingForTeam() {
        List<Player> players = stats.team("EDM");
        assertTrue(!players.isEmpty());
        assertTrue(players.contains(stats.search("Semenko")));
        assertTrue(players.contains(stats.search("Kurri")));
        assertTrue(players.contains(stats.search("Gretzky")));
        assertFalse(players.contains(stats.search("Yzerman")));        
    }
    
    @Test
    public void searchingForNonexistentTeam() {
        List<Player> players = stats.team(("Jokerit"));
        assertTrue(players.isEmpty());
    }
    
    @Test
    public void searchForTopScorers() {
        List<Player> top = stats.topScorers(2);
        assertEquals(3, top.size());
        assertEquals("Gretzky", top.get(0).getName());
        assertEquals("Lemieux", top.get(1).getName());
    }
    
}
