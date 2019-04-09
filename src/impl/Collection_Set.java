package impl;

import java.util.ArrayList;

import services.CharacterService;

public class Collection_Set {
	private ArrayList<CharacterService> characters;
	private ArrayList<Item> items;
	
	public Collection_Set() {
		characters = new ArrayList<>();
		items = new ArrayList<>();
	}
	
	public ArrayList<CharacterService> getCharacters() {
		return characters;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	
	
}
