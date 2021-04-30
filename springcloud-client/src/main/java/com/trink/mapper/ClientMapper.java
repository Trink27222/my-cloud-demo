package com.trink.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trink.entity.Client;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper 接口
 *
 * @author Trink
 * @since 2021-04-29
 */
@Mapper
public interface ClientMapper extends BaseMapper<Client> {
    /**
     * 自定义分页方法（注：Page参数一定要放在第一位，否则会失效）
     *
     * @param page   分页对象
     * @param client 传入对象参数
     * @return
     */
    IPage<Client> selectClientPage(Page page, @Param("client") Client client);
}
