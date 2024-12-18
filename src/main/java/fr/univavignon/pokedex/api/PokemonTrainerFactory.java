package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create PokemonTrainer instance.
 * 
 * @author Pierrot Grégoire
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    /** The unique instance of this factory. **/
    private static PokemonTrainerFactory instance;

    /** Private constructor. **/
    private PokemonTrainerFactory() { }

    /**
     * Returns the unique instance of the PokemonTrainerFactory.
     * 
     * @return The only instance of this factory.
     */
    public static PokemonTrainerFactory getInstance() {
        if (instance == null) {
            instance = new PokemonTrainerFactory();
        }
        return instance;
    }

    /**
	 * Creates and returns a PokemonTrainer instance.
	 * 
	 * @param name Name of the created trainer.
	 * @param team Team of the created trainer.
	 * @param pokedexFactory Factory to use for creating associated pokedex instance.
	 * @return Created trainer instance.
	 */
    @Override
    public PokemonTrainer createTrainer(final String name, final Team team, final IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(PokemonMetadataProvider.getInstance(),
                                                PokemonFactory.getInstance());
        return new PokemonTrainer(name, team, pokedex);
    }
    
}
