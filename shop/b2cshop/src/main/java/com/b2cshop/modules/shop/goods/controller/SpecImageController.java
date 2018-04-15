package com.b2cshop.modules.shop.goods.controller;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;
import com.b2cshop.modules.shop.goods.entity.SpecImageEntity;
import com.b2cshop.modules.shop.goods.service.SpecImageService;
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
@RequestMapping("shop/specimage")
public class SpecImageController {
    @Autowired
    private SpecImageService specImageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:specimage:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = specImageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsId}")
    @RequiresPermissions("shop:specimage:info")
    public R info(@PathVariable("goodsId") Integer goodsId) {
        SpecImageEntity specImage = specImageService.selectById(goodsId);

        return R.ok().put("specImage", specImage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:specimage:save")
    public R save(@RequestBody SpecImageEntity specImage) {
        specImageService.insert(specImage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:specimage:update")
    public R update(@RequestBody SpecImageEntity specImage) {
        specImageService.updateById(specImage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:specimage:delete")
    public R delete(@RequestBody Integer[] goodsIds) {
        specImageService.deleteBatchIds(Arrays.asList(goodsIds));

        return R.ok();
    }

}
