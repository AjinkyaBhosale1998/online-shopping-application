package com.example.demo.global;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Product;

public class GlobalData {
	public static List<Product> cart;
	/* public static List<Product> order; */
	static
	{
		cart=new ArrayList<Product>();
//		order=new ArrayList<Product>();
	}

}
