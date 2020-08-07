package com.encore.spring.service;

import java.util.List;

import com.encore.spring.domain.Item;

public interface ItemCatalog {//Shop
	List<Item> getItemList();
	Item getItem(Integer itemid);
}
