<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="会员ID" prop="memberId">
        <el-input v-model="dataForm.memberId" placeholder="会员ID"></el-input>
      </el-form-item>
      <el-form-item label="浏览时间" prop="browsetime">
        <el-input v-model="dataForm.browsetime" placeholder="浏览时间"></el-input>
      </el-form-item>
      <el-form-item label="商品分类" prop="gcId">
        <el-input v-model="dataForm.gcId" placeholder="商品分类"></el-input>
      </el-form-item>
      <el-form-item label="商品一级分类" prop="gcId1">
        <el-input v-model="dataForm.gcId1" placeholder="商品一级分类"></el-input>
      </el-form-item>
      <el-form-item label="商品二级分类" prop="gcId2">
        <el-input v-model="dataForm.gcId2" placeholder="商品二级分类"></el-input>
      </el-form-item>
      <el-form-item label="商品三级分类" prop="gcId3">
        <el-input v-model="dataForm.gcId3" placeholder="商品三级分类"></el-input>
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
          memberId: '',
          browsetime: '',
          gcId: '',
          gcId1: '',
          gcId2: '',
          gcId3: ''
        },
        dataRule: {
          memberId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          browsetime: [
            { required: true, message: '浏览时间不能为空', trigger: 'blur' }
          ],
          gcId: [
            { required: true, message: '商品分类不能为空', trigger: 'blur' }
          ],
          gcId1: [
            { required: true, message: '商品一级分类不能为空', trigger: 'blur' }
          ],
          gcId2: [
            { required: true, message: '商品二级分类不能为空', trigger: 'blur' }
          ],
          gcId3: [
            { required: true, message: '商品三级分类不能为空', trigger: 'blur' }
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
            API.goodsbrowse.info(this.dataForm.goodsId).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memberId = data.goodsbrowse.memberId
                this.dataForm.browsetime = data.goodsbrowse.browsetime
                this.dataForm.gcId = data.goodsbrowse.gcId
                this.dataForm.gcId1 = data.goodsbrowse.gcId1
                this.dataForm.gcId2 = data.goodsbrowse.gcId2
                this.dataForm.gcId3 = data.goodsbrowse.gcId3
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
              'memberId': this.dataForm.memberId,
              'browsetime': this.dataForm.browsetime,
              'gcId': this.dataForm.gcId,
              'gcId1': this.dataForm.gcId1,
              'gcId2': this.dataForm.gcId2,
              'gcId3': this.dataForm.gcId3
            }
            var tick = !this.dataForm.goodsId ? API.goodsbrowse.add(params) : API.goodsbrowse.update(params)
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
