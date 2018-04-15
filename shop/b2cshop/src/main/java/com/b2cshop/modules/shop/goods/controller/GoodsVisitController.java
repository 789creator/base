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

import com.b2cshop.modules.shop.goods.entity.GoodsVisitEntity;
import com.b2cshop.modules.shop.goods.service.GoodsVisitService;
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
@RequestMapping("shop/goodsvisit")
public class GoodsVisitController {
    @Autowired
    private GoodsVisitService goodsVisitService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodsvisit:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsVisitService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsId}")
    @RequiresPermissions("shop:goodsvisit:info")
    public R info(@PathVariable("goodsId") Integer goodsId){
			GoodsVisitEntity goodsVisit = goodsVisitService.selectById(goodsId);

        return R.ok().put("goodsVisit", goodsVisit);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodsvisit:save")
    public R save(@RequestBody GoodsVisitEntity goodsVisit){
			goodsVisitService.insert(goodsVisit);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodsvisit:update")
    public R update(@RequestBody GoodsVisitEntity goodsVisit){
			goodsVisitService.updateById(goodsVisit);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodsvisit:delete")
    public R delete(@RequestBody Integer[] goodsIds){
			goodsVisitService.deleteBatchIds(Arrays.asList(goodsIds));

        return R.ok();
    }

}
