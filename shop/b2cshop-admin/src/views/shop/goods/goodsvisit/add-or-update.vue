<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="会员ID" prop="userId">
        <el-input v-model="dataForm.userId" placeholder="会员ID"></el-input>
      </el-form-item>
      <el-form-item label="浏览时间" prop="visittime">
        <el-input v-model="dataForm.visittime" placeholder="浏览时间"></el-input>
      </el-form-item>
      <el-form-item label="商品一级分类" prop="catId1">
        <el-input v-model="dataForm.catId1" placeholder="商品一级分类"></el-input>
      </el-form-item>
      <el-form-item label="商品二级分类" prop="catId2">
        <el-input v-model="dataForm.catId2" placeholder="商品二级分类"></el-input>
      </el-form-item>
      <el-form-item label="商品三级分类" prop="catId3">
        <el-input v-model="dataForm.catId3" placeholder="商品三级分类"></el-input>
      </el-form-item>
      <el-form-item label="自增ID" prop="visitId">
        <el-input v-model="dataForm.visitId" placeholder="自增ID"></el-input>
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
          userId: '',
          visittime: '',
          catId1: '',
          catId2: '',
          catId3: '',
          visitId: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          visittime: [
            { required: true, message: '浏览时间不能为空', trigger: 'blur' }
          ],
          catId1: [
            { required: true, message: '商品一级分类不能为空', trigger: 'blur' }
          ],
          catId2: [
            { required: true, message: '商品二级分类不能为空', trigger: 'blur' }
          ],
          catId3: [
            { required: true, message: '商品三级分类不能为空', trigger: 'blur' }
          ],
          visitId: [
            { required: true, message: '自增ID不能为空', trigger: 'blur' }
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
            API.goodsvisit.info(this.dataForm.goodsId).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.goodsvisit.userId
                this.dataForm.visittime = data.goodsvisit.visittime
                this.dataForm.catId1 = data.goodsvisit.catId1
                this.dataForm.catId2 = data.goodsvisit.catId2
                this.dataForm.catId3 = data.goodsvisit.catId3
                this.dataForm.visitId = data.goodsvisit.visitId
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
              'userId': this.dataForm.userId,
              'visittime': this.dataForm.visittime,
              'catId1': this.dataForm.catId1,
              'catId2': this.dataForm.catId2,
              'catId3': this.dataForm.catId3,
              'visitId': this.dataForm.visitId
            }
            var tick = !this.dataForm.goodsId ? API.goodsvisit.add(params) : API.goodsvisit.update(params)
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
