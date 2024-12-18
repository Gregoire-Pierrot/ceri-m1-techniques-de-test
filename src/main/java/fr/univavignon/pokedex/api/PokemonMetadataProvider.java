package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

/**
 * An PokemonMetadataProvider aims to provide PokemonMetadata
 * for a given pokemon index.
 * 
 * @author fv
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    /** Unique instance of this provider **/
    private static PokemonMetadataProvider instance;
    /** List of pokemon metadatas **/
    public List<PokemonMetadata> pokemonMetadatas;

    /**
     * Returns the unique instance of this provider.
     * 
     * @return The only instance of this provider.
     */
    public static PokemonMetadataProvider getInstance() {
        if (instance == null) {
            instance = new PokemonMetadataProvider();
        }
        return instance;
    }

    /**
     * Private constructor.
     * Initializes the list of pokemon metadatas.
     */
    private PokemonMetadataProvider() {
        this.pokemonMetadatas = new ArrayList<PokemonMetadata>();
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata charmenderMetadata = new PokemonMetadata(3, "Charmender", 126, 126, 90);
        PokemonMetadata aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        pokemonMetadatas.add(bulbizarreMetadata);
        pokemonMetadatas.add(charmenderMetadata);
        pokemonMetadatas.add(aqualiMetadata);
    }
    
    /**
	 * Retrieves and returns the metadata for the pokemon
	 * denoted by the given index.
	 * 
	 * @param index Index of the pokemon to retrieve metadata for.
	 * @return Metadata of the pokemon.
	 * @throws PokedexException If the given index is not valid.
	 */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        for (PokemonMetadata pokemonMetadata : pokemonMetadatas) {
            if (pokemonMetadata.getIndex() == index) {
                return pokemonMetadata;
            }
        }
        throw new PokedexException("No PokemonMetadata with this index: " + index);
    }

}
