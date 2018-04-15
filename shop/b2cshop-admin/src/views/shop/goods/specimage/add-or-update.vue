<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="规格项id" prop="specImageId">
        <el-input v-model="dataForm.specImageId" placeholder="规格项id"></el-input>
      </el-form-item>
      <el-form-item label="商品规格图片路径" prop="src">
        <el-input v-model="dataForm.src" placeholder="商品规格图片路径"></el-input>
      </el-form-item>
      <el-form-item label="商家id" prop="storeId">
        <el-input v-model="dataForm.storeId" placeholder="商家id"></el-input>
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
          specImageId: '',
          src: '',
          storeId: ''
        },
        dataRule: {
          specImageId: [
            { required: true, message: '规格项id不能为空', trigger: 'blur' }
          ],
          src: [
            { required: true, message: '商品规格图片路径不能为空', trigger: 'blur' }
          ],
          storeId: [
            { required: true, message: '商家id不能为空', trigger: 'blur' }
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
            API.specimage.info(this.dataForm.goodsId).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.specImageId = data.specimage.specImageId
                this.dataForm.src = data.specimage.src
                this.dataForm.storeId = data.specimage.storeId
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
              'specImageId': this.dataForm.specImageId,
              'src': this.dataForm.src,
              'storeId': this.dataForm.storeId
            }
            var tick = !this.dataForm.goodsId ? API.specimage.add(params) : API.specimage.update(params)
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
