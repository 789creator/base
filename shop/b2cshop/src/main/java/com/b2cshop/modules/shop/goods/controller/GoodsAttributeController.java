package com.b2cshop.modules.shop.goods.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2cshop.modules.shop.goods.entity.GoodsAttributeEntity;
import com.b2cshop.modules.shop.goods.service.GoodsAttributeService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;



/**
 * 商品属性
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@RestController
@RequestMapping("shop/goodsattribute")
public class GoodsAttributeController {
    @Autowired
    private GoodsAttributeService goodsAttributeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodsattribute:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsAttributeService.list(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    @RequiresPermissions("shop:goodsattribute:info")
    public R info(@PathVariable("attrId") Integer attrId){
			GoodsAttributeEntity goodsAttribute = goodsAttributeService.selectById(attrId);

        return R.ok().put("goodsAttribute", goodsAttribute);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodsattribute:save")
    public R save(@RequestBody GoodsAttributeEntity goodsAttribute){
			goodsAttributeService.insert(goodsAttribute);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodsattribute:update")
    public R update(@RequestBody GoodsAttributeEntity goodsAttribute){
			goodsAttributeService.updateById(goodsAttribute);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodsattribute:delete")
    public R delete(@RequestBody Integer[] attrIds){
			goodsAttributeService.deleteBatchIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
