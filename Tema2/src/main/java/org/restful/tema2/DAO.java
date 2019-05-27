package org.restful.tema2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {

	 private static final Map<String, Wine> wineMap = new HashMap<String, Wine>();
	 
	 
	 //get all
	 public static List<Wine> getAllWines(){
		 Collection<Wine> w = wineMap.values();
		 List<Wine> list = new ArrayList<Wine>();
		 list.addAll(w);
		 return list;
	 }
	 
	 //get 
	 public static Wine getWine(String id) {
		 return wineMap.get(id);
	 }
	 
	 //add 
	 public static Wine addWine(Wine wine) {
		 wineMap.put(wine.getId(), wine);
		 return wine;
	 }
	 
	 //update 
	 public static Wine updateWine(Wine wine) {
		 wineMap.put(wine.getId(), wine);
		 return wine;
	 }
	 
	 //delete
	 public static void deleteWine(String id) {
		 wineMap.remove(id);
	 }
	 
	 static {
		 initWines();
	 }
	 
	 public static void initWines() {
		 Wine w1 = new Wine("W1", "Wine 1", 20.0);
		 Wine w2 = new Wine("W2", "Wine 2", 25.0);
		 Wine w3 = new Wine("W3", "Wine 3", 26.0);
		 Wine w4 = new Wine("W4", "Wine 4", 29.0);
		 
		 wineMap.put(w1.getId(), w1);
		 wineMap.put(w2.getId(), w2);
		 wineMap.put(w3.getId(), w3);
		 wineMap.put(w4.getId(), w4);
	 }
}
