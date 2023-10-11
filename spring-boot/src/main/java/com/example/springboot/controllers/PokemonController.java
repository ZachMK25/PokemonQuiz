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
        Pokemon p = pokemonRepository.findPokemonByName(name);

        if (Objects.isNull(p)){
            System.out.println("Could not find pokemon with name: " + name);
            return;
        }

        System.out.println(p.pokedexEntry());
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

        if (Objects.nonNull(p)) {
            System.out.println(p.pokedexEntry());
        }
        else {
            System.out.println("Couldn't find Pokemon with Pokedex number " + num);
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
}
