<template>
  <el-dialog
    title="详情"
    width="60%"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm">
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
          <el-input v-model="dataForm.parentName"></el-input>
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
          <img :src="dataForm.image" width="200px"/>
        </el-form-item>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
  import API from '@/api'

  export default {
    data() {
      return {
        visible: false,
        checkList: [],
        dataForm: {
          name: '',
          mobileName: '',
          parentName: '',
          sortOrder: '',
          image: ''
        }
      }
    },
    components: {},
    activated() {
    },
    methods: {
      init(row) {
        //清空一下缓存
        this.dataForm = {};
        this.checkList = [];

        this.dataForm = row;
        if (row.isShow == 1) {
          this.checkList.push("是否展示");
        }
        if (row.isHot == 1) {
          this.checkList.push("是否热门");
        }
        // console.log(row)
        this.visible = true;
      }

    }
  }
</script>

