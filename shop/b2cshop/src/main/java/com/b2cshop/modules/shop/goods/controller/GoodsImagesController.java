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

import com.b2cshop.modules.shop.goods.entity.GoodsImagesEntity;
import com.b2cshop.modules.shop.goods.service.GoodsImagesService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;



/**
 * 商品图片
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@RestController
@RequestMapping("shop/goodsimages")
public class GoodsImagesController {
    @Autowired
    private GoodsImagesService goodsImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodsimages:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsImagesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{imgId}")
    @RequiresPermissions("shop:goodsimages:info")
    public R info(@PathVariable("imgId") Integer imgId){
			GoodsImagesEntity goodsImages = goodsImagesService.selectById(imgId);

        return R.ok().put("goodsImages", goodsImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodsimages:save")
    public R save(@RequestBody GoodsImagesEntity goodsImages){
			goodsImagesService.insert(goodsImages);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodsimages:update")
    public R update(@RequestBody GoodsImagesEntity goodsImages){
			goodsImagesService.updateById(goodsImages);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodsimages:delete")
    public R delete(@RequestBody Integer[] imgIds){
			goodsImagesService.deleteBatchIds(Arrays.asList(imgIds));

        return R.ok();
    }

}
