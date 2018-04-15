package com.b2cshop.modules.shop.goods.service.impl;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;
import com.b2cshop.modules.shop.goods.dao.GoodsCategoryDao;
import com.b2cshop.modules.shop.goods.dao.SpecDao;
import com.b2cshop.modules.shop.goods.entity.GoodsCategoryEntity;
import com.b2cshop.modules.shop.goods.entity.SpecEntity;
import com.b2cshop.modules.shop.goods.service.GoodsCategoryService;
import com.b2cshop.modules.shop.goods.service.SpecService;
import com.b2cshop.modules.shop.goods.vo.SpecValVo;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("specService")
public class SpecServiceImpl extends ServiceImpl<SpecDao, SpecEntity> implements SpecService {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SpecEntity> page = this.selectPage(
                new Query<SpecEntity>(params).getPage(),
                new EntityWrapper<SpecEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils list(Map<String, Object> params) {
        Page<SpecEntity> page = this.selectPage(
                new Query<SpecEntity>(params).getPage(),
                new EntityWrapper<SpecEntity>()
        );
        Map<Integer, String> map = goodsCategoryService.getCategoryNameMap();

        for (SpecEntity spec : page.getRecords()) {
            spec.setCatId1Name(map.get(spec.getCatId1()));
            spec.setCatId2Name(map.get(spec.getCatId2()));
            spec.setCatId3Name(map.get(spec.getCatId3()));
        }
        return new PageUtils(page);
    }

    @Override
    public List<SpecEntity> listSpecByIds(Map<String, Object> params) {
        List<SpecEntity> list = this.selectByMap(params);
        Map<Integer, String> map = goodsCategoryService.getCategoryNameMap();
        for (SpecEntity spec : list) {
            spec.setCatId1Name(map.get(spec.getCatId1()));
            spec.setCatId2Name(map.get(spec.getCatId2()));
            spec.setCatId3Name(map.get(spec.getCatId3()));
            ArrayList<SpecValVo> arrayList = Lists.newArrayList();
            //对字符串进行切分处理
            String[] split = spec.getSpecVal().split("\n");
            for (int i = 0; i < split.length; i++) {
                SpecValVo specValVo = new SpecValVo();
                String[] split1 = split[i].split(":");
                specValVo.setOder(Integer.valueOf(split1[0]));
                specValVo.setSpecValName(split1[1]);
                arrayList.add(specValVo);
            }
            //排序
            arrayList.sort(new Comparator<SpecValVo>() {
                @Override
                public int compare(SpecValVo o1, SpecValVo o2) {
                    return o1.getOder() - o2.getOder();
                }
            });
            spec.setSpecValList(arrayList);
        }
        return list;
    }

}
