package com.example.springboot;

import com.example.springboot.model.Pokemon;
import com.example.springboot.repository.PokemonRepository;
import com.mongodb.client.FindIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@EnableMongoRepositories
public class Application implements CommandLineRunner{

    @Autowired
    PokemonRepository pokemonRepo;

    List<Pokemon> pokemonList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        System.out.println("\n----------------SHOW ALL POKEMON---------------------------\n");
//
//        showAllPokemon();
//
//        System.out.println("\n--------------GET POKEMON BY NAME 'Ivysaur' -----------------------------------\n");
//
//        getPokemonByName("Ivysaur");
//
//        System.out.println("\n-----------GET POKEMON BY TYPE 'Poison'---------------------------------\n");
//
//        getPokemonByType("Poison");
//
//        System.out.println("\n-----------GET POKEMON BY POKEDEX NUMBER '1' ---------------------------------\n");
//
//        getPokemonByPokedexNumber(1);

        System.out.println("Starting spring-boot application...");

    }

    public void createPokemon(){
        System.out.println("Data creation started...");
        pokemonRepo.save(new Pokemon(
                //TODO find a way to get ObjectID instead of using name
                "Ivysaur",
                2,                         // Pokemon Id
                2,                         // Pokedex Number
                "Ivysaur",                 // Pokemon Name
                "Seed Pokémon",            // Classification
                null,                      // Alternate Form Name
                null,                      // Original Pokemon ID
                null,                      // Legendary Type
                1.0,                       // Pokemon Height
                13.0,                      // Pokemon Weight
                "Grass",                   // Primary Type
                "Poison",                  // Secondary Type
                "Overgrow",
                "Powers up Grass-type moves when the Pokémon's HP is low.",  // Primary Ability Description
                null,
                null,// Secondary Ability Description
                "Chlorophyll",
                "Boosts the Pokémon's Speed stat in harsh sunlight.",         // Hidden Ability Description
                null,
                null, // Special Event Ability Description
                87.5,                      // Male Ratio
                12.5,                      // Female Ratio
                50,                        // Base Happiness
                "Red",                     // Game(s) of Origin
                60,                        // Health Stat
                62,                        // Attack Stat
                63,                        // Defense Stat
                80,                        // Special Attack Stat
                80,                        // Special Defense Stat
                60,                        // Speed Stat
                405,                       // Base Stat Total
                0,                         // Health EV
                0,                         // Attack EV
                0,                         // Defense EV
                1,                         // Special Attack EV
                1,                         // Special Defense EV
                0,                         // Speed EV
                2,                         // EV Yield Total
                45,                        // Catch Rate
                "Medium Slow",             // Experience Growth
                1059860,                   // Experience Growth Total
                "Monster",                 // Primary Egg Group
                "Grass",                   // Secondary Egg Group
                20,                        // Egg Cycle Count
                1,                         // Pre-Evolution Pokemon ID
                "Evolves at level 16"               // Evolution Details
        ));
        System.out.println("Data creation complete");
    }

    public void showAllPokemon(){
        pokemonList = pokemonRepo.findAll();

        pokemonList.forEach((pkmn) -> System.out.println(pkmn.getName()));
    }

    public void findCountOfPokemon() {
        long count = pokemonRepo.count();
        System.out.println("Number of documents in the collection = " + count);
    }

    public void getPokemonByName(String name){
        Pokemon p = pokemonRepo.findPokemonByName(name);

        if (Objects.nonNull(p)) {
            System.out.println(p.pokedexEntry());
        }
    }

    public void getPokemonByType(String type){
        List<Pokemon> allOfType = pokemonRepo.findPokemonByPrimaryOrSecondaryType(type);

        allOfType.forEach((p) -> System.out.println(p.getName()));
    }

    public void getPokemonByPokedexNumber(Integer num){
        if (num < 1 || num > 1008){
            System.out.println("Invalid Pokedex Number");
        }

        Pokemon p = pokemonRepo.findPokemonByPokedexNumber(num);

        if (Objects.nonNull(p)) {
            System.out.println(p.pokedexEntry());
        }
        else {
            System.out.println("Couldn't find Pokemon with Pokedex number " + num);
        }
    }

    public String getDetails(Pokemon p) {

        if (Objects.nonNull(p)) {
            System.out.println(p.pokedexEntryDetailed());
        }
        return "";
    }
}