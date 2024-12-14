package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    private static PokemonMetadataProvider instance;
    public List<PokemonMetadata> pokemonMetadatas;

    public static PokemonMetadataProvider getInstance(){
        if (instance == null){
            instance = new PokemonMetadataProvider();
        }
        return instance;
    }

    private PokemonMetadataProvider() {
        this.pokemonMetadatas = new ArrayList<PokemonMetadata>();
        PokemonMetadata Bulbizarre_metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata Charmender_metadata = new PokemonMetadata(3, "Charmender", 126, 126, 90);
        PokemonMetadata Aquali_metadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        pokemonMetadatas.add(Bulbizarre_metadata);
        pokemonMetadatas.add(Charmender_metadata);
        pokemonMetadatas.add(Aquali_metadata);
    }
    
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        for (PokemonMetadata pokemonMetadata : pokemonMetadatas){
            if (pokemonMetadata.getIndex() == index){
                return pokemonMetadata;
            }
        }
        throw new PokedexException("No PokemonMetadata with this index: " + index);
    }

}
