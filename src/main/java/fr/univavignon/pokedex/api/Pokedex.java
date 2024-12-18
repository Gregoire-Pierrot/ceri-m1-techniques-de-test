package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pokedex class. An Pokedex aims to store all information about
 * captured pokemon, as their default metadata as well.
 * 
 * @author Pierrot Grégoire
 */
public class Pokedex implements IPokedex {
    /** Metadata provider. **/
    private IPokemonMetadataProvider metadataProvider;
    /** Pokemon factory. **/
    private IPokemonFactory pokemonFactory;
    /** List of captured pokemon. **/
    private List<Pokemon> pokemons;

    /**
	 * Create a new instance of Pokedex.
	 * 
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
	 */
    public Pokedex(final IPokemonMetadataProvider metadataProvider, final IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<Pokemon>();
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
        return metadataProvider.getPokemonMetadata(index);
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
        return pokemonFactory.createPokemon(cp, hp, dust, candy, metadata);
    }
    
    /**
	 * Returns the number of pokemon this pokedex contains.
	 * 
	 * @return Number of pokemon in this pokedex.
	 */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
	 * Adds the given pokemon to this pokedex and returns
	 * it unique index.
	 * 
	 * @param pokemon Pokemon to add to this pokedex.
	 * @return Index of this pokemon relative to this pokedex.
	 */
    @Override
    public int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    /**
	 * Locates the pokemon identified by the given id.
	 * 
	 * @param id Unique pokedex relative identifier.
	 * @return Pokemon denoted by the given identifier.
	 * @throws PokedexException If the given index is not valid.
	 */
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        if (id < 0 || id >= size()) {
            throw new PokedexException("No Pokemon in this pokedex for this id:" + id);
        }
        return pokemons.get(id);
    }

    /**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * 
	 * @return Unmodifiable list of all pokemons.
	 */
    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    /**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * The list view will be sorted using the given order.
	 * 
	 * @param order Comparator instance used for sorting the created view.
	 * @return Sorted unmodifiable list of all pokemons.
	 */
    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<Pokemon>(pokemons);
        sortedList.sort(order);
        return sortedList;
    }

    /**
	 * Returns the PokemonMetadataProvider.
	 * 
	 * @return IPokemonMetadataProvider.
	 */
    @Override
    public IPokemonMetadataProvider getMetadataProvider() { return metadataProvider; }

    /**
	 * Returns the PokemonFactory.
	 * 
	 * @return IPokemonFactory.
	 */
    @Override
    public IPokemonFactory getPokemonFactory() { return pokemonFactory; }
    
}
