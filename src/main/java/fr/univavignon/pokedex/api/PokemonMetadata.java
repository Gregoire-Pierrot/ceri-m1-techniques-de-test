package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO.
 * 
 * @author fv
 */
public class PokemonMetadata {

	/** Pokemon index. **/
    private final int index;

	/** Pokemon name. **/
    private final String name;

	/** Pokemon attack level. **/
    private final int attack;

	/** Pokemon defense level. **/
    private final int defense;

	/** Pokemon stamina level. **/
    private final int stamina;

	/**
	 * Default constructor.
	 * 
	 * @param index Pokemon index.
	 * @param name Pokemon name.
	 * @param attack Attack level.
	 * @param defense Defense level.
	 * @param stamina Stamina level.
	 */
    public PokemonMetadata(final int index, final String name, final int attack, final int defense, final int stamina) {
        this.index = index;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.stamina = stamina;
    }
	
    /**
     * Retrieves and returns the index of this pokemon metadata.
     * 
     * @return Index of this pokemon metadata.
     */
    public int getIndex() {
        return index;
    }
	
    /**
     * Retrieves and returns the name of this pokemon metadata.
     * 
     * @return Name of this pokemon metadata.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves and returns the attack level of this pokemon metadata.
     * 
     * @return Attack level of this pokemon metadata.
     */
    public int getAttack() {
        return attack;
    }
    
    /**
     * Retrieves and returns the defense level of this pokemon metadata.
     * 
     * @return Defense level of this pokemon metadata.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Retrieves and returns the stamina level of this pokemon metadata.
     * 
     * @return Stamina level of this pokemon metadata.
     */
    public int getStamina() {
        return stamina;
    }

}
