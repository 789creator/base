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

import com.b2cshop.modules.shop.goods.entity.GoodsAttrEntity;
import com.b2cshop.modules.shop.goods.service.GoodsAttrService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;



/**
 * 商品与商品属性关系表
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@RestController
@RequestMapping("shop/goodsattr")
public class GoodsAttrController {
    @Autowired
    private GoodsAttrService goodsAttrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodsattr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsAttrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsAttrId}")
    @RequiresPermissions("shop:goodsattr:info")
    public R info(@PathVariable("goodsAttrId") Integer goodsAttrId){
			GoodsAttrEntity goodsAttr = goodsAttrService.selectById(goodsAttrId);

        return R.ok().put("goodsAttr", goodsAttr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodsattr:save")
    public R save(@RequestBody GoodsAttrEntity goodsAttr){
			goodsAttrService.insert(goodsAttr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodsattr:update")
    public R update(@RequestBody GoodsAttrEntity goodsAttr){
			goodsAttrService.updateById(goodsAttr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodsattr:delete")
    public R delete(@RequestBody Integer[] goodsAttrIds){
			goodsAttrService.deleteBatchIds(Arrays.asList(goodsAttrIds));

        return R.ok();
    }

}
