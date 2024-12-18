package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory {
    private static PokemonFactory instance;

    private PokemonFactory() { }

    public static PokemonFactory getInstance() {
        if (instance == null) {
            instance = new PokemonFactory();
        }
        return instance;
    }

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
