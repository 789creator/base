package com.b2cshop.modules.shop.goods.controller;

import java.util.Arrays;
import java.util.Map;

import com.b2cshop.modules.shop.goods.entity.GoodsEntity;
import com.b2cshop.modules.shop.goods.service.GoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;



/**
 * 商品
 *
 * @author zhj
 * @email 
 * @date 2018-03-29 09:48:51
 */
@RestController
@RequestMapping("shop/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsId}")
    @RequiresPermissions("shop:goods:info")
    public R info(@PathVariable("goodsId") Integer goodsId){
			GoodsEntity goods = goodsService.selectById(goodsId);

        return R.ok().put("goods", goods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goods:save")
    public R save(@RequestBody GoodsEntity goods){
			goodsService.insert(goods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goods:update")
    public R update(@RequestBody GoodsEntity goods){
			goodsService.updateById(goods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goods:delete")
    public R delete(@RequestBody Integer[] goodsIds){
			goodsService.deleteBatchIds(Arrays.asList(goodsIds));

        return R.ok();
    }

}
