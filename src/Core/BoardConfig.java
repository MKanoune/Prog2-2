package Core;

import java.util.ArrayList;
import java.util.List;

import Entities.Wall;
import Entities.XY;
import Entities.Entity;

public class BoardConfig {
	private int sizeX;
	private int sizeY;
	private int entityCount;
	
	public BoardConfig(int sizeX, int sizeY,  int entityCount) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.entityCount = entityCount;
	}
	
	public XY getSize() { return new XY(sizeX, sizeY); }
	
	
	/*
	 * this function() will add all walls to a given List<Entity>
	 * and will return it after the whole board is surrounded with walls.
	 */
	public List<Entity> initWalls(List<Entity> entities) {
		int idCount = 1;
		for (int i=0; i < sizeX; i++) {
			entities.add(new Wall(idCount, i, 0));
			idCount++;
			entities.add(new Wall(idCount, i, sizeY));
			idCount++;
		}
		for (int i=0; i < sizeY; i++) {
			entities.add(new Wall(idCount, 0, i));
			idCount++;
			entities.add(new Wall(idCount, sizeX, i));
			idCount++;
		}
		return entities;
	}

}
