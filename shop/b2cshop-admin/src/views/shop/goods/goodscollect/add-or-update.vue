<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="用户id" prop="userId">
        <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
      </el-form-item>
      <el-form-item label="商品id" prop="goodsId">
        <el-input v-model="dataForm.goodsId" placeholder="商品id"></el-input>
      </el-form-item>
      <el-form-item label="" prop="catId3">
        <el-input v-model="dataForm.catId3" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="添加时间" prop="addTime">
        <el-input v-model="dataForm.addTime" placeholder="添加时间"></el-input>
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
          collectId: 0,
          userId: '',
          goodsId: '',
          catId3: '',
          addTime: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          goodsId: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          catId3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          addTime: [
            { required: true, message: '添加时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.collectId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.collectId) {
            API.goodscollect.info(this.dataForm.collectId).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.goodscollect.userId
                this.dataForm.goodsId = data.goodscollect.goodsId
                this.dataForm.catId3 = data.goodscollect.catId3
                this.dataForm.addTime = data.goodscollect.addTime
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
              'collectId': this.dataForm.collectId || undefined,
              'userId': this.dataForm.userId,
              'goodsId': this.dataForm.goodsId,
              'catId3': this.dataForm.catId3,
              'addTime': this.dataForm.addTime
            }
            var tick = !this.dataForm.collectId ? API.goodscollect.add(params) : API.goodscollect.update(params)
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
