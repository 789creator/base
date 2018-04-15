package com.b2cshop.modules.shop.goods.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2cshop.modules.shop.goods.entity.GoodsCategoryEntity;
import com.b2cshop.modules.shop.goods.service.GoodsCategoryService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;


/**
 * 商品分类
 *
 * @author zhj
 * @email
 * @date 2018-03-28 20:00:19
 */
@RestController
@RequestMapping("shop/goodscategory")
public class GoodsCategoryController {
    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodscategory:list")
    public R list() {
        List<GoodsCategoryEntity> goodsCategoryList = goodsCategoryService.selectAllList();
        return R.ok().put("list", goodsCategoryList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shop:goodscategory:info")
    public R info(@PathVariable("id") Integer id) {
        GoodsCategoryEntity goodsCategory = goodsCategoryService.selectById(id);

        return R.ok().put("goodsCategory", goodsCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodscategory:save")
    public R save(@RequestBody GoodsCategoryEntity goodsCategory) {
        goodsCategoryService.insert(goodsCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodscategory:update")
    public R update(@RequestBody GoodsCategoryEntity goodsCategory) {
        goodsCategoryService.updateById(goodsCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodscategory:delete")
    public R delete(@RequestBody Integer[] ids) {
        goodsCategoryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
