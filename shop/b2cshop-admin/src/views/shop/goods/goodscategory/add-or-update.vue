<template>
  <el-dialog
    width="60%"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()">
      <el-form-item>
        <el-col :span="10">
          <el-form-item label="名称" label-width="120px">
            <el-input v-model="dataForm.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item label="手机端显示名称" label-width="120px">
            <el-input v-model="dataForm.mobileName"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="上级名称" label-width="120px">
        <el-col :span="10">
          <el-popover
            ref="categoryListPopover"
            placement="bottom-end"
            trigger="click">
            <div style="height:300px;overflow: auto">
            <el-tree
              :data="categoryList"
              :props="categoryListTreeProps"
              node-key="menuId"
              ref="categoryListTree"
              @current-change="categoryListTreeCurrentChangeHandle"
              :default-expand-all="true"
              :highlight-current="true"
              :expand-on-click-node="false">
            </el-tree>
            </div>
          </el-popover>
          <el-input v-model="dataForm.parentName" v-popover:categoryListPopover :readonly="true" placeholder="点击选择上级菜单" class="menu-list__input"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item style="margin-left: 100px;">
        <el-col :span="8">
          <el-checkbox-group v-model="checkList">
            <el-checkbox label="是否展示" name="isShow"></el-checkbox>
            <el-checkbox label="是否热门" name="isHot"></el-checkbox>
          </el-checkbox-group>
        </el-col>
        <el-col :span="10">
          <el-form-item label="排序" label-width="120px">
            <el-input v-model="dataForm.sortOrder"></el-input>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-form-item label="分类图片" label-width="120px">
          <el-upload
            class="category-uploader"
            :action="url"
            :show-file-list="false"
            :on-success="handleSuccess"
            :before-upload="beforeUpload">
            <img :src="dataForm.image" class="category-image"/>
          </el-upload>
        </el-form-item>
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

  var data_form = {
    id: 0,
    name: '',
    mobileName: '',
    parentId: '',
    parentIdPath: '',
    level: '',
    sortOrder: '',
    isShow: '',
    image: '',
    isHot: '',
    catGroup: '',
    commission: '',
    commissionRate: '',
    typeId: ''
  }
  export default {
    data() {
      return {
        visible: false,
        checkList: [],
        categoryList: [],
        categoryListTreeProps:{
          label: 'name',
          children: 'children'
        },
        url: '',
        dataForm: data_form,
        dataRule: {
          name: [
            {required: true, message: '商品分类名称不能为空', trigger: 'blur'}
          ],
          mobileName: [
            {required: true, message: '手机端显示的商品分类名不能为空', trigger: 'blur'}
          ],
          parentId: [
            {required: true, message: '父id不能为空', trigger: 'blur'}
          ],
          isShow: [
            {required: true, message: '是否显示不能为空', trigger: 'blur'}
          ],
          isHot: [
            {required: true, message: '是否推荐为热门分类不能为空', trigger: 'blur'}
          ]
        }
      }
    },

    methods: {
      addInit() {
        // console.log(sessionStorage.getItem("categoryList"))
        //清空一下缓存
        this.dataForm = data_form;
        this.checkList = [];
        this.visible = true;
        this.url = API.oss.upload(this.$cookie.get('token'));
        this.categoryList=JSON.parse(sessionStorage.getItem("categoryList"));
      },
      init(row) {
        this.url = API.oss.upload(this.$cookie.get('token'));
        this.dataForm.id = row.id || 0;
        //清空一下缓存
        this.dataForm = {};
        this.checkList = [];
        this.dataForm = row;
        this.categoryList=JSON.parse(sessionStorage.getItem("categoryList"));
        if (row.isShow == 1) {
          this.checkList.push("是否展示");
        }
        if (row.isHot == 1) {
          this.checkList.push("是否热门");
        }
        this.visible = true;

      },
      // 表单提交
      dataFormSubmit() {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            var params = {
              'id': this.dataForm.id || undefined,
              'name': this.dataForm.name,
              'mobileName': this.dataForm.mobileName,
              'parentId': this.dataForm.parentId,
              'level': this.dataForm.level,
              'sortOrder': this.dataForm.sortOrder,
              'isShow': this.dataForm.isShow,
              'image': this.dataForm.image,
              'isHot': this.dataForm.isHot
            }
            var tick = !this.dataForm.id ? API.goodscategory.add(params) : API.goodscategory.update(params)
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
      handleSuccess(res) {
        // console.log(res);
        if (res && res.code === 0) {
          this.dataForm.image = res.url;
        } else {
          this.$message.error(response.msg)
        }
      },
      beforeUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },
      // 菜单树选中
      categoryListTreeCurrentChangeHandle (data, node) {
        this.dataForm.parentId = data.menuId
        this.dataForm.parentName = data.name
      },
      // // 菜单树设置当前选中节点
      // categoryListTreeSetCurrentNode () {
      //   this.$refs.categoryListTree.setCurrentKey(this.dataForm.parentId)
      //   this.dataForm.parentName = (this.$refs.categoryListListTree.getCurrentNode() || {})['name']
      // },
    }
  }
</script>
<style>
  .category-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .category-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .category-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }

  .category-image {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
