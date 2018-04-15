package com.b2cshop.modules.shop.goods.controller;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;
import com.b2cshop.modules.shop.goods.entity.SpecEntity;
import com.b2cshop.modules.shop.goods.service.SpecService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @author zhj
 * @email
 * @date 2018-04-01 16:17:09
 */
@RestController
@RequestMapping("shop/spec")
public class SpecController {
    @Autowired
    private SpecService specService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:spec:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = specService.list(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表 分类ID
     */
    @RequestMapping("/listSpecByIds")
    @RequiresPermissions("shop:spec:list")
    public R listSpecByIds(@RequestParam Map<String, Object> params) {
        List<SpecEntity> list = specService.listSpecByIds(params);
        return R.ok().put("list", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shop:spec:info")
    public R info(@PathVariable("id") Integer id) {
        SpecEntity spec = specService.selectById(id);

        return R.ok().put("spec", spec);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:spec:save")
    public R save(@RequestBody SpecEntity spec) {
        specService.insert(spec);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:spec:update")
    public R update(@RequestBody SpecEntity spec) {
        specService.updateById(spec);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:spec:delete")
    public R delete(@RequestBody Integer[] ids) {
        specService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
