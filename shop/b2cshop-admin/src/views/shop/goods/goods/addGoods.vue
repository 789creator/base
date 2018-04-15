<template>
  <div>
    <ul class="tabs">
      <li class="li-tab" v-for="(item,index) in tabsParam"
          @click="toggleTabs(index)"
          :class="{active:index==nowIndex}">{{item}}
      </li>
    </ul>
    <div>
      <div id="divTab_0" class="divTab" v-show="nowIndex===0" style="min-height: 1200px">
        <div>
          <span>商品名称:</span>
          <el-input v-model="formData.goodsName" class="input_width"></el-input>
          <div class="explain_width"><span class="explain_fontSize">商品标题名称长度至少3个字符，最长50个汉字</span></div>
        </div>
        <div>
          <span>商品简介:</span>
          <el-input type="textarea" autosize v-model="formData.goodsRemark" class="input_width"></el-input>
          <div class="explain_width"><span class="explain_fontSize">商品简介最长不能超过140个汉字</span></div>
        </div>
        <div>
          <span>所属分类:</span>
          <div style="display: inline-block">
            <el-cascader
              class="input_width"
              :options="categoryList"
              :props="props"
              v-model="selectedOptions"
              @change="handleChange">
            </el-cascader>
          </div>
          <div class="explain_width"><span class="explain_fontSize"></span></div>
        </div>
        <div>
          <span>售价：</span>
          <el-input autosize v-model="formData.shopPrice" class="input_width"></el-input>
          <div class="explain_width"><span class="explain_fontSize">价格必须是0.01~9999999之间的数字。此价格为商品实际销售价格，如果商品存在规格，该价格显示最低价格。该价格影响到积分赠送</span>
          </div>
        </div>
        <div>
          <span>市场价：</span>
          <el-input autosize v-model="formData.marketPrice" class="input_width"></el-input>
          <div class="explain_width"><span
            class="explain_fontSize">价格必须是0.01~9999999之间的数字，此价格仅为市场参考售价，请根据该实际情况认真填写。</span></div>
        </div>
        <div>
          <span>成本价：</span>
          <el-input autosize v-model="formData.costPrice" class="input_width"></el-input>
          <div class="explain_width"><span class="explain_fontSize">价格必须是0.00~9999999之间的数字，此价格为商户对所销售的商品实际成本价格进行备注记录，非必填选项，不会在前台销售页面中显示。</span>
          </div>
        </div>
        <div>
          <span>商品图片：</span>
          <el-upload
            class="upload-demo"
            :action="url"
            :on-preview="handleUploadPreview"
            :on-remove="handleUploadRemove"
            :file-list="fileUploadList"
            :on-success="uploadSuccess"
            list-type="picture">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="explain_width"><span class="explain_fontSize">上传商品默认主图，如多规格值时将默认使用该图或分规格上传各规格主图；支持jpg、gif、png格式上传或从图片空间中选择，建议使用尺寸800x800像素以上、大小不超过1M的正方形图片，上传后的图片将会自动保存在图片空间的默认分类中。</span>
            </div>
          </el-upload>
        </div>
        <div>
          <span>库存总数：</span>
          <el-input autosize v-model="formData.storeCount" class="input_width"></el-input>
          <div class="explain_width"><span class="explain_fontSize">商铺库存数量必须为0~999999999之间的整数
若启用了库存默认配置，则系统自动计算商品的总数，此处无需卖家填写</span>
          </div>
        </div>
        <div>
          <span>赠送积分：</span>
          <el-input autosize v-model="formData.giveIntegral" class="input_width"></el-input>
          <div class="explain_width"><span class="explain_fontSize">可赠送积分不能超过0
购买商品赠送用户积分，积分比例1元:10分</span>
          </div>
        </div>
        <div>
          <span>兑换积分：</span>
          <el-input autosize v-model="formData.exchangeIntegral" class="input_width"></el-input>
          <div class="explain_width"><span class="explain_fontSize">兑换该商品可使用多少积分，积分比例1元:10分</span>
          </div>
        </div>
        <div>
          <span>商品关键词：</span>
          <el-input v-model="formData.keywords" class="input_width"></el-input>
          <div class="explain_width"><span class="explain_fontSize">多个关键词，用空格隔开</span>
          </div>
        </div>
        <div>
          <span>虚拟商品：</span>
          <div style="width: 200px">
            <el-radio v-model="formData.isVirtual" :label="1">是</el-radio>
            <el-radio v-model="formData.isVirtual" :label="0">否</el-radio>
          </div>
          <div class="explain_width"><span class="explain_fontSize">*虚拟商品不能参加限时折扣和组合销售两种促销活动。也不能赠送赠品和推荐搭配。
*勾选发布虚拟商品后，该商品交易类型为“虚拟兑换码”验证形式,无需物流发货。</span>
          </div>
        </div>
        <div>
          <span>商品详情：</span>
          <quill-editor
            style="width: 800px;"
            v-model="formData.content"
            placeholder="请输入商品详情"></quill-editor>
        </div>
        <div>
          <span></span>
          <div class="footer" style="width: 200px">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="onSubmit">确 定</el-button>
          </div>
        </div>
      </div>
      <div id="divTab_1" class="divTab" v-show="nowIndex===1" style="min-height: 800px">
        <div>
          <span>商品图片：</span>
          <el-upload
            ref="uploadShopImage"
            :auto-upload="false"
            :action="url"
            :on-preview="handleUploadPreview"
            :on-remove="handleUploadRemove"
            :file-list="fileUploadList"
            :on-success="uploadSuccess"
            list-type="picture">
            <el-button slot="trigger" size="small" type="primary">选择图片</el-button>
            <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUploadShopImage">上传到服务器
            </el-button>
            <div slot="tip" class="explain_width"><span class="explain_fontSize">上传商品默认主图，如多规格值时将默认使用该图或分规格上传各规格主图；支持jpg、gif、png格式上传或从图片空间中选择，建议使用尺寸800x800像素以上、大小不超过1M的正方形图片，上传后的图片将会自动保存在图片空间的默认分类中。</span>
            </div>
          </el-upload>
        </div>
      </div>
      <div id="divTab_2" class="divTab" v-show="nowIndex===2">
        <div>
          <span>操作提示：</span>
          <div class="explain_width"><span class="explain_fontSize">
          发布商品时, 如果规格没有显示出来请检查以下步骤
          1、"通用信息"选项卡中是否选择商品分类
          2、如果已经选择商品分类, 请在总平台确认商品分类是否关联商品模型
          3、如果分类已经关联商品模型, 请检查商品模型是否关联规格</span></div>
        </div>
        <div>
          <span>商品规格</span>
        </div>
        <div v-for="spec in specList">
          <span>{{spec.name}}:</span>
          <div>
            <div class="explain_width">
              <el-select @change="selectSpecVal" v-model="spec.selectedSpecVal" placeholder="请选择">
                <el-option v-for="(item,index) in spec.specValList"
                           :key="index"
                           :label="item.specValName"
                           :value="spec.id+':'+item.specValName"
                >
                </el-option>
              </el-select>
            </div>
          </div>

        </div>
      </div>
      <div id="divTab_3" class="divTab" v-show="nowIndex===3">我是tab4</div>
    </div>

  </div>
</template>

<script>
  import API from '@/api'
  import {formatDate} from '../../../../utils/date.js'
  import {treeDataTranslate} from '@/utils'
  import {quillEditor} from 'vue-quill-editor'
  import 'quill/dist/quill.core.css'
  import 'quill/dist/quill.snow.css'
  import 'quill/dist/quill.bubble.css'

  export default {
    data() {
      return {
        url: "",
        tabsParam: ['通用信息', '商品相册', "商品规格", "商品属性"],//（这个也可以用对象key，value来实现）
        nowIndex: 0,//默认第一个tab为激活状态
        categoryList: [],
        selectedOptions: [],
        props: {
          label: "name",
          value: "id"
        },
        formData: {
          goodsName: "",
          goodsRemark: "",
          costPrice: 0,
          marketPrice: 0,
          shopPrice: 0,
          storeCount: 0,
          giveIntegral: 0,
          exchangeIntegral: 0,
          keywords: "",
          isVirtual: 0,
          content: "",
        },
        fileUploadList: new Array(),
        specList: []
      }
    },
    filters: {
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh : mm');
      },

    },
    components: {
      quillEditor
    },
    activated() {
      this.init();
    },
    methods: {
      toggleTabs: function (index) {
        this.nowIndex = index;
      },
      handleChange(value) {
        this.specList = []
        var params = {
          cat_id1: value[0],
          cat_id2: value[1],
          cat_id3: value[2]
        }
        API.spec.listSpecByIds(params).then(({data}) => {
          if (data && data.code === 0) {
            this.specList = data.list;
          }
        });
      },
      init() {

        this.url = API.oss.upload(this.$cookie.get('token'));
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
      },
      handleUploadRemove(file, fileList) {
        // console.log( file,fileList);
      },
      handleUploadPreview(file) {
        console.log(file);
      },
      uploadSuccess(res) {
        // console.log(res)
        // console.log("before"+JSON.stringify(this.fileUploadList));
        if (res.code == 0) {
          this.fileUploadList.push({url: res.url});
        }
        // console.log("after"+JSON.stringify(this.fileUploadList))
      },
      onSubmit() {

      },
      submitUploadShopImage() {
        this.$refs.uploadShopImage.submit();
      },
      selectSpecVal(item) {
        console.log(item)
      },
      handleCloseTag() {

      }
    }
  }
</script>
<style>
  .active {
    background: #4b8ef7;
  }

  .tabs {
    display: inline-block;
    text-align: center;
  }

  .li-tab {
    padding: 10px;
    width: 100px;
    height: 100%;
    display: inline-block;
    text-align: center;
    border: solid 1px #23ce14;
  }

  .divTab {
    width: 200px;
    height: 300px;
  }

  .input_width {
    width: 320px;
  }

  .explain_fontSize {
    font-size: 12px;
    color: #8c939d;
  }

  .explain_width {
    width: 620px;
  }

  .divTab {

  }

  .divTab > div {
    display: inline-block;
    margin: 6px 4px 4px 40px;
  }

  .divTab > div > span:first-child {
    width: 80px;
    float: left;
    margin-top: 10px;
  }

  .divTab > div > div:first-child {
    display: inline-block;
    margin: 6px 4px 4px 40px;
  }

  .divTab > div > div:last-child {
    margin: 6px 4px 4px 80px;
  }
</style>
