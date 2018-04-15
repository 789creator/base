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

import com.b2cshop.modules.shop.goods.entity.GoodsConsultEntity;
import com.b2cshop.modules.shop.goods.service.GoodsConsultService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.R;



/**
 * 商品咨询
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@RestController
@RequestMapping("shop/goodsconsult")
public class GoodsConsultController {
    @Autowired
    private GoodsConsultService goodsConsultService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shop:goodsconsult:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsConsultService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shop:goodsconsult:info")
    public R info(@PathVariable("id") Integer id){
			GoodsConsultEntity goodsConsult = goodsConsultService.selectById(id);

        return R.ok().put("goodsConsult", goodsConsult);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shop:goodsconsult:save")
    public R save(@RequestBody GoodsConsultEntity goodsConsult){
			goodsConsultService.insert(goodsConsult);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shop:goodsconsult:update")
    public R update(@RequestBody GoodsConsultEntity goodsConsult){
			goodsConsultService.updateById(goodsConsult);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shop:goodsconsult:delete")
    public R delete(@RequestBody Integer[] ids){
			goodsConsultService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
