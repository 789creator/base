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

import com.b2cshop.modules.shop.goods.entity.GoodsTypeEntity;
import com.b2cshop.modules.shop.goods.service.GoodsTypeService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;



/**
 * 商品模型、类型
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:18
 */
@RestController
@RequestMapping("shop/goodstype")
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodstype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsTypeService.list(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shop:goodstype:info")
    public R info(@PathVariable("id") Integer id){
			GoodsTypeEntity goodsType = goodsTypeService.selectById(id);

        return R.ok().put("goodsType", goodsType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodstype:save")
    public R save(@RequestBody GoodsTypeEntity goodsType){
			goodsTypeService.insert(goodsType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodstype:update")
    public R update(@RequestBody GoodsTypeEntity goodsType){
			goodsTypeService.updateById(goodsType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodstype:delete")
    public R delete(@RequestBody Integer[] ids){
			goodsTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
