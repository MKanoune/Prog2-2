package Core;

import java.util.ArrayList;
import java.util.List;

import Entities.Entity;

public class Board {
	BoardConfig config;
	List<Entity> entities;
	
	public Board(BoardConfig config) {
		this.config = config;
		this.entities = new ArrayList<Entity>();
		initWorld();
	}
	
	public void initWorld() {
		
	}
	
	

}
