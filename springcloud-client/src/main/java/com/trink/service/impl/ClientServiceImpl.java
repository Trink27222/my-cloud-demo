package com.trink.service.impl;

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

}
