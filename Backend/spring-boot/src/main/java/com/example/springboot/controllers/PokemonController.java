package com.example.springboot.controllers;

import com.example.springboot.model.AbilityResponse;
import com.example.springboot.model.GuessResponse;
import com.example.springboot.model.Pokemon;
import com.example.springboot.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
//import java.lang.Math;
import java.util.Random;

@RestController
//TODO change this for deployment
@CrossOrigin(origins = {"*"})

@RequestMapping("api/pokemon")
public class PokemonController {

    Random random = new Random();
    final int FIRST_POKEDEX_NUMBER = 1;
    final int END_POKEDEX_NUMBER = 1008;

    String correctAbility = null;

    @Autowired
    PokemonRepository pokemonRepository;
    @PostMapping("findbyname")
    public void getPokemonByName(String name){
        List<Pokemon> allForms = pokemonRepository.findPokemonByName(name);

        if (Objects.isNull(allForms)){
            System.out.println("Query returned null for name: " + name);
            return;
        }

        if (allForms.isEmpty()){
            System.out.println("No Pokemon of with name: " + name);
            return;
        }

        if (allForms.size() != 1){
            System.out.println("There are multiple forms of this pokemon.");
        }

        allForms.forEach((form) -> System.out.println(form.pokedexEntry()));
    }

    @PostMapping("getcount")
    public void findCountOfPokemon() {
        long count = pokemonRepository.count();
        System.out.println("Number of documents in the collection = " + count);
    }

    @PostMapping("findbypokedexnumber")
    public List<Pokemon> getPokemonByPokedexNumber(Integer num){
        if (num < 1 || num > 1008){
            System.out.println("Invalid Pokedex Number");
        }
        List<Pokemon> allForms = pokemonRepository.findPokemonByPokedexNumber(num);

        if (Objects.isNull(allForms)){
            System.out.println("Query returned null for Pokedex #: " + num);
            return null;
        }

        if (allForms.isEmpty()){
            System.out.println("No Pokemon of with Pokedex #: " + num);
            return null;
        }

        if (allForms.size() != 1){
            System.out.println("There are multiple forms of this pokemon.");
        }

//        allForms.forEach((form) -> System.out.println(form.pokedexEntry()));
        return allForms;
    }

    @PostMapping("getalloftype")
    public void getPokemonByType(String type){
        List<Pokemon> allOfType = pokemonRepository.findPokemonByPrimaryOrSecondaryType(type);

        if (allOfType.isEmpty()){
            System.out.println("No Pokemon of type: " + type);
            return;
        }

        allOfType.forEach((p) -> System.out.println(p.getName()));
    }

    @PostMapping("getallofprimarytype")
    public void getPokemonByPrimaryType(String type){
        List<Pokemon> allOfType = pokemonRepository.findPokemonByPrimaryType(type);

        if (allOfType.isEmpty()){
            System.out.println("No Pokemon of type: " + type);
            return;
        }

        allOfType.forEach((p) -> System.out.println(p.getName()));
    }

    @PostMapping("getallwithability")
    public void getPokemonWithAbility(String ability){
        List<Pokemon> allOfType = pokemonRepository.findPokemonWithAbility(ability);

        if (allOfType.isEmpty()){
            System.out.println("No Pokemon with ability: " + ability + ". Is it spelled correctly?");
            return;
        }

        allOfType.forEach((p) -> System.out.println(p.getName()));
    }

    @PostMapping("getrandomability")
    public AbilityResponse getRandomAbility(){

        //generates a random value 1-numEntries for the number of pokemon in the DB
        Integer randomPokedexNumber = this.random.nextInt(FIRST_POKEDEX_NUMBER, END_POKEDEX_NUMBER);

        List<Pokemon> listOfRandomDexNum = getPokemonByPokedexNumber(randomPokedexNumber);

        if (Objects.isNull(listOfRandomDexNum)) return null;

        if (listOfRandomDexNum.isEmpty()) return null;

        Pokemon first = listOfRandomDexNum.get(0);

        this.correctAbility = first.getPrimaryAbilityName();

        System.out.println("Set ability to: " + this.correctAbility);

        return new AbilityResponse(first.getPrimaryAbilityName(), first.getPrimaryAbilityDescription());
    }
    @PostMapping("checkguessedability")
    public GuessResponse checkCorrectAbility(@RequestBody String guess){


        if (Objects.isNull(guess)){
            return new GuessResponse(false);
        }

        String cleanedGuess = guess.replace("\"", "");

        System.out.println("expected: " + correctAbility);
        System.out.println("guess: " + cleanedGuess);
        System.out.println("output: " + Objects.equals(cleanedGuess.toLowerCase(), correctAbility.toLowerCase()));
        //check for equality regardless of capitalization
        return new GuessResponse(Objects.equals(cleanedGuess.toLowerCase(), correctAbility.toLowerCase()));
    }

}
