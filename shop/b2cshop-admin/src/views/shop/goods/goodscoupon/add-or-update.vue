<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="指定的商品id：为零表示不指定商品" prop="goodsId">
        <el-input v-model="dataForm.goodsId" placeholder="指定的商品id：为零表示不指定商品"></el-input>
      </el-form-item>
      <el-form-item label="指定的商品分类：为零表示不指定分类" prop="goodsCategoryId">
        <el-input v-model="dataForm.goodsCategoryId" placeholder="指定的商品分类：为零表示不指定分类"></el-input>
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
          couponId: 0,
          goodsId: '',
          goodsCategoryId: ''
        },
        dataRule: {
          goodsId: [
            { required: true, message: '指定的商品id：为零表示不指定商品不能为空', trigger: 'blur' }
          ],
          goodsCategoryId: [
            { required: true, message: '指定的商品分类：为零表示不指定分类不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.couponId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.couponId) {
            API.goodscoupon.info(this.dataForm.couponId).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.goodsId = data.goodscoupon.goodsId
                this.dataForm.goodsCategoryId = data.goodscoupon.goodsCategoryId
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
              'couponId': this.dataForm.couponId || undefined,
              'goodsId': this.dataForm.goodsId,
              'goodsCategoryId': this.dataForm.goodsCategoryId
            }
            var tick = !this.dataForm.couponId ? API.goodscoupon.add(params) : API.goodscoupon.update(params)
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
