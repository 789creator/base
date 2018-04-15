<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="商品id" prop="goodsId">
        <el-input v-model="dataForm.goodsId" placeholder="商品id"></el-input>
      </el-form-item>
      <el-form-item label="图片地址" prop="imageUrl">
        <el-input v-model="dataForm.imageUrl" placeholder="图片地址"></el-input>
      </el-form-item>
      <el-form-item label="商品缩略图排序,最小的拍最前面" prop="imgSort">
        <el-input v-model="dataForm.imgSort" placeholder="商品缩略图排序,最小的拍最前面"></el-input>
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
          imgId: 0,
          goodsId: '',
          imageUrl: '',
          imgSort: ''
        },
        dataRule: {
          goodsId: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          imageUrl: [
            { required: true, message: '图片地址不能为空', trigger: 'blur' }
          ],
          imgSort: [
            { required: true, message: '商品缩略图排序,最小的拍最前面不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.imgId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.imgId) {
            API.goodsimages.info(this.dataForm.imgId).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.goodsId = data.goodsimages.goodsId
                this.dataForm.imageUrl = data.goodsimages.imageUrl
                this.dataForm.imgSort = data.goodsimages.imgSort
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
              'imgId': this.dataForm.imgId || undefined,
              'goodsId': this.dataForm.goodsId,
              'imageUrl': this.dataForm.imageUrl,
              'imgSort': this.dataForm.imgSort
            }
            var tick = !this.dataForm.imgId ? API.goodsimages.add(params) : API.goodsimages.update(params)
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
