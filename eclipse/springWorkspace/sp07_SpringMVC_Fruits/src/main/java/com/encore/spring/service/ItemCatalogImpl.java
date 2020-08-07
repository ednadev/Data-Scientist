package com.encore.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemDAO;

@Service
public class ItemCatalogImpl implements ItemCatalog{
	@Autowired
	private ItemDAO itemDAO;

	@Override
	public List<Item> getItemList() {
		return itemDAO.getItemList();
	}

	@Override
	public Item getItem(Integer itemid) {
		return itemDAO.getItem(itemid);
	}
}
