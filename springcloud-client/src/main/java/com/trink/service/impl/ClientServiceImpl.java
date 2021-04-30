package com.trink.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trink.entity.Client;
import com.trink.mapper.ClientMapper;
import com.trink.service.ClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Trink
 * @since 2021-04-29
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {

    @Override
    public IPage<Client> getClientPage(Page page, Client client) {
        return this.baseMapper.selectClientPage(page,client);
    }
}
