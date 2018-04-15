package com.base.api.common.constants;


import com.base.api.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

public class Constants {

	/**
	 * 默认编码
	 */
	public static final String CHARSET_UTF8 = "UTF-8";

	/**
	 * 分隔符
	 */
	public static final String SPLIT = "|";
	
	/**
	 * token
	 */
	public static final String TOKEN = "token";
	
	/**
	 * 用户数据
	 */
	public static final String USER_DATA = "tokenData";
	
	/**
	 * 签名
	 */
	public static final String SIGN = "sign";

	/**
	 * 分页大小
	 */
	public static final Integer PAGE_SIZE = 20;
	/**
	 * 10分页大小
	 */
	public static final Integer MID_PAGE_SIZE = 10;
	/**
	 * 通告数据3条
	 */
	public static final Integer MIN_NOTICE_SIZE =3;
	/**
	 * 通告数据5条
	 */
	public static final Integer MID_NOTICE_SIZE =5;
	/**
	 * 最小项目条数5
	 */
	public static final Integer MIN_PROJECT_SIZE =5;
	/**
	 * 最小新闻条数4
	 */
	public static final Integer MIN_ARTICLE_SIZE =4;

	/**
	 * 红包分页大小
	 */
	public static final Integer COUPON_PAGE_SIZE = 10;

	
	/**
	 * 起始页 
	 * */
	public static final Integer PAGE_NO = 1;	
	
	/**
	 * 状态 启用
	 */
	public static final Short STATUS_ZERO = 0;

	/**
	 * 状态 禁用
	 */
	public static final Short STATUS_ONE = 1;
	
	/***默认SPV用户ID**/
	public static final Long DEFAULT_SPV_USER_ID = 1000008L;
	
	/**
	 * 注册初始体验金
	 */
	public static final BigDecimal TRIAL_AWARD = new BigDecimal(0);
	
		
	/**返回稳赚计划显示尾单返利的剩余可投限额*/
	public static final BigDecimal PROJECT_SHOW_LAST_RETURN_LIMIT = new BigDecimal(100000);
	
	/** 精选首页标*/
	public static final String HOT_WORDS = "热卖";
	
	/**
	 * 本次银行卡鉴权未通过，请点击下方按钮再次尝试。如仍未通过，请致电客户400-667-0571，感谢您的支持！
	 */
	public static final String AUTH_BANK_CARD_ERROR_MSG = "本次银行卡鉴权未通过，请点击下方按钮再次尝试。如仍未通过，请致电客户400-667-0571，感谢您的支持！";
	
	public static final BigDecimal ONE_AMOUNT = new BigDecimal(1);
	
	public static final BigDecimal ONE_PLUS_AMOUNT = new BigDecimal(10000);
	
	
	/**
	 * 交易密码长度
	 */
	public static final int PAY_PASSWORD_LENGTH = 6;

	/**
	 * 请求头
	 */
	public static final String API_ACCEPT_VERSION = "accept-version";

	/**
	 * 请求时间
	 */
	public static final String API_REQUEST_TIME = "request-time";

	/**
	 * 设备型号
	 */
	public static final String API_DEVICE = "device";

	/**
	 * 设备类型 1:andriod, 2:ios
	 */
	public static final String API_DEVICE_TYPE = "device-type";
	
	/**
	 * 设备类型:android
	 */
	public static final int API_DEVICE_TYPE_ANDRIOD = 1;
	
	/**
	 * 设备类型:IOS
	 */
	public static final int API_DEVICE_TYPE_IOS = 2;
	
	
	/**
	 * 设备类型:H5(Wap)
	 */
	public static final int API_DEVICE_TYPE_WAP = 4;
	

	/**
	 * 设备序列
	 */
	public static final String API_DEVICE_SERIAL_NUMBER = "device-serial-number";

	/**
	 * 系统版本
	 */
	public static final String APP_VERSION = "app-version";

	/**
	 * 登录ID
	 */
	public static final String API_MEMBER_ID = "login_member_id";

	/**
	 * Token
	 */
	public static final String API_TOKEN = "token";

	/**
	 * 手机号
	 */
	public static final String API_MEMBER_MOBILE = "login_member_mobile";

	/**
	 * 金额格式化 ###,###.00
	 */
	public static final String BIGDECIMAL_FORMAT_01 = "###,###.00";

	/**
	 * 金额格式化 ###.00
	 */
	public static final String BIGDECIMAL_FORMAT_02 = "###.00";

	/**
	 * 金额格式化 0.00
	 */
	public static final String BIGDECIMAL_FORMAT_03 = "0.00";

	/**
	 * 极光registrationId
	 */
	public static final String API_CHANNEL_ID = "channel-id";
	
	/**
	 * 客户机的IP
	 */
	public static final String API_IP = "ip";

	/**
	 * 免平台服务费用50%
	 */
	public static final BigDecimal PLATFORM_SERVICE_FEES = new BigDecimal(0.5);

	/**
	 * 每小时可获得验证码的数量
	 */
	public static final int HOUR_SMS_NUMBER = 10;

	/**
	 * 登录校验次数
	 */
	public static final int LOGIN_CHECK_NUMBER = 3;

	/**
	 * 连连支付ID前缀
	 */
	public static final String LL_PAY_PREFIX = "LL";

	/**
	 * 最大委托数量
	 */
	public static final int MAX_ENTRUST_NUMBER = 3;

	/**
	 * 最小委托金额
	 */
	public static final BigDecimal MIN_ENTRUST_AMOUNT = new BigDecimal(100);

	/**
	 * 活期利率
	 */
	public static final Double BANK_RATE = 0.3;

	/**
	 * 活期产品ID
	 */
	public static final Long CURRENT_PRODUCT_ID = 1L;

	/**
	 * 婚宴
	 */
	public static final String WEDDING = "wedding";

	/**
	 * 婚宴最低手续费
	 */
	public static final BigDecimal WEDDING_FEE = new BigDecimal(800);

	/**
	 * 婚宴还款期限
	 */
	public static final int WEDDING_TO_PAY_DAYS = 15;

	/**
	 * 合同中的利率
	 */
	public static final BigDecimal RATE_OF_CONTRACT = new BigDecimal(0.5);

	/**
	 * 活期产品年利率
	 */
	public static final BigDecimal CURRENT_PRODUCT_RATE = new BigDecimal(8.18);

	/**
	 * IOS提交默认使用账户
	 */
	public static String IOS_TEST_DEFAULT_MOBILE = "18324448688";

	/**
	 * ANDROID提交默认使用账户
	 */
	public static String ANDROID_TEST_DEFAULT_MOBILE = "18368849613";

	/**
	 * IOS提交默认使用账户短信码
	 */
	public static String IOS_TEST_DEFAULT_CODE = "888888";

	/**
	 * 提现最低金额
	 */
	public static final BigDecimal WITHDRAW_MIN_AMOUNT = new BigDecimal(100);

	/**
	 * 日提现最多次数
	 */
	public static final int DAY_WITHDRAW_MAX_NUMBER = 3;

	/**
	 * 单笔最高金额
	 */
	public static final BigDecimal SINGLE_WITHDRAW_MAX_AMOUNT = new BigDecimal(
			50000);
	
	/**
	 * 每天单笔最高金额
	 */
	public static final BigDecimal DAILY_WITHDRAW_MAX_AMOUNT = new BigDecimal(
			50000);

	/**
	 * 当日提现最多金额
	 */
	public static final BigDecimal WITHDRAW_MAX_AMOUNT = new BigDecimal(100000);

	/**
	 * 稳赚计划订单编号的前缀
	 */
	public static final String ORDER_NO_PREFIX_WEIZHUAN = "W";
	
	/**
	 * 银行卡支付最低额度
	 */
	public static final BigDecimal PAY_MIN_AMOUNT = new BigDecimal(2);
	
	/**
	 * 爱家宝每梯度销售总额度
	 */
	public static final BigDecimal INVEST_TOTAL_AMOUNT = new BigDecimal(1000000);
	
	/**
	 * 跳转Web支付
	 */
	public static final boolean IS_WEB_PAY = false;
	
	/**
	 * android设备序列imei
	 */
	public static final String API_DEVICE_IMEI = "device-imei";
	
	/**
	 * 回退订单状态
	 */
	public static final int RETURN_ID = -100;
	
	/**
	 * 赠送iphone产品id
	 */
	public static final int IPHONE_PRODUCT_ID = 12;

	public static final int AIJIABAO_ORDER_BEGIN = 870428;
	
	public static final Date MEMBER_DAY_START_TIME = DateUtils.getDateWithDateStr("2017-05-18 00:00:00");

	public static final Date MEMBER_DAY_END_TIME = DateUtils.getDateWithDateStr("2017-05-19 00:00:00");

	public static final String RESET_PAY_PWD_TOKEN_KEY = "88888888";
}
