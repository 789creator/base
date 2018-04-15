<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()">
      <el-form-item>
        <el-col :span="10">
          <el-form-item label="规格名称" prop="name" label-width="100px">
            <el-input v-model="dataForm.name" placeholder="规格名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item label="排序" prop="order" label-width="100px">
            <el-input v-model="dataForm.order" placeholder="排序"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>

      <el-form-item label-width="100px">
        <el-checkbox name="searchIndex"
                     v-model="dataForm.searchIndex">是否检索
        </el-checkbox>
      </el-form-item>
      <el-form-item label="所属分类" label-width="100px">
        <el-cascader
          :options="categoryList"
          :props="props"
          v-model="selectedOptions"
          @change="handleChange">
        </el-cascader>
      </el-form-item>
      <el-form-item label="规格值类型" prop="specValType" label-width="100px">
        <el-select v-model="dataForm.specValType">
          <el-option
            v-for="item in specValTypes"
            :key="item.value"
            :label="item.label"
            :value="item.value">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="内容" prop="specVal" label-width="100px" v-show="dataForm.specValType==2">
        <el-col :span="12">
          <el-input
            type="textarea"
            size="small"
            :autosize="{ minRows: 4 }"
            placeholder="请输入内容"
            v-model="dataForm.specVal">
          </el-input>
        </el-col>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
      <el-button @click="visible = false">取消</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import API from '@/api'
  import {treeDataTranslate} from '@/utils'

  var spec = function () {
    return {
      id: 0,
      name: '',
      order: '',
      searchIndex: '',
      catId1: '',
      catId2: '',
      catId3: '',
      specValType: '',
      specVal: ''
    }
  }
  export default {
    data() {
      return {
        visible: false,
        categoryList: [],
        selectedOptions: [],
        specValTypes: [
          {
            value: 1,
            label: '商家自填'
          },
          {
            value: 2,
            label: '商家选择'
          }
        ],
        props: {
          label: "name",
          value: "id"
        },
        dataForm: new spec(),
        dataRule: {
          name: [
            {required: true, message: '规格名称不能为空', trigger: 'blur'}
          ],
          order: [
            {required: true, message: '排序不能为空', trigger: 'blur'}
          ],
          searchIndex: [
            {required: true, message: '是否需要检索不能为空', trigger: 'blur'}
          ],
          catId1: [
            {required: true, message: '一级分类不能为空', trigger: 'blur'}
          ],
          catId2: [
            {required: true, message: '二级分类不能为空', trigger: 'blur'}
          ],
          catId3: [
            {required: true, message: '三级分类不能为空', trigger: 'blur'}
          ],
          specValType: [
            {required: true, message: '规格值类型不能为空', trigger: 'blur'}
          ],
          specVal: [
            {required: true, message: '规格值内容不能为空', trigger: 'blur'}
          ]
        }
      }
    },
    components: {},
    methods: {
      init(row) {
        this.selectedOptions = new Array();

        //todo 优化，抽取这段代码，使用的地方比较多
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
        this.dataForm = new spec();
        this.dataForm.id = row ? row.id : 0;
        this.visible = true;
        this.$nextTick(() => {
          // this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.dataForm = row;
            this.dataForm.searchIndex = row.searchIndex == 1 ? true : false;

            if(this.dataForm.catId1){
              this.selectedOptions.push(this.dataForm.catId1);
            }
            if(this.dataForm.catId2){
              this.selectedOptions.push(this.dataForm.catId2);
            }
            if(this.dataForm.catId3){
              this.selectedOptions.push(this.dataForm.catId3);
            }

          }
        })
      },
      // 表单提交
      dataFormSubmit() {

        //禁用enter键的时候自动提交表单
        if (event.keyCode == 13) {
          return;
        }
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            var params = {
              'id': this.dataForm.id || undefined,
              'name': this.dataForm.name,
              'order': this.dataForm.order,
              'searchIndex': this.dataForm.searchIndex == true ? 1 : 0,
              'catId1': this.selectedOptions[0],
              'catId2': this.selectedOptions[1],
              'catId3': this.selectedOptions[2],
              'specValType': this.dataForm.specValType,
              'specVal': this.dataForm.specVal
            }
            var tick = !this.dataForm.id ? API.spec.add(params) : API.spec.update(params)
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
