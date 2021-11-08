package AidanAzkafaroDesonJmartFH;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

import com.google.gson.*;
import java.io.File;
import java.util.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author (Aidan Azkafaro Deson)
 * 
 */
public class Jmart {

	
	public static List<Product> filterByAccountId (List<Product> list, int accountId, int page, int pageSize){
		Predicate<Product> pred = temp -> (temp.accountId == accountId);
        return paginate(list, page, pageSize, pred);
	}
	
	public static List<Product> filterByName (List<Product> list, String search, int page, int pageSize){
		
		 List<Product> filteredList = new ArrayList<>();
		 
	        // iterate through the list
	        for (Product entry: list)
	        {
	            // filter values
	            if (entry.name.toLowerCase().contains(search.toLowerCase())) {
	                filteredList.add(entry);
	            }
	        }
		return paginate(filteredList, page, pageSize, (e) -> e.name == search);
		
	}
	
	// method read terhadap resources
	public static List<Product> read(String filepath) throws FileNotFoundException {
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<Product>>() {
		}.getType();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		List<Product> returnList = gson.fromJson(br, userListType);
		return returnList;

	}

	public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
		List<Product> result = new ArrayList<Product>();

		for (Product product : list) {
			if (minPrice != 0.0 && product.price < minPrice) {
				continue;
			}
			if (maxPrice != 0.0 && product.price > maxPrice) {
				continue;
			}

			result.add(product);
		}

		return result;
	}

	public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {

		List<Product> returnList = new ArrayList<Product>();
		for (Product product : list) {
			if (product.category.equals(category)) {
				returnList.add(product);
			}
		}
		return returnList;

	}
	
	private static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred){
		
		List<Product> resultList = new ArrayList<>();
		
		//loop through list
		for(Product product : list) {
			//filtering the element in list if pred == true
			if (pred.predicate(product) == true) {
				//add the element to resultList
				resultList.add(product);
			}
		}
		
		int index = (page-1) * pageSize;
		
		int floorPage = Math.min(index + pageSize, resultList.size());
		return resultList.subList(index,  floorPage);

	}

	public static void main(String[] args) {

		System.out.println("account id: " + new Account(null, null, null, -1).id);
		System.out.println("account id: " + new Account(null, null, null, -1).id);
		System.out.println("account id: " + new Account(null, null, null, -1).id);

		System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
		System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
		System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
		
		try
		{
			List<Product> list = read("C:\\Users\\aidan\\Programming\\OOP Tekkom\\Praktikum OOP\\jmart\\randomProductList.json");
			List<Product> filtered = filterByPrice(list, 98000.0, 0.0);
			filtered.forEach(product -> System.out.println(product.price));
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}

}
