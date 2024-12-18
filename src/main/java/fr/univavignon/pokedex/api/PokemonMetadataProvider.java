package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    private static PokemonMetadataProvider instance;
    public List<PokemonMetadata> pokemonMetadatas;

    public static PokemonMetadataProvider getInstance() {
        if (instance == null) {
            instance = new PokemonMetadataProvider();
        }
        return instance;
    }

    private PokemonMetadataProvider() {
        this.pokemonMetadatas = new ArrayList<PokemonMetadata>();
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata charmenderMetadata = new PokemonMetadata(3, "Charmender", 126, 126, 90);
        PokemonMetadata aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        pokemonMetadatas.add(bulbizarreMetadata);
        pokemonMetadatas.add(charmenderMetadata);
        pokemonMetadatas.add(aqualiMetadata);
    }
    
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        for (PokemonMetadata pokemonMetadata : pokemonMetadatas) {
            if (pokemonMetadata.getIndex() == index) {
                return pokemonMetadata;
            }
        }
        throw new PokedexException("No PokemonMetadata with this index: " + index);
    }

}
