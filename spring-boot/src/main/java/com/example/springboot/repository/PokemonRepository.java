package com.example.springboot.repository;

import com.example.springboot.model.Pokemon;
//import com.mongodb.client.FindIterable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PokemonRepository extends MongoRepository<Pokemon, String> {

    @Query("{name:?0}")
    Pokemon findPokemonByName(String name);

    public long count();

    @Query(value="{primaryType:'?0'}", fields="{'name' :  1}")
    List<Pokemon> findPokemonByPrimaryType(String type);

    @Query(value="{secondaryType:'?0'}", fields="{'name' :  1}")
    List<Pokemon> findPokemonBySecondaryType(String type);

    @Query(value="{$or:[{primaryType:'?0'}, {secondaryType: '?0'}]}", fields="{'name': 1}")
    List<Pokemon> findPokemonByPrimaryOrSecondaryType(String type);

    @Query("{pokedexNumber:?0}")
    Pokemon findPokemonByPokedexNumber(Integer num);

}