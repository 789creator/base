package com.b2cshop.modules.shop.goods.controller;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;
import com.b2cshop.modules.shop.goods.entity.SpecTypeEntity;
import com.b2cshop.modules.shop.goods.service.SpecTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品类型与规格对应表
 *
 * @author zhj
 * @email
 * @date 2018-04-01 16:17:09
 */
@RestController
@RequestMapping("shop/spectype")
public class SpecTypeController {
    @Autowired
    private SpecTypeService specTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:spectype:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = specTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{typeId}")
    @RequiresPermissions("shop:spectype:info")
    public R info(@PathVariable("typeId") Integer typeId) {
        SpecTypeEntity specType = specTypeService.selectById(typeId);

        return R.ok().put("specType", specType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:spectype:save")
    public R save(@RequestBody SpecTypeEntity specType) {
        specTypeService.insert(specType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:spectype:update")
    public R update(@RequestBody SpecTypeEntity specType) {
        specTypeService.updateById(specType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:spectype:delete")
    public R delete(@RequestBody Integer[] typeIds) {
        specTypeService.deleteBatchIds(Arrays.asList(typeIds));

        return R.ok();
    }

}
