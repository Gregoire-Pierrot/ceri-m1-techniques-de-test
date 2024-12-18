package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private List<Pokemon> pokemons;

    public Pokedex(final IPokemonMetadataProvider metadataProvider, final IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<Pokemon>();
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    @Override
    public Pokemon createPokemon(final int cp,
                            final int hp,
                            final int dust,
                            final int candy,
                            final PokemonMetadata metadata) {
        return pokemonFactory.createPokemon(cp, hp, dust, candy, metadata);
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        if (id < 0 || id >= size()) {
            throw new PokedexException("No Pokemon in this pokedex for this id:" + id);
        }
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<Pokemon>(pokemons);
        sortedList.sort(order);
        return sortedList;
    }

    @Override
    public IPokemonMetadataProvider getMetadataProvider() { return metadataProvider; }

    @Override
    public IPokemonFactory getPokemonFactory() { return pokemonFactory; }
    
}
