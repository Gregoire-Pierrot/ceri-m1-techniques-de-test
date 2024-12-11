package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    private static PokemonTrainerFactory instance;

    private PokemonTrainerFactory(){}

    public static PokemonTrainerFactory getInstance(){
        if (instance == null){
            instance = new PokemonTrainerFactory();
        }
        return instance;
    }

    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory){
        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), PokemonFactory.getInstance());
        return new PokemonTrainer(name, team, pokedex);
    }
    
}
