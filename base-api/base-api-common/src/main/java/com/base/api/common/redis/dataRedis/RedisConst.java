package com.base.api.common.redis.dataRedis;

/**
 * redis key
 * User: guoqi
 * Date: 15/9/1
 * Time: 上午10:52
 */
public final class RedisConst {

    public static final class ExpireTime{

        /**
         * 5分钟
         */
        public static final Integer FIVE_MINTES = 300;

        /**
         * 半小时
         */
        public static final Integer HALF_HOUR = 1800;

        /**
         * 一天
         */
        public static final Integer ONE_DAY = 24*3600;

    }

//
//    enum REDIS_BUSINESS{
//        SMS("sms:{bizType}:{mobile}"), SMS_COUNT("smscount:{mobile}"), IP()
//
//    }
//


    public static final class SMS{

        /**
         *
         */
        public static final String SMS = "sms:{bizType}:{mobile}";

        /**
         *
         */
        public static final String SMS_COUNT = "sms:count:{mobile}";


        /**
         *
         */
        public  static final String IP = "sms:ip:{ip}";


        /**
         *
         */
        public static final String  SMS_VALID_COUNT = "sms:valid:count:{mobile}";

    }


    public static final class WITHDRAW{
        /**
         */
        public static final String WITHDRAW_AMOUNT = "withdraw:amount:{memberId}";

        public static final String WITHDRAW_NUM = "withdraw:num:{memberId}";
    }

    public static final class MEMBER{

        public static final String MEMBER_INFO = "member:info:{memberId}:{clientId}";


    }


    public static final class Test{
        public static final String TEST="test:{start_time}";

        public static final String TEST_PAGE="test:{page}:{number}";
    }


    /**
     * 商城相关
     */
    public static final class Mall{
        /**
         * 订单生成器
         */
        public static final String ORDER_NUM_GENERATOR="order_num_generator";
    }


    /**
     * 签到
     */
    public static final class SignIn{
        /**
         * 保存用户的连续签到次数
         */
        public static final String SIGNIN_USERKEY_CONTINUOUS_DAYS="SignIn:{userKey}:{YYYYMMDD}:continuous:days";
    }

    /**
     * 第三方平台
     */





    /**
     * 移动设备
     */
    public static final class Mobile
    {
        /**
         * 移动设备ID
         */
        public static final String MOBILE_ID = "v2:mb_id{deviceKey}{packageName}";


        /**
         * 根据SKU查询APPID
         */
        public static final String APP_ID = "v2:app_id:{sku}";
    }

    public static final class Token{

        public static final String TOKEN = "token";

    }


    /**
     * 判断获取到的url是否有效
     */
    public static final class RenameAlbumKey {
        public static final String CHECK_CURRENT_PAGE = "checkCurrentPage";
    }

    public static final class DistributedLock{

        /**
         * 播放
         */
        public static final String PLAY_CONTENT = "distributed:lock:play:content";

        public static final String PLAY_ALBUM = "distributed:lock:play:album";

        public static final String DOWNLOAD_CONTENT = "distributed:lock:download:content";

        public static final String DOWNLOAD_ALBUM = "distributed:lock:download:album";

        public static final String COLLECT_CONTENT="distributed:lock:collect:content";

        public static final String COLLECT_ALBUM="distributed:lock:collect:album";

        public static final String COMMENT_CONTENT="distributed:lock:comment:content";

    }

}
