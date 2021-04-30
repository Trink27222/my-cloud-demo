package com.trink.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trink.entity.Client;
import com.trink.redisconfig.RedisHelper;
import com.trink.service.ClientService;
import com.trink.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * client的前端控制器
 * </p>
 *
 * @author Trink丶
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    //引入redis操作工具
    @Autowired
    private RedisHelper redisHelper;

    /**
     * 新增client
     *
     * @param client client对象
     * @return
     */
    @PostMapping
    public R addClient(@RequestBody Client client) {
        this.clientService.save(client);
        //填充缓存，key为client_${id}
        this.redisHelper.set("client_" + client.getId(), JSON.toJSONString(client));
        return R.success(Boolean.TRUE);
    }

    /**
     * 根据id获取client
     *
     * @param id client的id
     * @return
     */
    @GetMapping("/{id}")
    public R getClientById(@PathVariable Integer id) {
        //首先从缓存获取
        Client client = JSON.parseObject(this.redisHelper.get("client_" + id), Client.class);
        if (null != client) {
            return R.success(client);
        } else {
            client = this.clientService.getById(id);
            if (null != client) {
                this.redisHelper.set("client_" + client.getId(), JSON.toJSONString(client));
            } else {
                return R.failed("不存在该用户");
            }
        }
        return R.success(client);
    }

    /**
     * 根据id删除client
     *
     * @param id client的id
     * @return
     */
    @DeleteMapping("/{id}")
    public R removeClient(@PathVariable Integer id) {
        this.clientService.removeById(id);
        //从缓存移除
        this.redisHelper.del("client_" + id);
        return R.success(Boolean.TRUE);
    }

    @GetMapping("/page")
    public R getClientPage(Page page, Client client) {
        return R.success(this.clientService.getClientPage(page, client));
    }
}