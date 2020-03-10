package com.fh.controller;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.interface_.item.ItemManager;
import com.fh.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value="/api/erp_get")
public class ErpGetController extends BaseController{

	@Resource(name="itemService")
	private ItemManager itemService;


	/**
	 * 获取客户列表API（传递参数：userid，token，max）
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getClient")
	public Map<String, Object> getClient(Page page) throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		PageData pd = this.getPageData();
		List<PageData> varList = itemService.clientList(pd);
		json.put("size", varList.size());
		json.put("data", varList);
		return json;
	}

	/**
	 * 获取合同列表API（传递参数：userid，token，max）
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getContract")
	public Map<String, Object> getContract(Page page) throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		PageData pd = this.getPageData();
		List<PageData> varList = itemService.contractList(pd);
		json.put("size", varList.size());
		json.put("data", varList);
		return json;
	}

	/**
	 * 获取物料列表API（传递参数：userid，token，max）
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getItem")
	public Map<String, Object> getItem(Page page) throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		PageData pd = this.getPageData();
		List<PageData> varList = itemService.itemList(pd);
		json.put("size", varList.size());
		json.put("data", varList);
		return json;
	}

	/**
	 * 获取库存列表API（传递参数：userid，token，num）
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getStock")
	public Map<String, Object> getStock(Page page) throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		PageData pd = this.getPageData();
		List<PageData> varList = itemService.stockList(pd);
		json.put("size", varList.size());
		json.put("data", varList);
		return json;
	}

}
