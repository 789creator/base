<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()">
      <el-form-item>
        <el-col :span="10">
          <el-form-item label="属性名称" prop="attrName" label-width="100px">
            <el-input v-model="dataForm.attrName" placeholder="属性名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item label="所属分类" label-width="100px">
            <el-col :span="30">
              <el-popover
                ref="categoryListPopover"
                placement="bottom-end"
                trigger="click">
                <div style="height:300px;overflow: auto">
                  <el-tree
                    :data="categoryList"
                    :props="categoryListTreeProps"
                    node-key="categoryId"
                    ref="categoryListTree"
                    @current-change="categoryListTreeCurrentChangeHandle"
                    :default-expand-all="true"
                    :highlight-current="true"
                    :expand-on-click-node="false">
                  </el-tree>
                </div>
              </el-popover>
              <el-input v-model="dataForm.typeName" v-popover:categoryListPopover :readonly="true" placeholder="点击选择所属"
                        class="menu-list__input"></el-input>
            </el-col>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item style="margin-left: 100px;">
        <el-col :span="10">
          <el-checkbox name="attrIndex"
                       v-model="dataForm.attrIndex">是否检索
          </el-checkbox>
          <el-checkbox name="attrType" v-model="dataForm.attrType">是否商家选择
          </el-checkbox>
        </el-col>
        <el-col :span="9">
          <el-form-item label="排序" label-width="80px">
            <el-input v-model="dataForm.order"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-col :span="10">
          <el-form-item label="录入方式" prop="attrInputType" label-width="100px">
            <el-input v-model="dataForm.attrInputType" placeholder="2多行文本框,平台属性录入方式"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item label="可选值列表" prop="attrValues" label-width="100px">
            <el-input v-model="dataForm.attrValues" placeholder="英文状态下分号隔开"></el-input>
          </el-form-item>
        </el-col>
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

  var goodAttribute = function () {
    return {
      attrId: 0,
      attrName: '',
      typeId: '',
      typeName: '',
      attrIndex: 0,
      attrType: 0,
      attrInputType: '',
      attrValues: '',
      order: ''
    }
  }
  export default {

    data() {
      return {
        visible: false,
        categoryList: [],
        categoryListTreeProps: {
          label: 'name',
          children: 'children'
        },
        dataForm: new goodAttribute(),
        dataRule: {
          attrName: [
            {required: true, message: '属性名称不能为空', trigger: 'blur'}
          ],
          typeId: [
            {required: true, message: '属性分类id不能为空', trigger: 'blur'}
          ],
          attrIndex: [
            {required: true, message: '0不需要检索 1关键字检索不能为空', trigger: 'blur'}
          ],
          attrType: [
            {required: true, message: '下拉框展示给商家选择不能为空', trigger: 'blur'}
          ],
          attrInputType: [
            {required: true, message: '2多行文本框,平台属性录入方式不能为空', trigger: 'blur'}
          ],
          attrValues: [
            {required: true, message: '可选值列表不能为空', trigger: 'blur'}
          ],
          order: [
            {required: true, message: '属性排序不能为空', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      init(row) {
        this.dataForm = new goodAttribute();
        this.dataForm.attrId = row ? row.attrId : 0;
        this.visible = true;
        this.categoryList = JSON.parse(sessionStorage.getItem("categoryList"));
        this.checkList = [];
        //初始化checkBox值
        this.$nextTick(() => {
            // this.$refs['dataForm'].resetFields();
            if (this.dataForm.attrId) {
              this.dataForm = row;
              this.dataForm.attrIndex = row.attrIndex == 1 ? true : false;
              this.dataForm.attrType = row.attrType == 1 ? true : false;
            }
          }
        )
      },
      // 表单提交
      dataFormSubmit() {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            var params = {
              'attrId': this.dataForm.attrId || undefined,
              'attrName': this.dataForm.attrName,
              'typeId': this.dataForm.typeId,
              'attrIndex': this.dataForm.attrIndex == true ? 1 : 0,
              'attrType': this.dataForm.attrType == true ? 1 : 0,
              'attrInputType': this.dataForm.attrInputType,
              'attrValues': this.dataForm.attrValues,
              'order': this.dataForm.order
            }
            var tick = !this.dataForm.attrId ? API.goodsattribute.add(params) : API.goodsattribute.update(params)
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
      ,
      // 菜单树选中
      categoryListTreeCurrentChangeHandle(data, node) {
        // console.log(data);
        this.dataForm.typeId = data.id
        this.dataForm.typeName = data.name
      }
      ,

    }
  }
</script>
