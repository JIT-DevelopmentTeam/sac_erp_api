package com.fh.service.interface_.item.impl;

import com.fh.dao.DaoSupport;
import com.fh.service.interface_.item.ItemManager;
import com.fh.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("itemService")
public class ItemService implements ItemManager {


	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**
	 * 查询客户列表
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PageData> clientList(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Interface_erp.clientList", pd);
	}

	/**
	 * 查询合同列表
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PageData> contractList(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Interface_erp.contractList", pd);
	}

	/**
	 * 查询物料列表
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PageData> itemList(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Interface_erp.itemList", pd);
	}

	/**
	 * 查询库存列表
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PageData> stockList(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Interface_erp.stockList", pd);
	}

	/**
	 * 查询物料分类列表
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PageData> itemClassList(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Interface_erp.itemClassList", pd);
	}
}
