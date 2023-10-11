package com.example.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("pokemon")
public class Pokemon {

    @Id
    private String id;


    private Integer pokemonId;
    private Integer pokedexNumber;
    private String name;
    private String classification;
    private String alternateFormName;
    private Integer originalPokemonId;
    private String legendaryType;
    private Double pokemonHeight;
    private Double pokemonWeight;
    private String primaryType;
    private String secondaryType;
    private String primaryAbility;
    private String primaryAbilityDescription;
    private String secondaryAbility;
    private String secondaryAbilityDescription;
    private String hiddenAbility;
    private String hiddenAbilityDescription;
    private String specialEventAbility;
    private String specialEventAbilityDescription;
    private Double maleRatio;
    private Double femaleRatio;
    private Integer baseHappiness;
    private String gameOfOrigin;
    private Integer healthStat;
    private Integer attackStat;
    private Integer defenseStat;
    private Integer specialAttackStat;
    private Integer specialDefenseStat;
    private Integer speedStat;
    private Integer baseStatTotal;
    private Integer healthEV;
    private Integer attackEV;
    private Integer defenseEV;
    private Integer specialAttackEV;
    private Integer specialDefenseEV;
    private Integer speedEV;
    private Integer evYieldTotal;
    private Integer catchRate;
    private String experienceGrowth;
    private Integer experienceGrowthTotal;
    private String primaryEggGroup;
    private String secondaryEggGroup;
    private Integer eggCycleCount;
    private Integer preEvolutionId;
    private String evolutionDetails;

//    TODO evolution line?
//    private Optional<>




    public Pokemon(String id, Integer pokemonId, Integer pokedexNumber, String name, String classification, String alternateFormName, Integer originalPokemonId, String legendaryType, Double pokemonHeight, Double pokemonWeight, String primaryType, String secondaryType, String primaryAbility, String primaryAbilityDescription, String secondaryAbility, String secondaryAbilityDescription, String hiddenAbility, String hiddenAbilityDescription, String specialEventAbility, String specialEventAbilityDescription, Double maleRatio, Double femaleRatio, Integer baseHappiness, String gameOfOrigin, Integer healthStat, Integer attackStat, Integer defenseStat, Integer specialAttackStat, Integer specialDefenseStat, Integer speedStat, Integer baseStatTotal, Integer healthEV, Integer attackEV, Integer defenseEV, Integer specialAttackEV, Integer specialDefenseEV, Integer speedEV, Integer evYieldTotal, Integer catchRate, String experienceGrowth, Integer experienceGrowthTotal, String primaryEggGroup, String secondaryEggGroup, Integer eggCycleCount, Integer preEvolutionId, String evolutionDetails) {
        super();

        this.id = id;


        this.pokemonId = pokemonId;
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.classification = classification;
        this.alternateFormName = alternateFormName;
        this.originalPokemonId = originalPokemonId;
        this.legendaryType = legendaryType;
        this.pokemonHeight = pokemonHeight;
        this.pokemonWeight = pokemonWeight;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.primaryAbility = primaryAbility;
        this.primaryAbilityDescription = primaryAbilityDescription;
        this.secondaryAbility = secondaryAbility;
        this.secondaryAbilityDescription = secondaryAbilityDescription;
        this.hiddenAbility = hiddenAbility;
        this.hiddenAbilityDescription = hiddenAbilityDescription;
        this.specialEventAbility = specialEventAbility;
        this.specialEventAbilityDescription = specialEventAbilityDescription;
        this.maleRatio = maleRatio;
        this.femaleRatio = femaleRatio;
        this.baseHappiness = baseHappiness;
        this.gameOfOrigin = gameOfOrigin;
        this.healthStat = healthStat;
        this.attackStat = attackStat;
        this.defenseStat = defenseStat;
        this.specialAttackStat = specialAttackStat;
        this.specialDefenseStat = specialDefenseStat;
        this.speedStat = speedStat;
        this.baseStatTotal = baseStatTotal;
        this.healthEV = healthEV;
        this.attackEV = attackEV;
        this.defenseEV = defenseEV;
        this.specialAttackEV = specialAttackEV;
        this.specialDefenseEV = specialDefenseEV;
        this.speedEV = speedEV;
        this.evYieldTotal = evYieldTotal;
        this.catchRate = catchRate;
        this.experienceGrowth = experienceGrowth;
        this.experienceGrowthTotal = experienceGrowthTotal;
        this.primaryEggGroup = primaryEggGroup;
        this.secondaryEggGroup = secondaryEggGroup;
        this.eggCycleCount = eggCycleCount;
        this.preEvolutionId = preEvolutionId;
        this.evolutionDetails = evolutionDetails;
    }

    // Getters
    public String getId() {return id;}
    public int getPokemonId() {
        return pokemonId;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public String getName() {
        return name;
    }

    public String getClassification() {
        return classification;
    }

    public String getAlternateFormName() {
        return alternateFormName;
    }

    public int getOriginalPokemonId() {
        return originalPokemonId;
    }

    public String getLegendaryType() {
        return legendaryType;
    }

    public double getPokemonHeight() {
        return pokemonHeight;
    }

    public double getPokemonWeight() {
        return pokemonWeight;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public String getSecondaryType() {
        return secondaryType;
    }

    public String getPrimaryAbilityDescription() {
        return primaryAbilityDescription;
    }

    public String getSecondaryAbilityDescription() {
        return secondaryAbilityDescription;
    }

    public String getHiddenAbilityDescription() {
        return hiddenAbilityDescription;
    }

    public String getSpecialEventAbilityDescription() {
        return specialEventAbilityDescription;
    }

    public double getMaleRatio() {
        return maleRatio;
    }

    public double getFemaleRatio() {
        return femaleRatio;
    }

    public int getBaseHappiness() {
        return baseHappiness;
    }

    public String getGameOfOrigin() {
        return gameOfOrigin;
    }

    public int getHealthStat() {
        return healthStat;
    }

    public int getAttackStat() {
        return attackStat;
    }

    public int getDefenseStat() {
        return defenseStat;
    }

    public int getSpecialAttackStat() {
        return specialAttackStat;
    }

    public int getSpecialDefenseStat() {
        return specialDefenseStat;
    }

    public int getSpeedStat() {
        return speedStat;
    }

    public int getBaseStatTotal() {
        return baseStatTotal;
    }

    public int getHealthEV() {
        return healthEV;
    }

    public int getAttackEV() {
        return attackEV;
    }

    public int getDefenseEV() {
        return defenseEV;
    }

    public int getSpecialAttackEV() {
        return specialAttackEV;
    }

    public int getSpecialDefenseEV() {
        return specialDefenseEV;
    }

    public int getSpeedEV() {
        return speedEV;
    }

    public int getEvYieldTotal() {
        return evYieldTotal;
    }

    public int getCatchRate() {
        return catchRate;
    }

    public String getExperienceGrowth() {
        return experienceGrowth;
    }

    public int getExperienceGrowthTotal() {
        return experienceGrowthTotal;
    }

    public String getPrimaryEggGroup() {
        return primaryEggGroup;
    }

    public String getSecondaryEggGroup() {
        return secondaryEggGroup;
    }

    public int getEggCycleCount() {
        return eggCycleCount;
    }

    public Integer getPreEvolutionId() {
        return preEvolutionId;
    }

    public String getEvolutionDetails() {
        return evolutionDetails;
    }


    public String getPrimaryAbility() {
        return this.getPrimaryAbility() + ": " + this.getPrimaryAbilityDescription();
    }

    public String getSecondaryAbility() {
        return this.getSecondaryAbility() + ": " + this.getSecondaryAbilityDescription();
    }

    public String getHiddenAbility() {
        return this.getHiddenAbility() + ": " + this.getHiddenAbilityDescription();
    }

    public String getSpecialEventAbility() {
        return this.getSpecialEventAbility() + ": " + this.getSpecialEventAbilityDescription();
    }

    public String getType() {
        return Objects.nonNull(this.getSecondaryType()) ? this.getPrimaryType() + "/" + this.getSecondaryType() : this.getPrimaryType();
    }

//    TODO add extra information to pokedex entry
    public String pokedexEntry(){
        String alternateForm = Objects.isNull(this.alternateFormName) ? "This is the base form of " + this.getName() : "This is an alternate form: " + this.alternateFormName;
        return this.getName() + ": the " + this.getClassification() + ". It is a " + this.getType() + " pokemon. " + alternateForm;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String pokedexEntryDetailed() {

            StringBuilder entry = new StringBuilder();

            // Pokedex number and name
            entry.append("#").append(this.getPokedexNumber()).append(" - ").append(this.getName()).append("\n");

            // Classification
            entry.append(this.getClassification()).append("\n\n");

            // Types
            entry.append("Type: ").append(this.getType());

            entry.append("\n\n");

            // Size and weight
            entry.append("Height: ").append(this.getPokemonHeight()).append(" meters\n");
            entry.append("Weight: ").append(this.getPokemonWeight()).append(" kilograms\n\n");

            // Abilities
            entry.append("Abilities:\n");

            entry.append("1. ").append(this.getPrimaryAbility()).append("\n");

            if (Objects.nonNull(this.getSecondaryAbility())) {
                entry.append("2. ").append(this.getSecondaryAbility()).append("\n");
            }
            if (Objects.nonNull(this.getHiddenAbility())) {
                entry.append("Hidden Ability: ").append(this.getHiddenAbility()).append("\n");
            }
            if (Objects.nonNull(this.getSpecialEventAbility())) {
                entry.append("Special Event Ability: ").append(this.getSpecialEventAbility()).append("\n");
            }
            entry.append("\n");

            // Gender Ratio
            entry.append("Gender Ratio:\n");
            entry.append("- Male: ").append(this.getMaleRatio()).append("%\n");
            entry.append("- Female: ").append(this.getFemaleRatio()).append("%\n\n");

            // Base Stats
            entry.append("Base Stats:\n");
            entry.append("- Health: ").append(this.getHealthStat()).append("\n");
            entry.append("- Attack: ").append(this.getAttackStat()).append("\n");
            entry.append("- Defense: ").append(this.getDefenseStat()).append("\n");
            entry.append("- Special Attack: ").append(this.getSpecialAttackStat()).append("\n");
            entry.append("- Special Defense: ").append(this.getSpecialDefenseStat()).append("\n");
            entry.append("- Speed: ").append(this.getSpeedStat()).append("\n");
            entry.append("- Total: ").append(this.getBaseStatTotal()).append("\n\n");

            // Description
//            entry.append("Description:\n");
//            entry.append(this.getDescription()).append("\n\n");

            // Origins
            entry.append("Origins:\n");
            entry.append("Game(s) of Origin: ").append(this.getGameOfOrigin()).append("\n");
            entry.append("Experience Growth: ").append(this.getExperienceGrowth()).append("\n");
            entry.append("Catch Rate: ").append(this.getCatchRate()).append("\n\n");

            // Egg Groups
            entry.append("Egg Groups:\n");
            if (Objects.nonNull(this.getPrimaryEggGroup())) {
                entry.append("- Primary: ").append(this.getPrimaryEggGroup()).append("\n");
            }
            if (Objects.nonNull(this.getSecondaryEggGroup())) {
                entry.append("- Secondary: ").append(this.getSecondaryEggGroup()).append("\n");
            }
            entry.append("\n");

            // Egg Cycle Count
            entry.append("Egg Cycle Count: ").append(this.getEggCycleCount()).append("\n\n");

            // Evolutionary Line
            entry.append("Evolutionary Line:\n");
            if (Objects.nonNull(this.getPreEvolutionId())) {
                entry.append("- Pre-evolution: ").append(this.getPreEvolutionId()).append("\n");
            }
            if (Objects.nonNull(this.getEvolutionDetails())){
                entry.append("- Evolution Details: ").append(this.getEvolutionDetails()).append("\n");
            }

            return entry.toString();
        }
}
