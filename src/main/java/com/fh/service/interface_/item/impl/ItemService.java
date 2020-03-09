package com.fh.service.interface_.item.impl;

import com.fh.dao.DaoSupport;
import com.fh.service.interface_.item.ItemManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("itemService")
public class ItemService implements ItemManager {


	@Resource(name = "daoSupport")
	private DaoSupport dao;

}
