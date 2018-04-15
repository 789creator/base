<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('shop:goods:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('shop:goods:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;"
      >
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="goodsId"
        header-align="center"
        align="center"
        label="商品id">
      </el-table-column>
      <!--<el-table-column-->
        <!--prop="catId1"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="一级分类id">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="catId2"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="二级分类">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="catId3"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="三级分类">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="storeCatId1"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="本店一级分类">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="storeCatId2"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="本店二级分类">-->
      <!--</el-table-column>-->
      <el-table-column
        prop="goodsSn"
        header-align="center"
        align="center"
        width="120"
        label="商品编号">
      </el-table-column>
      <el-table-column
        prop="goodsName"
        header-align="center"
        align="center"
        width="160"
        label="商品名称">
      </el-table-column>
      <!--<el-table-column-->
        <!--prop="weight"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="商品重量克为单位">-->
      <!--</el-table-column>-->
      <el-table-column
        prop="marketPrice"
        header-align="center"
        align="center"
        width="100"
        label="市场价">
        <template slot-scope="scope">
          ￥{{scope.row.marketPrice }}
        </template>
      </el-table-column>
      <el-table-column
        prop="shopPrice"
        header-align="center"
        align="center"
        width="100"
        label="本店价">
        <template slot-scope="scope">
          ￥{{scope.row.shopPrice }}
        </template>
      </el-table-column>
      <el-table-column
        prop="costPrice"
        header-align="center"
        align="center"
        width="100"
        label="商品成本价">
        <template slot-scope="scope">
          ￥{{scope.row.shopPrice }}
        </template>
      </el-table-column>
      <!--<el-table-column-->
        <!--prop="exchangeIntegral"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="COMMENT '积分兑换：0不参与积分兑换">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="keywords"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="商品关键词">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="goodsRemark"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="商品简单描述">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="originalImg"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="商品上传原始图">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="isVirtual"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="是否为虚拟商品 1是，0否">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="virtualIndate"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="虚拟商品有效期">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="virtualLimit"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="虚拟商品购买上限">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="virtualRefund"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="是否允许过期退款， 1是，0否">-->
      <!--</el-table-column>-->
      <el-table-column
        prop="isOnSale"
        header-align="center"
        align="center"
        width="100"
        label="上下架">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.isOnSale == 0" type="warning">已下架</el-tag>
          <el-tag v-else-if="scope.row.isOnSale == 1" type="info">已上架</el-tag>
          <el-tag v-else-if="scope.row.isOnSale == 2" type="danger">违规下架</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="isFreeShipping"
        header-align="center"
        align="center"
        label="包邮">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.isFreeShipping == 0" type="warning">不包邮</el-tag>
          <el-tag v-else-if="scope.row.isFreeShipping == 1" type="info">包邮</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="onTime"
        width="150"
        header-align="center"
        align="center"
        label="商品上架时间"
        >
        <template slot-scope="scope">
          <span>{{ scope.row.onTime | formatDate }}</span>
        </template>
      </el-table-column>
      <!--<el-table-column-->
        <!--prop="sort"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="商品排序">-->
      <!--</el-table-column>-->
      <el-table-column
        prop="isRecommend"
        header-align="center"
        align="center"
        label="是否推荐">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.isRecommend == 0" type="info">不推荐</el-tag>
          <el-tag v-else-if="scope.row.isRecommend == 1" type="success">推荐</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="isNew"
        header-align="center"
        align="center"
        label="是否新品">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.isNew == 0" type="info">否</el-tag>
          <el-tag v-else-if="scope.row.isNew == 1" type="success">是</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="isHot"
        header-align="center"
        align="center"
        label="是否热卖">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.isHot == 0" type="info">否</el-tag>
          <el-tag v-else-if="scope.row.isHot == 1" type="success">是</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="clickCount"
        header-align="center"
        align="center"
        label="点击数">
      </el-table-column>
      <!--<el-table-column-->
      <!--prop="brandId"-->
      <!--header-align="center"-->
      <!--align="center"-->
      <!--label="品牌id">-->
      <!--</el-table-column>-->
      <el-table-column
        prop="storeCount"
        header-align="center"
        align="center"
        label="库存数量">
        <template slot-scope="scope">
          <span v-if="scope.row.storeCount > 10">{{scope.row.storeCount}}</span>
          <span v-else><el-tag type="danger">{{scope.row.storeCount}}</el-tag></span>
        </template>
      </el-table-column>
      <el-table-column
        prop="collectSum"
        header-align="center"
        align="center"
        label="商品收藏数">
      </el-table-column>
      <el-table-column
        prop="commentCount"
        header-align="center"
        align="center"
        label="商品评论数">
      </el-table-column>
      <el-table-column
        prop="lastUpdate"
        header-align="center"
        align="center"
        width="150"
        label="最后更新时间">
        <template slot-scope="scope">
          <span >{{ scope.row.lastUpdate | formatDate }}</span>
        </template>
      </el-table-column>
      <!--<el-table-column-->
        <!--prop="goodsType"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="商品所属类型id，取值表goods_type的id">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="giveIntegral"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="购买商品赠送积分">-->
      <!--</el-table-column>-->
      <el-table-column
        prop="salesSum"
        header-align="center"
        align="center"
        label="商品销量">
      </el-table-column>
      <!--<el-table-column-->
        <!--prop="promType"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="0默认1抢购2团购3优惠促销">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="promId"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="优惠活动id">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="distribut"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="佣金用于分销分成">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="storeId"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="商家店铺ID">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="spu"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="SPU">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="sku"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="SKU">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="goodsState"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="0待审核1审核通过2审核失败">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="closeReason"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="违规下架原因">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="suppliersId"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="供应商ID">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="shippingAreaIds"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="配送物流shipping_area_id,以逗号分隔">-->
      <!--</el-table-column>-->
      <!--<el-table-column-->
        <!--prop="isOwnShop"-->
        <!--header-align="center"-->
        <!--align="center"-->
        <!--label="1:第三方自营店,2:总平台自营店">-->
      <!--</el-table-column>-->
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="addOrUpdateHandle(scope.row.goodsId)">修改</el-button>
          <el-button size="mini" type="danger" @click="deleteHandle(scope.row.goodsId)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import API from '@/api'
  import AddOrUpdate from './add-or-update'
  import {formatDate} from '../../../../utils/date.js'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    filters:{
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh : mm');
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        var params = {
          page: this.pageIndex,
          limit: this.pageSize,
          key: this.dataForm.key
        }
        API.goods.list(params).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.goodsId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          API.goods.del(ids).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
<style scoped>
  .force-off-sale{
    color: #ff4d51;
  }
  .on-sale{

  }
  .off-sale{

  }
</style>
