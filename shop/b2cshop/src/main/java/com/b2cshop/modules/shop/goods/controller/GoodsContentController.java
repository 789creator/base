package com.b2cshop.modules.shop.goods.controller;

import java.util.Arrays;
import java.util.Map;

import com.b2cshop.modules.shop.goods.entity.GoodsContentEntity;
import com.b2cshop.modules.shop.goods.service.GoodsContentService;
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
@RequestMapping("shop/goodscontent")
public class GoodsContentController {
    @Autowired
    private GoodsContentService goodsContentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodscontent:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsContentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsContentId}")
    @RequiresPermissions("shop:goodscontent:info")
    public R info(@PathVariable("goodsContentId") Integer goodsContentId){
			GoodsContentEntity goodsContent = goodsContentService.selectById(goodsContentId);

        return R.ok().put("goodsContent", goodsContent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodscontent:save")
    public R save(@RequestBody GoodsContentEntity goodsContent){
			goodsContentService.insert(goodsContent);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodscontent:update")
    public R update(@RequestBody GoodsContentEntity goodsContent){
			goodsContentService.updateById(goodsContent);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodscontent:delete")
    public R delete(@RequestBody Integer[] goodsContentIds){
			goodsContentService.deleteBatchIds(Arrays.asList(goodsContentIds));

        return R.ok();
    }

}
