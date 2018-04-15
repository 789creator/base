<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('shop:goodscategory:save')" type="primary" @click="addHandle()">新增</el-button>
        <el-button v-if="isAuth('shop:goodscategory:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="商品分类id">
      </el-table-column>
      <table-tree-column
        prop="name"
        header-align="center"
        align="center"
        treeKey="id"
        width="140"
        label="分类名称">
      </table-tree-column>
      <el-table-column
        prop="mobileName"
        header-align="center"
        align="center"
        width="140"
        label="手机端显示分类名">
      </el-table-column>
      <el-table-column
        prop="sortOrder"
        header-align="center"
        align="center"
        label="顺序排序">
      </el-table-column>
      <el-table-column
        prop="isShow"
        header-align="center"
        align="center"
        label="是否显示">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.isShow == 0" type="warning">否</el-tag>
          <el-tag v-else-if="scope.row.isShow == 1" type="success">是</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="image"
        header-align="center"
        align="center"
        label="分类图片">
        <template slot-scope="scope">
          <img :src="scope.row.image" width="50px"/>
        </template>
      </el-table-column>
      <el-table-column
        prop="isHot"
        header-align="center"
        align="center"
        label="是否热门">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.isHot == 0" type="warning">否</el-tag>
          <el-tag v-else-if="scope.row.isHot == 1" type="success">是</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="220"
        label="操作">
        <template slot-scope="scope">
          <el-button  size="mini" type="info" @click="detailHandle(scope.row)">详情</el-button>
          <el-button  size="mini" type="warning" @click="updateHandle(scope.row)">修改</el-button>
          <el-button  size="mini" type="danger" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--<el-pagination-->
      <!--@size-change="sizeChangeHandle"-->
      <!--@current-change="currentChangeHandle"-->
      <!--:current-page="pageIndex"-->
      <!--:page-sizes="[10, 20, 50, 100]"-->
      <!--:page-size="pageSize"-->
      <!--:total="totalPage"-->
      <!--layout="total, sizes, prev, pager, next, jumper">-->
    <!--</el-pagination>-->
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
    <category-detail v-if="detailVisible" ref="categoryDetail" @refreshDataList="getDataList"></category-detail>
  </div>
</template>

<script>
  import API from '@/api'
  import { treeDataTranslate } from '@/utils'
  import AddOrUpdate from './add-or-update'
  import CategoryDetail from './category-detail'
  import TableTreeColumn from '@/components/table-tree-column'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false,
        detailVisible: false
      }
    },
    components: {
      AddOrUpdate,
      TableTreeColumn,
      CategoryDetail
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        var params = {

        }
        API.goodscategory.list(params).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = treeDataTranslate(data.list,'id');
            //保存到sessionStorage，以便后面操作使用
            sessionStorage.setItem("categoryList",JSON.stringify(this.dataList || '[]')) ;
          } else {
            this.dataList = []
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      updateHandle (row) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(row)
        })
      },
      // 新增 / 修改
      addHandle () {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.addInit()
        })
      },
      // 详情
      detailHandle (row) {
        // console.log(row)
        this.detailVisible = true
        this.$nextTick(() => {
          this.$refs.categoryDetail.init(row)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          API.goodscategory.del(ids).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
