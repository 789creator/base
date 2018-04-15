<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="一级分类id" prop="catId1">
        <el-input v-model="dataForm.catId1" placeholder="一级分类id"></el-input>
      </el-form-item>
      <el-form-item label="二级分类" prop="catId2">
        <el-input v-model="dataForm.catId2" placeholder="二级分类"></el-input>
      </el-form-item>
      <el-form-item label="三级分类" prop="catId3">
        <el-input v-model="dataForm.catId3" placeholder="三级分类"></el-input>
      </el-form-item>
      <el-form-item label="本店一级分类" prop="storeCatId1">
        <el-input v-model="dataForm.storeCatId1" placeholder="本店一级分类"></el-input>
      </el-form-item>
      <el-form-item label="本店二级分类" prop="storeCatId2">
        <el-input v-model="dataForm.storeCatId2" placeholder="本店二级分类"></el-input>
      </el-form-item>
      <el-form-item label="商品编号" prop="goodsSn">
        <el-input v-model="dataForm.goodsSn" placeholder="商品编号"></el-input>
      </el-form-item>
      <el-form-item label="商品名称" prop="goodsName">
        <el-input v-model="dataForm.goodsName" placeholder="商品名称"></el-input>
      </el-form-item>
      <el-form-item label="点击数" prop="clickCount">
        <el-input v-model="dataForm.clickCount" placeholder="点击数"></el-input>
      </el-form-item>
      <el-form-item label="品牌id" prop="brandId">
        <el-input v-model="dataForm.brandId" placeholder="品牌id"></el-input>
      </el-form-item>
      <el-form-item label="库存数量" prop="storeCount">
        <el-input v-model="dataForm.storeCount" placeholder="库存数量"></el-input>
      </el-form-item>
      <el-form-item label="商品收藏数" prop="collectSum">
        <el-input v-model="dataForm.collectSum" placeholder="商品收藏数"></el-input>
      </el-form-item>
      <el-form-item label="商品评论数" prop="commentCount">
        <el-input v-model="dataForm.commentCount" placeholder="商品评论数"></el-input>
      </el-form-item>
      <el-form-item label="商品重量克为单位" prop="weight">
        <el-input v-model="dataForm.weight" placeholder="商品重量克为单位"></el-input>
      </el-form-item>
      <el-form-item label="市场价" prop="marketPrice">
        <el-input v-model="dataForm.marketPrice" placeholder="市场价"></el-input>
      </el-form-item>
      <el-form-item label="本店价" prop="shopPrice">
        <el-input v-model="dataForm.shopPrice" placeholder="本店价"></el-input>
      </el-form-item>
      <el-form-item label="商品成本价" prop="costPrice">
        <el-input v-model="dataForm.costPrice" placeholder="商品成本价"></el-input>
      </el-form-item>
      <el-form-item label="COMMENT '积分兑换：0不参与积分兑换" prop="exchangeIntegral">
        <el-input v-model="dataForm.exchangeIntegral" placeholder="COMMENT '积分兑换：0不参与积分兑换"></el-input>
      </el-form-item>
      <el-form-item label="商品关键词" prop="keywords">
        <el-input v-model="dataForm.keywords" placeholder="商品关键词"></el-input>
      </el-form-item>
      <el-form-item label="商品简单描述" prop="goodsRemark">
        <el-input v-model="dataForm.goodsRemark" placeholder="商品简单描述"></el-input>
      </el-form-item>
      <el-form-item label="商品上传原始图" prop="originalImg">
        <el-input v-model="dataForm.originalImg" placeholder="商品上传原始图"></el-input>
      </el-form-item>
      <el-form-item label="是否为虚拟商品 1是，0否" prop="isVirtual">
        <el-input v-model="dataForm.isVirtual" placeholder="是否为虚拟商品 1是，0否"></el-input>
      </el-form-item>
      <el-form-item label="虚拟商品有效期" prop="virtualIndate">
        <el-input v-model="dataForm.virtualIndate" placeholder="虚拟商品有效期"></el-input>
      </el-form-item>
      <el-form-item label="虚拟商品购买上限" prop="virtualLimit">
        <el-input v-model="dataForm.virtualLimit" placeholder="虚拟商品购买上限"></el-input>
      </el-form-item>
      <el-form-item label="是否允许过期退款， 1是，0否" prop="virtualRefund">
        <el-input v-model="dataForm.virtualRefund" placeholder="是否允许过期退款， 1是，0否"></el-input>
      </el-form-item>
      <el-form-item label="0下架1上架2违规下架" prop="isOnSale">
        <el-input v-model="dataForm.isOnSale" placeholder="0下架1上架2违规下架"></el-input>
      </el-form-item>
      <el-form-item label="是否包邮0否1是" prop="isFreeShipping">
        <el-input v-model="dataForm.isFreeShipping" placeholder="是否包邮0否1是"></el-input>
      </el-form-item>
      <el-form-item label="商品上架时间" prop="onTime">
        <el-input v-model="dataForm.onTime" placeholder="商品上架时间"></el-input>
      </el-form-item>
      <el-form-item label="商品排序" prop="sort">
        <el-input v-model="dataForm.sort" placeholder="商品排序"></el-input>
      </el-form-item>
      <el-form-item label="是否推荐" prop="isRecommend">
        <el-input v-model="dataForm.isRecommend" placeholder="是否推荐"></el-input>
      </el-form-item>
      <el-form-item label="是否新品" prop="isNew">
        <el-input v-model="dataForm.isNew" placeholder="是否新品"></el-input>
      </el-form-item>
      <el-form-item label="是否热卖" prop="isHot">
        <el-input v-model="dataForm.isHot" placeholder="是否热卖"></el-input>
      </el-form-item>
      <el-form-item label="最后更新时间" prop="lastUpdate">
        <el-input v-model="dataForm.lastUpdate" placeholder="最后更新时间"></el-input>
      </el-form-item>
      <el-form-item label="商品所属类型id，取值表goods_type的id" prop="goodsType">
        <el-input v-model="dataForm.goodsType" placeholder="商品所属类型id，取值表goods_type的id"></el-input>
      </el-form-item>
      <el-form-item label="购买商品赠送积分" prop="giveIntegral">
        <el-input v-model="dataForm.giveIntegral" placeholder="购买商品赠送积分"></el-input>
      </el-form-item>
      <el-form-item label="商品销量" prop="salesSum">
        <el-input v-model="dataForm.salesSum" placeholder="商品销量"></el-input>
      </el-form-item>
      <el-form-item label="0默认1抢购2团购3优惠促销" prop="promType">
        <el-input v-model="dataForm.promType" placeholder="0默认1抢购2团购3优惠促销"></el-input>
      </el-form-item>
      <el-form-item label="优惠活动id" prop="promId">
        <el-input v-model="dataForm.promId" placeholder="优惠活动id"></el-input>
      </el-form-item>
      <el-form-item label="佣金用于分销分成" prop="distribut">
        <el-input v-model="dataForm.distribut" placeholder="佣金用于分销分成"></el-input>
      </el-form-item>
      <el-form-item label="商家店铺ID" prop="storeId">
        <el-input v-model="dataForm.storeId" placeholder="商家店铺ID"></el-input>
      </el-form-item>
      <el-form-item label="SPU" prop="spu">
        <el-input v-model="dataForm.spu" placeholder="SPU"></el-input>
      </el-form-item>
      <el-form-item label="SKU" prop="sku">
        <el-input v-model="dataForm.sku" placeholder="SKU"></el-input>
      </el-form-item>
      <el-form-item label="0待审核1审核通过2审核失败" prop="goodsState">
        <el-input v-model="dataForm.goodsState" placeholder="0待审核1审核通过2审核失败"></el-input>
      </el-form-item>
      <el-form-item label="违规下架原因" prop="closeReason">
        <el-input v-model="dataForm.closeReason" placeholder="违规下架原因"></el-input>
      </el-form-item>
      <el-form-item label="供应商ID" prop="suppliersId">
        <el-input v-model="dataForm.suppliersId" placeholder="供应商ID"></el-input>
      </el-form-item>
      <el-form-item label="配送物流shipping_area_id,以逗号分隔" prop="shippingAreaIds">
        <el-input v-model="dataForm.shippingAreaIds" placeholder="配送物流shipping_area_id,以逗号分隔"></el-input>
      </el-form-item>
      <el-form-item label="1:第三方自营店,2:总平台自营店" prop="isOwnShop">
        <el-input v-model="dataForm.isOwnShop" placeholder="1:第三方自营店,2:总平台自营店"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import API from '@/api'
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          goodsId: 0,
          catId1: '',
          catId2: '',
          catId3: '',
          storeCatId1: '',
          storeCatId2: '',
          goodsSn: '',
          goodsName: '',
          clickCount: '',
          brandId: '',
          storeCount: '',
          collectSum: '',
          commentCount: '',
          weight: '',
          marketPrice: '',
          shopPrice: '',
          costPrice: '',
          exchangeIntegral: '',
          keywords: '',
          goodsRemark: '',
          originalImg: '',
          isVirtual: '',
          virtualIndate: '',
          virtualLimit: '',
          virtualRefund: '',
          isOnSale: '',
          isFreeShipping: '',
          onTime: '',
          sort: '',
          isRecommend: '',
          isNew: '',
          isHot: '',
          lastUpdate: '',
          goodsType: '',
          giveIntegral: '',
          salesSum: '',
          promType: '',
          promId: '',
          distribut: '',
          storeId: '',
          spu: '',
          sku: '',
          goodsState: '',
          closeReason: '',
          suppliersId: '',
          shippingAreaIds: '',
          isOwnShop: ''
        },
        dataRule: {
          catId1: [
            { required: true, message: '一级分类id不能为空', trigger: 'blur' }
          ],
          catId2: [
            { required: true, message: '二级分类不能为空', trigger: 'blur' }
          ],
          catId3: [
            { required: true, message: '三级分类不能为空', trigger: 'blur' }
          ],
          storeCatId1: [
            { required: true, message: '本店一级分类不能为空', trigger: 'blur' }
          ],
          storeCatId2: [
            { required: true, message: '本店二级分类不能为空', trigger: 'blur' }
          ],
          goodsSn: [
            { required: true, message: '商品编号不能为空', trigger: 'blur' }
          ],
          goodsName: [
            { required: true, message: '商品名称不能为空', trigger: 'blur' }
          ],
          clickCount: [
            { required: true, message: '点击数不能为空', trigger: 'blur' }
          ],
          brandId: [
            { required: true, message: '品牌id不能为空', trigger: 'blur' }
          ],
          storeCount: [
            { required: true, message: '库存数量不能为空', trigger: 'blur' }
          ],
          collectSum: [
            { required: true, message: '商品收藏数不能为空', trigger: 'blur' }
          ],
          commentCount: [
            { required: true, message: '商品评论数不能为空', trigger: 'blur' }
          ],
          weight: [
            { required: true, message: '商品重量克为单位不能为空', trigger: 'blur' }
          ],
          marketPrice: [
            { required: true, message: '市场价不能为空', trigger: 'blur' }
          ],
          shopPrice: [
            { required: true, message: '本店价不能为空', trigger: 'blur' }
          ],
          costPrice: [
            { required: true, message: '商品成本价不能为空', trigger: 'blur' }
          ],
          exchangeIntegral: [
            { required: true, message: 'COMMENT 积分兑换：0不参与积分兑换不能为空', trigger: 'blur' }
          ],
          keywords: [
            { required: true, message: '商品关键词不能为空', trigger: 'blur' }
          ],
          goodsRemark: [
            { required: true, message: '商品简单描述不能为空', trigger: 'blur' }
          ],
          originalImg: [
            { required: true, message: '商品上传原始图不能为空', trigger: 'blur' }
          ],
          isVirtual: [
            { required: true, message: '是否为虚拟商品 1是，0否不能为空', trigger: 'blur' }
          ],
          virtualIndate: [
            { required: true, message: '虚拟商品有效期不能为空', trigger: 'blur' }
          ],
          virtualLimit: [
            { required: true, message: '虚拟商品购买上限不能为空', trigger: 'blur' }
          ],
          virtualRefund: [
            { required: true, message: '是否允许过期退款， 1是，0否不能为空', trigger: 'blur' }
          ],
          isOnSale: [
            { required: true, message: '0下架1上架2违规下架不能为空', trigger: 'blur' }
          ],
          isFreeShipping: [
            { required: true, message: '是否包邮0否1是不能为空', trigger: 'blur' }
          ],
          onTime: [
            { required: true, message: '商品上架时间不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '商品排序不能为空', trigger: 'blur' }
          ],
          isRecommend: [
            { required: true, message: '是否推荐不能为空', trigger: 'blur' }
          ],
          isNew: [
            { required: true, message: '是否新品不能为空', trigger: 'blur' }
          ],
          isHot: [
            { required: true, message: '是否热卖不能为空', trigger: 'blur' }
          ],
          lastUpdate: [
            { required: true, message: '最后更新时间不能为空', trigger: 'blur' }
          ],
          goodsType: [
            { required: true, message: '商品所属类型id，取值表goods_type的id不能为空', trigger: 'blur' }
          ],
          giveIntegral: [
            { required: true, message: '购买商品赠送积分不能为空', trigger: 'blur' }
          ],
          salesSum: [
            { required: true, message: '商品销量不能为空', trigger: 'blur' }
          ],
          promType: [
            { required: true, message: '0默认1抢购2团购3优惠促销不能为空', trigger: 'blur' }
          ],
          promId: [
            { required: true, message: '优惠活动id不能为空', trigger: 'blur' }
          ],
          distribut: [
            { required: true, message: '佣金用于分销分成不能为空', trigger: 'blur' }
          ],
          storeId: [
            { required: true, message: '商家店铺ID不能为空', trigger: 'blur' }
          ],
          spu: [
            { required: true, message: 'SPU不能为空', trigger: 'blur' }
          ],
          sku: [
            { required: true, message: 'SKU不能为空', trigger: 'blur' }
          ],
          goodsState: [
            { required: true, message: '0待审核1审核通过2审核失败不能为空', trigger: 'blur' }
          ],
          closeReason: [
            { required: true, message: '违规下架原因不能为空', trigger: 'blur' }
          ],
          suppliersId: [
            { required: true, message: '供应商ID不能为空', trigger: 'blur' }
          ],
          shippingAreaIds: [
            { required: true, message: '配送物流shipping_area_id,以逗号分隔不能为空', trigger: 'blur' }
          ],
          isOwnShop: [
            { required: true, message: '1:第三方自营店,2:总平台自营店不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.goodsId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.goodsId) {
            API.goods.info(this.dataForm.goodsId).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.catId1 = data.goods.catId1
                this.dataForm.catId2 = data.goods.catId2
                this.dataForm.catId3 = data.goods.catId3
                this.dataForm.storeCatId1 = data.goods.storeCatId1
                this.dataForm.storeCatId2 = data.goods.storeCatId2
                this.dataForm.goodsSn = data.goods.goodsSn
                this.dataForm.goodsName = data.goods.goodsName
                this.dataForm.clickCount = data.goods.clickCount
                this.dataForm.brandId = data.goods.brandId
                this.dataForm.storeCount = data.goods.storeCount
                this.dataForm.collectSum = data.goods.collectSum
                this.dataForm.commentCount = data.goods.commentCount
                this.dataForm.weight = data.goods.weight
                this.dataForm.marketPrice = data.goods.marketPrice
                this.dataForm.shopPrice = data.goods.shopPrice
                this.dataForm.costPrice = data.goods.costPrice
                this.dataForm.exchangeIntegral = data.goods.exchangeIntegral
                this.dataForm.keywords = data.goods.keywords
                this.dataForm.goodsRemark = data.goods.goodsRemark
                this.dataForm.originalImg = data.goods.originalImg
                this.dataForm.isVirtual = data.goods.isVirtual
                this.dataForm.virtualIndate = data.goods.virtualIndate
                this.dataForm.virtualLimit = data.goods.virtualLimit
                this.dataForm.virtualRefund = data.goods.virtualRefund
                this.dataForm.isOnSale = data.goods.isOnSale
                this.dataForm.isFreeShipping = data.goods.isFreeShipping
                this.dataForm.onTime = data.goods.onTime
                this.dataForm.sort = data.goods.sort
                this.dataForm.isRecommend = data.goods.isRecommend
                this.dataForm.isNew = data.goods.isNew
                this.dataForm.isHot = data.goods.isHot
                this.dataForm.lastUpdate = data.goods.lastUpdate
                this.dataForm.goodsType = data.goods.goodsType
                this.dataForm.giveIntegral = data.goods.giveIntegral
                this.dataForm.salesSum = data.goods.salesSum
                this.dataForm.promType = data.goods.promType
                this.dataForm.promId = data.goods.promId
                this.dataForm.distribut = data.goods.distribut
                this.dataForm.storeId = data.goods.storeId
                this.dataForm.spu = data.goods.spu
                this.dataForm.sku = data.goods.sku
                this.dataForm.goodsState = data.goods.goodsState
                this.dataForm.closeReason = data.goods.closeReason
                this.dataForm.suppliersId = data.goods.suppliersId
                this.dataForm.shippingAreaIds = data.goods.shippingAreaIds
                this.dataForm.isOwnShop = data.goods.isOwnShop
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            var params = {
              'goodsId': this.dataForm.goodsId || undefined,
              'catId1': this.dataForm.catId1,
              'catId2': this.dataForm.catId2,
              'catId3': this.dataForm.catId3,
              'storeCatId1': this.dataForm.storeCatId1,
              'storeCatId2': this.dataForm.storeCatId2,
              'goodsSn': this.dataForm.goodsSn,
              'goodsName': this.dataForm.goodsName,
              'clickCount': this.dataForm.clickCount,
              'brandId': this.dataForm.brandId,
              'storeCount': this.dataForm.storeCount,
              'collectSum': this.dataForm.collectSum,
              'commentCount': this.dataForm.commentCount,
              'weight': this.dataForm.weight,
              'marketPrice': this.dataForm.marketPrice,
              'shopPrice': this.dataForm.shopPrice,
              'costPrice': this.dataForm.costPrice,
              'exchangeIntegral': this.dataForm.exchangeIntegral,
              'keywords': this.dataForm.keywords,
              'goodsRemark': this.dataForm.goodsRemark,
              'originalImg': this.dataForm.originalImg,
              'isVirtual': this.dataForm.isVirtual,
              'virtualIndate': this.dataForm.virtualIndate,
              'virtualLimit': this.dataForm.virtualLimit,
              'virtualRefund': this.dataForm.virtualRefund,
              'isOnSale': this.dataForm.isOnSale,
              'isFreeShipping': this.dataForm.isFreeShipping,
              'onTime': this.dataForm.onTime,
              'sort': this.dataForm.sort,
              'isRecommend': this.dataForm.isRecommend,
              'isNew': this.dataForm.isNew,
              'isHot': this.dataForm.isHot,
              'lastUpdate': this.dataForm.lastUpdate,
              'goodsType': this.dataForm.goodsType,
              'giveIntegral': this.dataForm.giveIntegral,
              'salesSum': this.dataForm.salesSum,
              'promType': this.dataForm.promType,
              'promId': this.dataForm.promId,
              'distribut': this.dataForm.distribut,
              'storeId': this.dataForm.storeId,
              'spu': this.dataForm.spu,
              'sku': this.dataForm.sku,
              'goodsState': this.dataForm.goodsState,
              'closeReason': this.dataForm.closeReason,
              'suppliersId': this.dataForm.suppliersId,
              'shippingAreaIds': this.dataForm.shippingAreaIds,
              'isOwnShop': this.dataForm.isOwnShop
            }
            var tick = !this.dataForm.goodsId ? API.goods.add(params) : API.goods.update(params)
            tick.then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
