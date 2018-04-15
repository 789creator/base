package com.b2cshop.modules.shop.goods.controller;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;
import com.b2cshop.modules.shop.goods.entity.SpecItemEntity;
import com.b2cshop.modules.shop.goods.service.SpecItemService;
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
@RequestMapping("shop/specitem")
public class SpecItemController {
    @Autowired
    private SpecItemService specItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:specitem:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = specItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shop:specitem:info")
    public R info(@PathVariable("id") Integer id) {
        SpecItemEntity specItem = specItemService.selectById(id);

        return R.ok().put("specItem", specItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:specitem:save")
    public R save(@RequestBody SpecItemEntity specItem) {
        specItemService.insert(specItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:specitem:update")
    public R update(@RequestBody SpecItemEntity specItem) {
        specItemService.updateById(specItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:specitem:delete")
    public R delete(@RequestBody Integer[] ids) {
        specItemService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
