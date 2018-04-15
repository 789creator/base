package com.b2cshop.modules.shop.goods.service.impl;

import com.b2cshop.common.utils.MapUtils;
import com.b2cshop.modules.shop.goods.entity.GoodsAttributeEntity;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;

import com.b2cshop.modules.shop.goods.dao.GoodsCategoryDao;
import com.b2cshop.modules.shop.goods.entity.GoodsCategoryEntity;
import com.b2cshop.modules.shop.goods.service.GoodsCategoryService;


@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryDao, GoodsCategoryEntity> implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryDao goodsCategoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsCategoryEntity> page = this.selectPage(
                new Query<GoodsCategoryEntity>(params).getPage(),
                new EntityWrapper<GoodsCategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<GoodsCategoryEntity> selectAllList() {
        List<GoodsCategoryEntity> list = goodsCategoryDao.selectList(null);
        Map<Integer, String> map = listToMap(list);
        for (GoodsCategoryEntity category : list) {
            category.setParentName(map.get(category.getParentId()));
        }
        return list;
    }

    @Override
    public Map<Integer, String> getCategoryNameMap() {
        //todo 优化，可以从缓存里面获取所以商品分类，修改商品分类之后重新缓存分类信息
        //todo 把下面这个map集合也可以放到缓存中
        //获取所属分类名称
        List<GoodsCategoryEntity> list = goodsCategoryDao.selectList(null);
        HashMap<Integer, String> map = Maps.newHashMap();
        for (GoodsCategoryEntity category : list) {
            map.put(category.getId(), category.getName());
        }
        return map;
    }

    private Map<Integer, String> listToMap(List<GoodsCategoryEntity> list) {
        HashMap<Integer, String> map = Maps.newHashMap();
        for (GoodsCategoryEntity category : list) {
            map.put(category.getId(), category.getName());
        }
        return map;
    }

}
