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

import com.b2cshop.modules.shop.goods.entity.GoodsBrowseEntity;
import com.b2cshop.modules.shop.goods.service.GoodsBrowseService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;



/**
 * 商品浏览历史表
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@RestController
@RequestMapping("shop/goodsbrowse")
public class GoodsBrowseController {
    @Autowired
    private GoodsBrowseService goodsBrowseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodsbrowse:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsBrowseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsId}")
    @RequiresPermissions("shop:goodsbrowse:info")
    public R info(@PathVariable("goodsId") Integer goodsId){
			GoodsBrowseEntity goodsBrowse = goodsBrowseService.selectById(goodsId);

        return R.ok().put("goodsBrowse", goodsBrowse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodsbrowse:save")
    public R save(@RequestBody GoodsBrowseEntity goodsBrowse){
			goodsBrowseService.insert(goodsBrowse);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodsbrowse:update")
    public R update(@RequestBody GoodsBrowseEntity goodsBrowse){
			goodsBrowseService.updateById(goodsBrowse);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodsbrowse:delete")
    public R delete(@RequestBody Integer[] goodsIds){
			goodsBrowseService.deleteBatchIds(Arrays.asList(goodsIds));

        return R.ok();
    }

}
