<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="规格id" prop="specId">
        <el-input v-model="dataForm.specId" placeholder="规格id"></el-input>
      </el-form-item>
      <el-form-item label="规格项" prop="item">
        <el-input v-model="dataForm.item" placeholder="规格项"></el-input>
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
          id: 0,
          specId: '',
          item: '',
          storeId: ''
        },
        dataRule: {
          specId: [
            { required: true, message: '规格id不能为空', trigger: 'blur' }
          ],
          item: [
            { required: true, message: '规格项不能为空', trigger: 'blur' }
          ],
          storeId: [
            { required: true, message: '商家id不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            API.specitem.info(this.dataForm.id).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.specId = data.specitem.specId
                this.dataForm.item = data.specitem.item
                this.dataForm.storeId = data.specitem.storeId
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
              'id': this.dataForm.id || undefined,
              'specId': this.dataForm.specId,
              'item': this.dataForm.item,
              'storeId': this.dataForm.storeId
            }
            var tick = !this.dataForm.id ? API.specitem.add(params) : API.specitem.update(params)
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
