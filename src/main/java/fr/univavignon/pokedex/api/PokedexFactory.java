package fr.univavignon.pokedex.api;

/**
 * Factory class for class that aims to create IPokedex instance.
 *
 * @author Grégoire Pierrot
 */
public class PokedexFactory implements IPokedexFactory {
    /** Unique instance of this factory **/
    private static PokedexFactory instance;
    
    /** private constructor. **/
    private PokedexFactory() { }

    /**
	 * Returns the unique instance of this factory.
	 * 
	 * @return The only instance of this factory.
	 */
    public static PokedexFactory getInstance() {
        if (instance == null) {
            instance = new PokedexFactory();
        }
        return instance;
    }
    
    /**
	 * Creates a new pokedex instance using the given 
	 * metadataProvider and pokemonFactory. 
	 * 
	 * @param metadataProvider Metadata provider the created pokedex will use.
	 * @param pokemonFactory Pokemon factory the created pokedex will use.
	 * @return Created pokedex instance.
	 */
    @Override
    public IPokedex createPokedex(final IPokemonMetadataProvider metadataProvider,
                        final IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
