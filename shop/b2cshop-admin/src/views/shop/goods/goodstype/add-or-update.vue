<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()">
      <el-form-item label="类型名称" prop="name" label-width="100px">
        <el-input v-model="dataForm.name" placeholder="类型名称" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="所属分类" label-width="100px">
        <el-cascader
          style="width: 300px"
          :options="categoryList"
          :props="props"
          v-model="selectedOptions"
          @change="handleChange">
        </el-cascader>
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

  var goodsType = function () {
    return {
      id: 0,
      name: '',
      catId1: '',
      catId2: '',
      catId3: ''
    }
  }
  export default {
    data() {
      return {
        visible: false,
        categoryList: [],
        props: {
          label: "name",
          value: "id"
        },
        selectedOptions: [],
        dataForm: new goodsType(),
        dataRule: {
          name: [
            {required: true, message: '类型名称不能为空', trigger: 'blur'}
          ],
          catId1: [
            {required: true, message: '一级分类id不能为空', trigger: 'blur'}
          ],
          catId2: [
            {required: true, message: '二级分类id不能为空', trigger: 'blur'}
          ],
          catId3: [
            {required: true, message: '三级分类id不能为空', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      init(row) {
        this.dataForm = new goodsType();
        this.selectedOptions = new Array();
        this.dataForm.id = row ? row.id : 0;
        this.visible = true;
        if (!sessionStorage.getItem("categoryList")) {
          API.goodscategory.list().then(({data}) => {
            if (data && data.code === 0) {
              this.categoryList = treeDataTranslate(data.list, 'id');
              //保存到sessionStorage，以便后面操作使用
              sessionStorage.setItem("categoryList", JSON.stringify(this.categoryList));
            } else {
            }
            this.dataListLoading = false
          });
        } else {
          this.categoryList = JSON.parse(sessionStorage.getItem("categoryList"));
        }
        this.$nextTick(() => {
          if (this.dataForm.id) {
            this.dataForm = row;

            if (this.dataForm.catId1) {
              this.selectedOptions.push(this.dataForm.catId1);
            }
            if (this.dataForm.catId2) {
              this.selectedOptions.push(this.dataForm.catId2);
            }
            if (this.dataForm.catId3) {
              this.selectedOptions.push(this.dataForm.catId3);
            }
          }
        })
      },
      // 表单提交
      dataFormSubmit() {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            var params = {
              'id': this.dataForm.id || undefined,
              'name': this.dataForm.name,
              'catId1': this.selectedOptions[0],
              'catId2': this.selectedOptions[1],
              'catId3': this.selectedOptions[2]
            }
            var tick = !this.dataForm.id ? API.goodstype.add(params) : API.goodstype.update(params)
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
      },
      handleChange(value) {
        console.log(value);
      }
    }
  }
</script>
