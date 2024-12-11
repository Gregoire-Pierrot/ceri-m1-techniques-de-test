package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private List<Pokemon> pokemons;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory){
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<Pokemon>();
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy, PokemonMetadata metadata) {
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy, metadata);
        addPokemon(pokemon);

        return pokemon;
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        if (pokemons.contains(pokemon)) {
            return -1;
        }
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokemons){
            if (pokemon.getIndex() == id){
                return pokemon;
            }
        }
        throw new PokedexException("No Pokemon in this pokedex for this id:" + id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<Pokemon>(pokemons);
        sortedList.sort(order);
        return sortedList;
    }

    @Override
    public IPokemonMetadataProvider getMetadataProvider(){ return metadataProvider; }

    @Override
    public IPokemonFactory getPokemonFactory(){ return pokemonFactory; }
    
}
