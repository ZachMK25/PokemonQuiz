package com.example.springboot.controllers;

import com.example.springboot.model.AbilityResponse;
import com.example.springboot.model.Pokemon;
import com.example.springboot.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.lang.Math;

@RestController
//TODO change this for deployment
@CrossOrigin(origins = {"*"})

@RequestMapping("api/pokemon")
public class PokemonController {

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
        Integer randomPokedexNumber = (int) (Math.random() * (pokemonRepository.count())) + 1;

        List<Pokemon> listOfRandomDexNum = getPokemonByPokedexNumber(randomPokedexNumber);

        if (Objects.isNull(listOfRandomDexNum)) return null;

        if (listOfRandomDexNum.isEmpty()) return null;

        Pokemon first = listOfRandomDexNum.get(0);

        return new AbilityResponse(first.getPrimaryAbilityName(), first.getPrimaryAbilityDescription());
    }

}
