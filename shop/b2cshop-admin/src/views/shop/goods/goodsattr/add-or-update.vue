<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="商品id" prop="goodsId">
        <el-input v-model="dataForm.goodsId" placeholder="商品id"></el-input>
      </el-form-item>
      <el-form-item label="属性id" prop="attrId">
        <el-input v-model="dataForm.attrId" placeholder="属性id"></el-input>
      </el-form-item>
      <el-form-item label="属性值" prop="attrValue">
        <el-input v-model="dataForm.attrValue" placeholder="属性值"></el-input>
      </el-form-item>
      <el-form-item label="属性价格" prop="attrPrice">
        <el-input v-model="dataForm.attrPrice" placeholder="属性价格"></el-input>
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
          goodsAttrId: 0,
          goodsId: '',
          attrId: '',
          attrValue: '',
          attrPrice: ''
        },
        dataRule: {
          goodsId: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          attrId: [
            { required: true, message: '属性id不能为空', trigger: 'blur' }
          ],
          attrValue: [
            { required: true, message: '属性值不能为空', trigger: 'blur' }
          ],
          attrPrice: [
            { required: true, message: '属性价格不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.goodsAttrId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.goodsAttrId) {
            API.goodsattr.info(this.dataForm.goodsAttrId).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.goodsId = data.goodsattr.goodsId
                this.dataForm.attrId = data.goodsattr.attrId
                this.dataForm.attrValue = data.goodsattr.attrValue
                this.dataForm.attrPrice = data.goodsattr.attrPrice
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
              'goodsAttrId': this.dataForm.goodsAttrId || undefined,
              'goodsId': this.dataForm.goodsId,
              'attrId': this.dataForm.attrId,
              'attrValue': this.dataForm.attrValue,
              'attrPrice': this.dataForm.attrPrice
            }
            var tick = !this.dataForm.goodsAttrId ? API.goodsattr.add(params) : API.goodsattr.update(params)
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
