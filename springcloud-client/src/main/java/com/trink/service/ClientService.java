package com.trink.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trink.entity.Client;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Trink
 * @since 2021-04-29
 */
public interface ClientService extends IService<Client> {
    /**
     * 自定义分页查询
     * @param page 分页对象
     * @param client 传入对象参数
     * @return
     */
    IPage<Client> getClientPage(Page page, Client client);
}
