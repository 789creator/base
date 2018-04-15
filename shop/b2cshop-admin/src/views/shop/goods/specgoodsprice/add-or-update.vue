<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="商品id" prop="goodsId">
        <el-input v-model="dataForm.goodsId" placeholder="商品id"></el-input>
      </el-form-item>
      <el-form-item label="商品规格备注" prop="goodsMark">
        <el-input v-model="dataForm.goodsMark" placeholder="商品规格备注"></el-input>
      </el-form-item>
      <el-form-item label="规格键名" prop="key">
        <el-input v-model="dataForm.key" placeholder="规格键名"></el-input>
      </el-form-item>
      <el-form-item label="规格键名中文" prop="keyName">
        <el-input v-model="dataForm.keyName" placeholder="规格键名中文"></el-input>
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input v-model="dataForm.price" placeholder="价格"></el-input>
      </el-form-item>
      <el-form-item label="库存数量" prop="storeCount">
        <el-input v-model="dataForm.storeCount" placeholder="库存数量"></el-input>
      </el-form-item>
      <el-form-item label="商品条形码" prop="barCode">
        <el-input v-model="dataForm.barCode" placeholder="商品条形码"></el-input>
      </el-form-item>
      <el-form-item label="SKU" prop="sku">
        <el-input v-model="dataForm.sku" placeholder="SKU"></el-input>
      </el-form-item>
      <el-form-item label="店铺商家id" prop="storeId">
        <el-input v-model="dataForm.storeId" placeholder="店铺商家id"></el-input>
      </el-form-item>
      <el-form-item label="规格商品主图" prop="specImg">
        <el-input v-model="dataForm.specImg" placeholder="规格商品主图"></el-input>
      </el-form-item>
      <el-form-item label="参加活动id" prop="promId">
        <el-input v-model="dataForm.promId" placeholder="参加活动id"></el-input>
      </el-form-item>
      <el-form-item label="参加活动类型" prop="promType">
        <el-input v-model="dataForm.promType" placeholder="参加活动类型"></el-input>
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
          itemId: 0,
          goodsId: '',
          goodsMark: '',
          key: '',
          keyName: '',
          price: '',
          storeCount: '',
          barCode: '',
          sku: '',
          storeId: '',
          specImg: '',
          promId: '',
          promType: ''
        },
        dataRule: {
          goodsId: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          goodsMark: [
            { required: true, message: '商品规格备注不能为空', trigger: 'blur' }
          ],
          key: [
            { required: true, message: '规格键名不能为空', trigger: 'blur' }
          ],
          keyName: [
            { required: true, message: '规格键名中文不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '价格不能为空', trigger: 'blur' }
          ],
          storeCount: [
            { required: true, message: '库存数量不能为空', trigger: 'blur' }
          ],
          barCode: [
            { required: true, message: '商品条形码不能为空', trigger: 'blur' }
          ],
          sku: [
            { required: true, message: 'SKU不能为空', trigger: 'blur' }
          ],
          storeId: [
            { required: true, message: '店铺商家id不能为空', trigger: 'blur' }
          ],
          specImg: [
            { required: true, message: '规格商品主图不能为空', trigger: 'blur' }
          ],
          promId: [
            { required: true, message: '参加活动id不能为空', trigger: 'blur' }
          ],
          promType: [
            { required: true, message: '参加活动类型不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.itemId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.itemId) {
            API.specgoodsprice.info(this.dataForm.itemId).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.goodsId = data.specgoodsprice.goodsId
                this.dataForm.goodsMark = data.specgoodsprice.goodsMark
                this.dataForm.key = data.specgoodsprice.key
                this.dataForm.keyName = data.specgoodsprice.keyName
                this.dataForm.price = data.specgoodsprice.price
                this.dataForm.storeCount = data.specgoodsprice.storeCount
                this.dataForm.barCode = data.specgoodsprice.barCode
                this.dataForm.sku = data.specgoodsprice.sku
                this.dataForm.storeId = data.specgoodsprice.storeId
                this.dataForm.specImg = data.specgoodsprice.specImg
                this.dataForm.promId = data.specgoodsprice.promId
                this.dataForm.promType = data.specgoodsprice.promType
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
              'itemId': this.dataForm.itemId || undefined,
              'goodsId': this.dataForm.goodsId,
              'goodsMark': this.dataForm.goodsMark,
              'key': this.dataForm.key,
              'keyName': this.dataForm.keyName,
              'price': this.dataForm.price,
              'storeCount': this.dataForm.storeCount,
              'barCode': this.dataForm.barCode,
              'sku': this.dataForm.sku,
              'storeId': this.dataForm.storeId,
              'specImg': this.dataForm.specImg,
              'promId': this.dataForm.promId,
              'promType': this.dataForm.promType
            }
            var tick = !this.dataForm.itemId ? API.specgoodsprice.add(params) : API.specgoodsprice.update(params)
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
