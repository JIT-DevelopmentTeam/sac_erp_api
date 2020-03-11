package com.fh.service.interface_.item;

import com.fh.util.PageData;

import java.util.List;

public interface ItemManager {

    /**
     * 查询客户列表
     * @param pd
     * @return
     * @throws Exception
     */
    List<PageData> clientList(PageData pd) throws Exception;

    /**
     * 查询合同列表
     * @param pd
     * @return
     * @throws Exception
     */
    List<PageData> contractList(PageData pd) throws Exception;

    /**
     * 查询物料列表
     * @return
     * @throws Exception
     */
    List<PageData> itemList(PageData pd) throws Exception;

    /**
     * 查询库存列表
     * @return
     * @throws Exception
     */
    List<PageData> stockList(PageData pd) throws Exception;

    /**
     * 查询物料分类列表
     * @param pd
     * @return
     * @throws Exception
     */
    List<PageData> itemClassList(PageData pd) throws Exception;

}
