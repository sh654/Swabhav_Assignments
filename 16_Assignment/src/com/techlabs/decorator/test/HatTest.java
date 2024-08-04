package com.techlabs.decorator.test;

import com.techlabs.decorator.model.GoldenHat;
import com.techlabs.decorator.model.IHat;
import com.techlabs.decorator.model.PremiumHat;
import com.techlabs.decorator.model.RibbonedHat;
import com.techlabs.decorator.model.StandardHat;

public class HatTest {

	public static void main(String args[]) {
		
		IHat premiumHat = new PremiumHat();
		System.out.println("Premium Hat");
		System.out.println("Name: "+premiumHat.getName());
		System.out.println("Price: Rs "+premiumHat.getPrice());
		System.out.println("Description: "+premiumHat.getDescription());
		
		System.out.println();
		
		IHat goldenHat = new GoldenHat(premiumHat);
		System.out.println("Your Premium Hat has "+goldenHat.getDescription());
		
		
		IHat standardHat = new StandardHat();
		System.out.println("Standard Hat");
		System.out.println("Name: "+standardHat.getName());
		System.out.println("Price: Rs "+standardHat.getPrice());
		System.out.println("Description: "+standardHat.getDescription());
		
		System.out.println();
		
		IHat ribbonhat = new RibbonedHat(standardHat);
		System.out.println("Your Standard Hat has "+ribbonhat.getDescription());
	}
}
