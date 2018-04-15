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

import com.b2cshop.modules.shop.goods.entity.GoodsCouponEntity;
import com.b2cshop.modules.shop.goods.service.GoodsCouponService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;



/**
 * 商品与优惠券关系表
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@RestController
@RequestMapping("shop/goodscoupon")
public class GoodsCouponController {
    @Autowired
    private GoodsCouponService goodsCouponService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodscoupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsCouponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{couponId}")
    @RequiresPermissions("shop:goodscoupon:info")
    public R info(@PathVariable("couponId") Integer couponId){
			GoodsCouponEntity goodsCoupon = goodsCouponService.selectById(couponId);

        return R.ok().put("goodsCoupon", goodsCoupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodscoupon:save")
    public R save(@RequestBody GoodsCouponEntity goodsCoupon){
			goodsCouponService.insert(goodsCoupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodscoupon:update")
    public R update(@RequestBody GoodsCouponEntity goodsCoupon){
			goodsCouponService.updateById(goodsCoupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodscoupon:delete")
    public R delete(@RequestBody Integer[] couponIds){
			goodsCouponService.deleteBatchIds(Arrays.asList(couponIds));

        return R.ok();
    }

}
