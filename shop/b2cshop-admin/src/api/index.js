import * as common from './modules/common'
import * as user from './modules/user'
import * as role from './modules/role'
import * as menu from './modules/menu'
import * as log from './modules/log'
import * as config from './modules/config'
import * as oss from './modules/oss'
import * as schedule from './modules/schedule'
import * as goods from './modules/shop/goods/goods'
import * as goodscategory from './modules/shop/goods/goodscategory'
import * as goodsattribute from './modules/shop/goods/goodsattribute'
import * as goodstype from './modules/shop/goods/goodstype'
import * as spec from './modules/shop/goods/spec'

export default {
  common,     // 公共
  user,       // 管理员管理
  role,       // 角色管理
  menu,       // 菜单管理
  log,        // 系统日志
  config,     // 参数管理
  oss,        // 文件服务
  schedule,    // 定时任务
  goods,    // 商品
  goodscategory,    // 商品分类
  goodsattribute,    // 商品属性
  goodstype,    // 商品模型
  spec    // 商品规格
}
