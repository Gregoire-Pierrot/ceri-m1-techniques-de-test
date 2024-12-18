package fr.univavignon.pokedex.api;

import java.util.Random;

/**
 * Factory class for class that aims to create Pokemon instance.
 *
 * @author fv
 */
public class PokemonFactory implements IPokemonFactory {
    /** The unique instance of this factory **/
    private static PokemonFactory instance;

    /** Private constructor. **/
    private PokemonFactory() { }

    /**
	 * Returns the unique instance of this factory.
	 * 
	 * @return The only instance of this factory.
	 */
    public static PokemonFactory getInstance() {
        if (instance == null) {
            instance = new PokemonFactory();
        }
        return instance;
    }

    /**
	 * Creates a pokemon instance computing it IVs.
	 * 
	 * @param cp Pokemon CP.
	 * @param hp Pokemon HP.
	 * @param dust Required dust for upgrading pokemon.
	 * @param candy Required candy for upgrading pokemon.
	 * @param metadata Requierd metadata for creating a new pokemon.
	 * @return Created pokemon instance.
	 */
    @Override
    public Pokemon createPokemon(final int cp,
                            final int hp,
                            final int dust,
                            final int candy,
                            final PokemonMetadata metadata) {
        Random random = new Random();
        int attackRandom = random.nextInt(16);
        int defenseRandom = random.nextInt(16);
        int staminaRandom = random.nextInt(16);
        return new Pokemon(metadata.getIndex(),
                    metadata.getName(),
                    metadata.getAttack() + attackRandom,
                    metadata.getDefense() + defenseRandom,
                    metadata.getStamina() + staminaRandom,
                    cp,
                    hp,
                    dust,
                    candy,
                    (attackRandom + defenseRandom + staminaRandom) / 45);
    }
    
}
