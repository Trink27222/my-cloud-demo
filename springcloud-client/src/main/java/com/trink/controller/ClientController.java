package com.trink.controller;

import com.trink.entity.Client;
import com.trink.service.ClientService;
import com.trink.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * <p>
 *  client的前端控制器
 * </p>
 * @since 2019-05-24
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    /**
     * 新增client
     * @param client client对象
     * @return
     */
    @PostMapping
    public R addClient(@RequestBody Client client){
        return R.success(this.clientService.save(client));
    }
    /**
     * 根据id获取client
     * @param id client的id
     * @return
     */
    @GetMapping("/{id}")
    public R getClientById(@PathVariable Integer id){
        return R.success(this.clientService.getById(id));
    }
    /**
     * 根据id删除client
     * @param id client的id
     * @return
     */
    @DeleteMapping("/{id}")
    public R removeClient(@PathVariable Integer id){
        return R.success(this.clientService.removeById(id));
    }
}