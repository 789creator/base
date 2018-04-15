<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="商品id" prop="goodsId">
        <el-input v-model="dataForm.goodsId" placeholder="商品id"></el-input>
      </el-form-item>
      <el-form-item label="网名" prop="username">
        <el-input v-model="dataForm.username" placeholder="网名"></el-input>
      </el-form-item>
      <el-form-item label="咨询时间" prop="addTime">
        <el-input v-model="dataForm.addTime" placeholder="咨询时间"></el-input>
      </el-form-item>
      <el-form-item label="1 商品咨询 2 支付咨询 3 配送 4 售后" prop="consultType">
        <el-input v-model="dataForm.consultType" placeholder="1 商品咨询 2 支付咨询 3 配送 4 售后"></el-input>
      </el-form-item>
      <el-form-item label="咨询内容" prop="content">
        <el-input v-model="dataForm.content" placeholder="咨询内容"></el-input>
      </el-form-item>
      <el-form-item label="父id 用于管理员回复" prop="parentId">
        <el-input v-model="dataForm.parentId" placeholder="父id 用于管理员回复"></el-input>
      </el-form-item>
      <el-form-item label="店铺id" prop="storeId">
        <el-input v-model="dataForm.storeId" placeholder="店铺id"></el-input>
      </el-form-item>
      <el-form-item label="是否显示" prop="isShow">
        <el-input v-model="dataForm.isShow" placeholder="是否显示"></el-input>
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
          goodsId: '',
          username: '',
          addTime: '',
          consultType: '',
          content: '',
          parentId: '',
          storeId: '',
          isShow: ''
        },
        dataRule: {
          goodsId: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          username: [
            { required: true, message: '网名不能为空', trigger: 'blur' }
          ],
          addTime: [
            { required: true, message: '咨询时间不能为空', trigger: 'blur' }
          ],
          consultType: [
            { required: true, message: '1 商品咨询 2 支付咨询 3 配送 4 售后不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '咨询内容不能为空', trigger: 'blur' }
          ],
          parentId: [
            { required: true, message: '父id 用于管理员回复不能为空', trigger: 'blur' }
          ],
          storeId: [
            { required: true, message: '店铺id不能为空', trigger: 'blur' }
          ],
          isShow: [
            { required: true, message: '是否显示不能为空', trigger: 'blur' }
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
            API.goodsconsult.info(this.dataForm.id).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.goodsId = data.goodsconsult.goodsId
                this.dataForm.username = data.goodsconsult.username
                this.dataForm.addTime = data.goodsconsult.addTime
                this.dataForm.consultType = data.goodsconsult.consultType
                this.dataForm.content = data.goodsconsult.content
                this.dataForm.parentId = data.goodsconsult.parentId
                this.dataForm.storeId = data.goodsconsult.storeId
                this.dataForm.isShow = data.goodsconsult.isShow
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
              'goodsId': this.dataForm.goodsId,
              'username': this.dataForm.username,
              'addTime': this.dataForm.addTime,
              'consultType': this.dataForm.consultType,
              'content': this.dataForm.content,
              'parentId': this.dataForm.parentId,
              'storeId': this.dataForm.storeId,
              'isShow': this.dataForm.isShow
            }
            var tick = !this.dataForm.id ? API.goodsconsult.add(params) : API.goodsconsult.update(params)
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
