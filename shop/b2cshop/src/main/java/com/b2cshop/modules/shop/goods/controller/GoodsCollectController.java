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

import com.b2cshop.modules.shop.goods.entity.GoodsCollectEntity;
import com.b2cshop.modules.shop.goods.service.GoodsCollectService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;



/**
 * 商品收藏
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@RestController
@RequestMapping("shop/goodscollect")
public class GoodsCollectController {
    @Autowired
    private GoodsCollectService goodsCollectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodscollect:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsCollectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{collectId}")
    @RequiresPermissions("shop:goodscollect:info")
    public R info(@PathVariable("collectId") Integer collectId){
			GoodsCollectEntity goodsCollect = goodsCollectService.selectById(collectId);

        return R.ok().put("goodsCollect", goodsCollect);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodscollect:save")
    public R save(@RequestBody GoodsCollectEntity goodsCollect){
			goodsCollectService.insert(goodsCollect);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodscollect:update")
    public R update(@RequestBody GoodsCollectEntity goodsCollect){
			goodsCollectService.updateById(goodsCollect);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodscollect:delete")
    public R delete(@RequestBody Integer[] collectIds){
			goodsCollectService.deleteBatchIds(Arrays.asList(collectIds));

        return R.ok();
    }

}
