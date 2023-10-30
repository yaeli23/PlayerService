package org.example.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The Player class represents a player.
 *
 * @implNote all members start with the "_" prefix to avoid collision with saved keywords (e.g. "throws")
 */
@JsonSerialize(using = CustomPlayerSerializer.class)
public class Player {

    private String _playerID;
    private String _birthYear;
    private String _birthMonth;
    private String _birthDay;
    private String _birthCountry;
    private String _birthState;
    private String _birthCity;
    private String _deathYear;
    private String _deathMonth;
    private String _deathDay;
    private String _deathCountry;
    private String _deathState;
    private String _deathCity;
    private String _nameFirst;
    private String _nameLast;
    private String _nameGiven;
    private String _weight;
    private String _height;
    private String _bats;
    private String _throws;
    private String _debut;
    private String _finalGame;
    private String _retroID;
    private String _bbrefID;

    public Player() {
    }

    public String get_playerID() {
        return _playerID;
    }

    public void set_playerID(String _playerID) {
        this._playerID = _playerID;
    }

    public String get_birthYear() {
        return _birthYear;
    }

    public void set_birthYear(String _birthYear) {
        this._birthYear = _birthYear;
    }

    public String get_birthMonth() {
        return _birthMonth;
    }

    public void set_birthMonth(String _birthMonth) {
        this._birthMonth = _birthMonth;
    }

    public String get_birthDay() {
        return _birthDay;
    }

    public void set_birthDay(String _birthDay) {
        this._birthDay = _birthDay;
    }

    public String get_birthCountry() {
        return _birthCountry;
    }

    public void set_birthCountry(String _birthCountry) {
        this._birthCountry = _birthCountry;
    }

    public String get_birthState() {
        return _birthState;
    }

    public void set_birthState(String _birthState) {
        this._birthState = _birthState;
    }

    public String get_birthCity() {
        return _birthCity;
    }

    public void set_birthCity(String _birthCity) {
        this._birthCity = _birthCity;
    }

    public String get_deathYear() {
        return _deathYear;
    }

    public void set_deathYear(String _deathYear) {
        this._deathYear = _deathYear;
    }

    public String get_deathMonth() {
        return _deathMonth;
    }

    public void set_deathMonth(String _deathMonth) {
        this._deathMonth = _deathMonth;
    }

    public String get_deathDay() {
        return _deathDay;
    }

    public void set_deathDay(String _deathDay) {
        this._deathDay = _deathDay;
    }

    public String get_deathCountry() {
        return _deathCountry;
    }

    public void set_deathCountry(String _deathCountry) {
        this._deathCountry = _deathCountry;
    }

    public String get_deathState() {
        return _deathState;
    }

    public void set_deathState(String _deathState) {
        this._deathState = _deathState;
    }

    public String get_deathCity() {
        return _deathCity;
    }

    public void set_deathCity(String _deathCity) {
        this._deathCity = _deathCity;
    }

    public String get_nameFirst() {
        return _nameFirst;
    }

    public void set_nameFirst(String _nameFirst) {
        this._nameFirst = _nameFirst;
    }

    public String get_nameLast() {
        return _nameLast;
    }

    public void set_nameLast(String _nameLast) {
        this._nameLast = _nameLast;
    }

    public String get_nameGiven() {
        return _nameGiven;
    }

    public void set_nameGiven(String _nameGiven) {
        this._nameGiven = _nameGiven;
    }

    public String get_weight() {
        return _weight;
    }

    public void set_weight(String _weight) {
        this._weight = _weight;
    }

    public String get_height() {
        return _height;
    }

    public void set_height(String _height) {
        this._height = _height;
    }

    public String get_bats() {
        return _bats;
    }

    public void set_bats(String _bats) {
        this._bats = _bats;
    }

    public String get_throws() {
        return _throws;
    }

    public void set_throws(String _throws) {
        this._throws = _throws;
    }

    public String get_debut() {
        return _debut;
    }

    public void set_debut(String _debut) {
        this._debut = _debut;
    }

    public String get_finalGame() {
        return _finalGame;
    }

    public void set_finalGame(String _finalGame) {
        this._finalGame = _finalGame;
    }

    public String get_retroID() {
        return _retroID;
    }

    public void set_retroID(String _retroID) {
        this._retroID = _retroID;
    }

    public String get_bbrefID() {
        return _bbrefID;
    }

    public void set_bbrefID(String _bbrefID) {
        this._bbrefID = _bbrefID;
    }

    /**
     * Returns the string representation of the object in JSON format using the Jackson ObjectMapper.
     * If an error occurs during the serialization process, a RuntimeException is thrown.
     *
     * @return the JSON representation of the object
     * @throws RuntimeException if an error occurs during the serialization process
     */
    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
