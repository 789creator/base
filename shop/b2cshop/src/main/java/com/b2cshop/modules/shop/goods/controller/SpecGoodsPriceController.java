package com.b2cshop.modules.shop.goods.controller;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;
import com.b2cshop.modules.shop.goods.entity.SpecGoodsPriceEntity;
import com.b2cshop.modules.shop.goods.service.SpecGoodsPriceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * @author zhj
 * @email
 * @date 2018-04-01 16:17:09
 */
@RestController
@RequestMapping("shop/specgoodsprice")
public class SpecGoodsPriceController {
    @Autowired
    private SpecGoodsPriceService specGoodsPriceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:specgoodsprice:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = specGoodsPriceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{itemId}")
    @RequiresPermissions("shop:specgoodsprice:info")
    public R info(@PathVariable("itemId") Long itemId) {
        SpecGoodsPriceEntity specGoodsPrice = specGoodsPriceService.selectById(itemId);

        return R.ok().put("specGoodsPrice", specGoodsPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:specgoodsprice:save")
    public R save(@RequestBody SpecGoodsPriceEntity specGoodsPrice) {
        specGoodsPriceService.insert(specGoodsPrice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:specgoodsprice:update")
    public R update(@RequestBody SpecGoodsPriceEntity specGoodsPrice) {
        specGoodsPriceService.updateById(specGoodsPrice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:specgoodsprice:delete")
    public R delete(@RequestBody Long[] itemIds) {
        specGoodsPriceService.deleteBatchIds(Arrays.asList(itemIds));

        return R.ok();
    }

}
