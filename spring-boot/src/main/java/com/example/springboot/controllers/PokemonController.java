package com.example.springboot.controllers;

import com.example.springboot.model.Pokemon;
import com.example.springboot.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
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
    public void getPokemonByPokedexNumber(Integer num){
        if (num < 1 || num > 1008){
            System.out.println("Invalid Pokedex Number");
        }
        Pokemon p = pokemonRepository.findPokemonByPokedexNumber(num);

        if (Objects.isNull(p)) {
            System.out.println("Couldn't find Pokemon with Pokedex number " + num);
        }
        else {
            System.out.println(p.pokedexEntry());
        }
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
}
