package com.techlabs.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.techlabs.model.Americas;
import com.techlabs.model.Asia;
import com.techlabs.model.Country;
import com.techlabs.model.Europe;
import com.techlabs.model.MiddleEastAndAfrica;
import com.techlabs.model.Region;

public class CountryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		 Region europe = new Europe();
		
		List<Country> countries = Arrays.asList(
				new Country("IT", "Italy", europe),
				new Country("JP", "Japan", new Asia()),
				new Country("US", "United States of America", new Americas()),
				new Country("CA", "Canada", new Americas()),
				new Country("CN", "China", new Asia()),
				new Country("IN", "India", new Asia()),
	            new Country("AU", "Australia", new Asia()),
	            new Country("ZW", "Zimbabwe", new MiddleEastAndAfrica()),
	            new Country("SG", "Singapore", new Asia()),
	            new Country("UK", "United Kingdom", new Europe()),
	            new Country("FR", "France", new Europe()),
	            new Country("DE", "Germany", new Europe()),
	            new Country("ZM", "Zambia", new MiddleEastAndAfrica()),
	            new Country("EG", "Egypt", new MiddleEastAndAfrica()),
	            new Country("BR", "Brazil", new Americas()),
	            new Country("CH", "Switzerland", new Europe()),
	            new Country("NL", "Netherlands", new Europe()),
	            new Country("MX", "Mexico", new Americas()),
	            new Country("KW", "Kuwait", new MiddleEastAndAfrica()),
	            new Country("IL", "Israel", new MiddleEastAndAfrica()),
	            new Country("DK", "Denmark", new Europe()),
	            new Country("HK", "Hong Kong", new Asia()),
	            new Country("NG", "Nigeria", new MiddleEastAndAfrica()),
	            new Country("AR", "Argentina", new Americas()),
	            new Country("BE", "Belgium", new Europe())
				);
		
		display(countries);
		System.out.println("==================================================================");
//		1. get name of country from country code
		
		System.out.println("Enter Country Code : ");
		String countryCode = scanner.next();
		
		countries.stream()
		.filter(country -> country.getCountryCode().equals(countryCode))
		.map(Country :: getCountryName).findFirst().ifPresent(name ->System.out.println("Country Code: "+ countryCode +" : "+ name));
		
		
		// 2 .get name as per id 
		
		System.out.println("Enter Region Id: ");
		int region = scanner.nextInt();
		List<Country> Countries = countries.stream().filter( country -> country.getRegion().getRegionId() == region).collect(Collectors.toList());
		System.out.println("Countries in region : "+region+ " : "+Countries +"\n");
		
		//3 . Find count of countries in each region
		Map<Integer, Long> CountriesCount = countries.stream().collect(Collectors.groupingBy(country -> country.getRegion().getRegionId(), Collectors.counting()));
		CountriesCount.forEach((region_id, count) -> System.out.println("Region "+region_id+" has Count: "+count));
	}	
	
	public static void display(List<Country> countries) {
		for(Country country : countries) {
			System.out.println(country);
		}
	}

}
