package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory {
    private static PokemonFactory instance;

    private PokemonFactory() {}

    public static PokemonFactory getInstance(){
        if (instance == null){
            instance = new PokemonFactory();
        }
        return instance;
    }

    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy, PokemonMetadata metadata){
        Random random = new Random();
        int attack_random = random.nextInt(16);
        int defense_random = random.nextInt(16);
        int stamina_random = random.nextInt(16);
        return new Pokemon(index, metadata.getName(), metadata.getAttack() + attack_random, metadata.getDefense() + defense_random, metadata.getStamina() + stamina_random, cp, hp, dust, candy, (attack_random + defense_random + stamina_random) / 45);
    }
    
}
